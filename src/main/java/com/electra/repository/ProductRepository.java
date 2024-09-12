package com.electra.repository;

import com.electra.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ProductEntryRepository<Product>{
    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);
    private final List<Product> productList = new ArrayList<>();
    private int index = -1;

    public String store(Product product) {
        logger.info("/inside the ProductRepository.store()");
        product.setId(++index);
        productList.add(index, product);
        return product.toString();
    }

    @Override
    public String delete(int id) {
        logger.info("/inside the ProductRepository.delete()");
        productList.remove(id);
        return "product removed";
    }

    @Override
    public List<Product> retrieve() {
        logger.info("/inside the ProductRepository.retrieve()");
        return productList;
    }

    @Override
    public String search(int index) {
        logger.info("/inside the ProductRepository.search()");
        return this.productList.get(index).toString();
    }

    @Override
    public String update(Product product) {
        logger.info("/inside the ProductRepository.update()");

        // Checking if Name is neither null nor empty
        if (!(product.getName().isBlank() || product.getName().isEmpty())) {
            this.productList.get(product.getId()).setName(product.getName());
        }

        // Checking if Brand ID is valid (greater than 0)
        if (product.getBrandId() > 0) {
            this.productList.get(product.getId()).setBrandId(product.getBrandId());
        }

        return this.productList.get(product.getId()).toString();
    }
}
