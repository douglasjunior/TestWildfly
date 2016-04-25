# TestWildfly
Projeto de teste utilizando JSF, EJB, CDI, JPA e JAX-RS com Wildfly 10.

## Instalação

1. Faça o download do Wildfly 10 no [site oficial](http://wildfly.org/downloads/) e descompacte no local desejado.
  1. Execute a primeira vez o Wildfly através do arquivo:
    - `bin/standalone.sh` no Linux ou Mac
    - `bin\standalone.bat` no Windows
  
  2. Adicione um usuário e senha para acesso ao console administrativo. Com o Wildfly rodando execute o arquivo.
    - `bin/add-user.sh` no Linux ou Mac
    - `bin\add-user.bat` no Windows
    
  3. Acesse o console administrativo através do endereço [http://localhost:9990](http://localhost:9990)

2. Adicione o `JDBC` ao Wildfly. Segue exemplo utilizando PostgreSQL.
  1. Faça o Download do driver JDBC [https://jdbc.postgresql.org/](https://jdbc.postgresql.org/)
  2. Com o Wildfly rodando, execute o arquivo `bin/jboss-cli.sh` (Linux ou Mac) ou `bin/jboss-cli.bat` (Windows).
  3. Entre com o comando `connect`.
  4. Crie um módulo para o JDBC com o comando `module add --name=org.postgres --resources=/Usuario/Downloads/postgresql-9.3-1102.jdbc41.jar --dependencies=javax.api,javax.transaction.api` (Substitua **/Usuario/Downloads/postgresql-9.3-1102.jdbc41.jar** pelo caminho onde você salvou o JDBC).
  5. Instale o driver JDBC com o comando `/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)`
  
3. Crie um novo `Datasource` utilizando o driver `JDBC` adicionado no passo anterior.
  1. Acesse o console admnistrativo do Wildfly e siga para `Configurations > Subsystems > Datasources > Non-XA > Add`
  2. Selecione `PostgreSQL Datasources`
  3. Para este exemplo preencha o **Name** como desejar e o **JNDI** como [`java:/testWildfly`](https://github.com/douglasjunior/TestWildfly/blob/master/src/main/resources/META-INF/persistence.xml)
  4. Na aba `Detected Driver` selecione `postgres`
  5. Altere a **URL** de conxeão com o nome do banco de dados desejado, informe o **usuário** e **senha** do seu PostgreSQL
  6. Clique em `Test connection` para verificar se deu tudo certo

4. Se estiver utilizando Netbeans, adicione um novo Servidor nas configurações e aponte para a pasta do Wildfly. *(não esqueça de interromper o servidor Wildfly iniciado anteriormente)*

5. Abra o projeto `TestWildfly`, execute `Limpar e construir` para baixar as dependências e por fim execute o projeto.
  1. Teste o JSF através da URL [http://localhost:8080/TestWildfly/](http://localhost:8080/TestWildfly/).
  2. Teste o JAX-RS através da URL [http://localhost:8080/TestWildfly/rest/product](http://localhost:8080/TestWildfly/rest/product).
  3. A execução da tarefa agendada é impressa no console de saída.
  

## Considerações
- A implementação JPA disponível é **Hibernate**, porém eu não obtive uma boa experiência ao tentar utilizar o **Eclipselink** com o Wildfly 10, apresar de existirem [alguns tutoriais](https://docs.jboss.org/author/display/WFLY10/JPA+Reference+Guide#JPAReferenceGuide-UsingEclipseLink) por aí, vários problemas são evidenciados.
- Devido a utilização do **Hibernate** é preciso ficar atento ao problema de `LazyInitializationException`, alguma das [soluções possíveis](http://uaihebert.com/quatro-solucoes-para-lazyinitializationexception/) deve ser utilizada.
- Tive vários problemas na integração do Wildfly 10 com o **Netbeans 8.1**, alguns travamentos no deploy que só resolvem reiniciando a ferramenta, inclusive alguns deles [já foram reportados](https://netbeans.org/bugzilla/show_bug.cgi?id=244427).
- Quem utiliza **Windows** com placa de vídeo **NVIDIA** pode ter problemas ao subir o Wildfly, pois existe um serviço chamado [`NVIDIA Network Service` que também utiliza a porta 9990](http://stackoverflow.com/questions/32017970/wildfly-9-x-startet-with-errors-address-already-in-use).
