package io.github.douglasjunior.testwildfly.config;

import io.github.douglasjunior.testwildfly.model.Product;
import io.github.douglasjunior.testwildfly.model.ProductDao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Douglas
 */
@Singleton
@Startup
public class DBConfig implements Serializable {

    @Inject
    private ProductDao dao;

    @PostConstruct
    public void init() {
        if (dao.listAll().isEmpty()) {
            Product p1 = new Product("coca-cola", "refrigerante");
            Product p2 = new Product("negresco", "bolacha");
            Product p3 = new Product("nescau", "achocolatado");
            dao.insert(p1);
            dao.insert(p2);
            dao.insert(p3);
        }
    }
}
