package io.github.douglasjunior.testwildfly.controller;

import io.github.douglasjunior.testwildfly.model.Product;
import io.github.douglasjunior.testwildfly.model.ProductDao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author douglas
 */
@Named
@ViewScoped
public class ProductController implements Serializable {

    @Inject
    private ProductDao dao;

    public ProductController() {
    }

    public List<Product> getProducts() {
        List<Product> result = dao.listAll();
        return result;
    }
}
