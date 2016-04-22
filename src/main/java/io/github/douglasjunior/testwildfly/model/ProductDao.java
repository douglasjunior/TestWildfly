package io.github.douglasjunior.testwildfly.model;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author douglas
 */
@Stateless
public class ProductDao implements Serializable {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @PostConstruct
    public void init() {
        if (listAll().isEmpty()) {
            Product p1 = new Product("coca-cola", "refrigerante");
            Product p2 = new Product("negresco", "bolacha");
            Product p3 = new Product("nescau", "achocolatado");
            insert(p1);
            insert(p2);
            insert(p3);
        }
    }

    public List<Product> listAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public void insert(Product p) {
        em.persist(p);
    }

}
