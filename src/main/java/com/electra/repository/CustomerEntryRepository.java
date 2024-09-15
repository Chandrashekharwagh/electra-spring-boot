package com.electra.repository;

import com.electra.domain.Address;

import java.util.List;

public interface CustomerEntryRepository<Customer> {
    public String store(Customer customer , Address address);

    public List<Customer> retrieve();

    public String search(int customerId);

    public String delete(int id);

    public String update(Customer customer , Address address);
}
