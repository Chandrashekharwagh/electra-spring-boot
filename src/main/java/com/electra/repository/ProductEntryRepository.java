package com.electra.repository;

import java.util.List;

public interface ProductEntryRepository<Product> {
    public String store(Product product);

    public List<Product> retrieve();

    public String search(int id);

    public String delete(int id);

    public String update(Product product);
}
