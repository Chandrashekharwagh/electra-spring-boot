package com.electra.repository;

import com.electra.domain.Customer;
import com.electra.domain.Product;
import com.electra.domain.Supplier;

import java.util.List;

public interface OrderEntryRepository<Order> {
    // Store an order with associated product and customer
    public String store(Order order , Product product , Customer customer , Supplier supplier);

    // Retrieve all orders
    public List<Order> retrieve();

    // Search for an order by its ID
    public String search(int id);

    // Delete an order by its ID
    public String delete(int id);

    // Update an existing order with new details, including product and customer
    public String update(Order order);
}
