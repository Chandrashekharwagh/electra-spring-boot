package com.electra.repository;

import java.util.List;

public interface OrderEntryRepository<Order> {
    // Store an order with associated product and customer
    public String store(Order order);

    // Retrieve all orders
    public List<Order> retrieve();

    // Search for an order by its ID
    public String search(int id);

    // Delete an order by its ID
    public String delete(int id);

    // Update an existing order with new details, including product and customer
    public String update(Order order);
}
