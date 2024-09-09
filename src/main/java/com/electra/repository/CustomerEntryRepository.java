package com.electra.repository;

import java.util.List;

public interface CustomerEntryRepository<Customer> {
    public String store(Customer customer);

    public List<Customer> retrieve();

    public String search(int id);

    public String delete(int id);

    public String update(Customer customer);
}
