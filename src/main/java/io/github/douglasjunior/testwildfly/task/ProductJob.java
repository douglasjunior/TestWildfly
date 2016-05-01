package io.github.douglasjunior.testwildfly.task;

import io.github.douglasjunior.testwildfly.model.Product;
import io.github.douglasjunior.testwildfly.model.ProductDao;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author douglas
 */
@Singleton
@Startup
public class ProductJob {

    @Inject
    private ProductDao dao;

    @Schedule(hour = "*", minute = "*", second = "*/5", persistent = false)
    public void task() {
        List<Product> result = dao.listAll();
        System.out.println("Task products: " + result);
    }

}
