package io.github.douglasjunior.testwildfly.service;

import io.github.douglasjunior.testwildfly.model.Product;
import io.github.douglasjunior.testwildfly.model.ProductDao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author douglas
 */
@Stateless
@Path("product")
public class ProductResource implements Serializable {

    @Inject
    private ProductDao dao;

    @GET
    @Produces("application/json")
    public List<Product> findAll() {
        return dao.listAll();
    }

}
