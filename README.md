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


2. Adicione um novo Servidor nas configurações do Netbeans e aponte para a pasta do Wildfly. *(não esqueça de interromper o servidor Wildfly iniciado anteriormente)*


3. Adicione o `JDBC` e o `Datasource` do banco de dados desejado ao Wildfly. Veja um [exemplo utilizando PostgreSQL](http://www.horochovec.com.br/blog/2014/10/07/configurando-um-datasource-do-postgresql-no-wildfly/).
  - Neste projeto o JNDI se chama [`java:/testWildfly`](https://github.com/douglasjunior/TestWildfly/blob/master/src/main/resources/META-INF/persistence.xml), lembre-se de utilizar o mesmo nome na criação do `Datasource`.

4. Execute o projeto.
  1. Teste o JSF através da URL [http://localhost:8080/TestWildfly/](http://localhost:8080/TestWildfly/).
  2. Teste o JAX-RS através da URL [http://localhost:8080/TestWildfly/rest/product](http://localhost:8080/TestWildfly/rest/product).
  3. A execução da tarefa agendada é impressa no console de saída.
  
  
## Considerações
- Não obtive uma boa experiência ao tentar utilizar o **Eclipselink** com o Wildfly 10, apresar de existirem [alguns tutoriais](https://docs.jboss.org/author/display/WFLY10/JPA+Reference+Guide#JPAReferenceGuide-UsingEclipseLink) por aí, os problemas também são evidenciados.
- Tive vários problemas na integração do Wildfly 10 com o **Netbeans 8.1**, como o travamento no deploy que só resolve reiniciando a ferramenta, inclusive alguns deles [já foram reportados](https://netbeans.org/bugzilla/show_bug.cgi?id=244427).
- Quem utiliza **Windows** com placa de vídeo **NVIDIA** pode ter problemas ao subir o Wildfly, pois existe um serviço chamado [`NVIDIA Network Service` que também utiliza a porta 9990](http://stackoverflow.com/questions/32017970/wildfly-9-x-startet-with-errors-address-already-in-use).
