package com.electra.service;

import com.electra.domain.Product;
import com.electra.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository repo;

    public List<Product> retrieveProducts() {
        logger.info("/inside the ProductService.retrieveProducts()");
        return repo.retrieve();
    }

    public String storeProduct(Product product) {
        logger.info("/inside the ProductService.addProduct()");;
        return repo.store(product);
    }

    public String deleteProduct(int id) {
        logger.info("/inside the ProductService.removeProduct()");
        return repo.delete(id);
    }

    public String search(int id) {
        logger.info("/inside the ProductService.search()");
        return repo.search(id);
    }

    public String updateProduct(int id, Product product) {
        logger.info("/inside the ProductService.updateProduct()");
        product.setId(id);
        return repo.update(product);
    }
}
