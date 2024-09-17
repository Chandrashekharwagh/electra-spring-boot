package com.electra.repository;

import com.electra.domain.Customer;
import com.electra.domain.Order;
import com.electra.domain.Product;
import com.electra.domain.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository implements OrderEntryRepository<Order> {
    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);
    private final List<Order> orderList = new ArrayList<>();
    private final List<Product> productList = new ArrayList<>();
    private final List<Customer> customerList = new ArrayList<>();
    private final List<Supplier> supplierList = new ArrayList<>();
    private int orderIndex = 0;

    public String store(Order order ,Product product ,Customer customer ,Supplier supplier) {
        logger.info("Inside OrderRepository.store()");

        int uniqueId = ++orderIndex;  // Increment orderIndex and use it for both
        order.setId(uniqueId);
        customer.setId(uniqueId);
        product.setId(uniqueId);
        supplier.setId(uniqueId);

        // Add order to their respective lists
        orderList.add(order);
        customerList.add(customer);
        productList.add(product);
        supplierList.add(supplier);

        // Log the action
        logger.info("Stored Order with ID " + order.getId() +
                " for Product with ID " + product.getId() +
                " and Customer with ID " + customer.getId() +
                " and supplier with ID " + supplier.getId());

        return "Order stored for Product ID: " + product.getId() +
                " and Customer ID: " + customer.getId() +
                " and Supplier ID: " + supplier.getId();
    }

    @Override
    public String delete(int id) {
        logger.info("Inside OrderRepository.delete()");
        // Validate the ID
        if (id < 0 || id >= orderList.size()) {
            logger.error("Invalid ID. Order not found.");
            return "Order not found";
        }
        // Remove the order from the list
        orderList.remove(id); // Assuming id is used as an index for removal
        // Log the action
        logger.info("Order with ID " + id + " removed.");

        return "Order removed";
    }

    @Override
    public List<Order> retrieve() {
        logger.info("Inside OrderRepository.retrieve()");
        for (Order order : orderList) {
            Customer customer = order.getCustomer(); // Assuming order has a getCustomer() method
            Product product = order.getProduct();// Assuming order has a getProduct() method
            Supplier supplier = order.getSupplier();// Assuming order has a getSupplier() method

            // Log details of the order along with customer and product information
            logger.info("Order: " + order.toString() +
                    ", Customer: " + (customer != null ? customer.toString() : "No Customer") +
                    ", Product: " + (product != null ? product.toString() : "No Product")+
                    ", Supplier: " + (supplier != null ? supplier.toString() : "No Product"));
        }
        return orderList;
    }

    @Override
    public String search(int index) {
        logger.info("Inside OrderRepository.search()");

        // Check if the index is valid
        if (index < 0 || index >= orderList.size()) {
            logger.error("Invalid index. Order not found.");
            return "Order not found";
        }

        // Retrieve the order and associated customer and product
        Order order = orderList.get(index);
        Customer customer = order.getCustomer(); // Assuming Order has a getCustomer() method
        Product product = order.getProduct();// Assuming Order has a getProduct() method
        Supplier supplier =order.getSupplier();// Assuming Order has a getSupplier() method

        // Construct and return the string with order, customer, and product details
        String result = "Order: " + order.toString();

        return result;
    }

    @Override
    public String update(Order order) {
        logger.info("Inside OrderRepository.update()");

        // Check if the Order is valid and its ID is within range
        if (order == null || order.getId() < 0 || order.getId() >= orderList.size()) {
            logger.error("Invalid Order ID. Update failed.");
            return "Order not found. Update failed.";
        }

        // Retrieve the existing order from the list
        Order existingOrder = orderList.get(Math.toIntExact(order.getId()));

        if (existingOrder == null) {
            logger.error("Order not found. Update failed.");
            return "Order not found. Update failed.";
        }

        // Retrieve and validate Customer and Product from the updated Order
        Customer customer = order.getCustomer();
        Product product = order.getProduct();
        Supplier supplier =order.getSupplier();

        if ((customer != null && customer.getId() <= 0) || (product != null && product.getId() <= 0)) {
            logger.error("Invalid Customer or Product ID. Update failed.");
            return "Invalid Customer or Product ID. Update failed.";
        }

        // Update the existing order details with the new data
        if (customer != null) {
            existingOrder.setCustomer(customer);
        }
        if (product != null) {
            existingOrder.setProduct(product);
        }
        if (supplier != null) {
            existingOrder.setProduct(product);
        }
        existingOrder.setOrderDate(order.getOrderDate()); // Update other relevant details as needed

        // Log the successful update
        logger.info("Order updated successfully: " + existingOrder.toString());

        return existingOrder.toString();  // Return updated order as a string representation
    }
}
