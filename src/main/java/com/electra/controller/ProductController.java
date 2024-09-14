package com.electra.controller;

import com.electra.domain.Product;
import com.electra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    //@RequestMapping(path = "/product", method = RequestMethod.GET)
    @GetMapping("/product")
    public List<Product> retrievePayments() {
        return productService.retrieveProducts();
    }

    @GetMapping("/product/{productId}")
    public String retrieveProductForProductId(@PathVariable int productId) {
        return productService.search(productId);
    }

    @DeleteMapping("/product/{productId}")
    public String deleteProductForProductId(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }

    @PostMapping("/product")
    public String addProduct(@RequestBody Product product) {
        return productService.storeProduct(product);
    }

    @PutMapping("/product/{productId}")
    public String updateProductForProductId(@PathVariable int productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }
}
