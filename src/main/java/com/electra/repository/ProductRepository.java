package com.electra.repository;

import com.electra.domain.Brand;
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
    private int index = 0;
    private int brandIndex = 0;

    public String store(Product product) {
        logger.info("/inside the ProductRepository.store()");
        // Check if the product has a brand and store it if necessary
        Brand brand = product.getBrand();
        if (brand != null) {
            // Set an ID for the brand if it doesn't have one (assuming you're managing brand IDs similarly)
            if (brand.getId() == 0) {
                brand.setId(++brandIndex); // assuming brandIndex is a static field tracking brand IDs
            }
            logger.info("Storing brand: " + brand.toString());
        }
        // Store the product
        product.setId(++index); // auto-increment product ID
        productList.add(index, product);
        return product.toString();
    }

    @Override
    public String delete(int id) {
        logger.info("/inside the ProductRepository.delete()");
        // Retrieve the product by id before deletion to get its associated brand
        Product product = productList.get(id);
        if (product != null) {
            // Check if the product has a brand and handle the brand deletion if necessary
            Brand brand = product.getBrand();
            if (brand != null) {
                logger.info("Brand associated with product is: " + brand.toString());
                // Assuming you have a separate list or repository for brands, handle brand removal here
                // Example: brandList.remove(brand.getId());
                logger.info("Brand removed: " + brand.toString());
            }
            // Remove the product from the product list
            productList.remove(id);
            return "Product and associated brand removed, if any.";
        } else {
            return "Product not found";
        }
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
        // Retrieve the product by id
        Product existingProduct = productList.get(Math.toIntExact(product.getId()));
        if (existingProduct != null) {
            // Update product name if it's neither null nor empty
            if (product.getName() != null && !product.getName().isBlank()) {
                existingProduct.setName(product.getName());
            }
            // Update product description if it's neither null nor empty
            if (product.getDescription() != null && !product.getDescription().isBlank()) {
                existingProduct.setDescription(product.getDescription());
            }
            // Update product price if it's not null
            if (product.getPrice() != null) {
                existingProduct.setPrice(product.getPrice());
            }
            // Update brand if it's not null
            Brand newBrand = product.getBrand();
            if (newBrand != null) {
                Brand existingBrand = existingProduct.getBrand();
                if (existingBrand != null) {
                    // Update brand details if necessary
                    if (newBrand.getName() != null && !newBrand.getName().isBlank()) {
                        existingBrand.setName(newBrand.getName());
                    }
                    if (newBrand.getDescription() != null && !newBrand.getDescription().isBlank()) {
                        existingBrand.setDescription(newBrand.getDescription());
                    }
                } else {
                    // If brand does not exist, set the new brand
                    existingProduct.setBrand(newBrand);
                }
            }
            return existingProduct.toString();
        } else {
            return "Product not found";
        }
    }
}
