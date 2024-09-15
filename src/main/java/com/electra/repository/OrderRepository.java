package com.electra.repository;

import com.electra.domain.Customer;
import com.electra.domain.Order;
import com.electra.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository implements OrderEntryRepository<Order> {
    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);
    private final List<Order> orderList = new ArrayList<>();
    private int orderIndex = -1;

    public String store(Order order) {
        logger.info("Inside OrderRepository.store()");

        // Increment and set a unique ID for the order
        order.setId(++orderIndex);

        // Add the order to the orderList
        orderList.add(order);

        // Retrieve associated product and customer from the order
        Product product = order.getProduct(); // Assuming Order has a getProduct() method
        Customer customer = order.getCustomer(); // Assuming Order has a getCustomer() method

        // Log the action
        logger.info("Stored Order with ID " + order.getId() +
                " for Product with ID " + (product != null ? product.getId() : "None") +
                " and Customer with ID " + (customer != null ? customer.getId() : "None"));

        return "Order stored for Product ID: " + (product != null ? product.getId() : "None") +
                " and Customer ID: " + (customer != null ? customer.getId() : "None");
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
            Product product = order.getProduct();    // Assuming order has a getProduct() method

            // Log details of the order along with customer and product information
            logger.info("Order: " + order.toString() +
                    ", Customer: " + (customer != null ? customer.toString() : "No Customer") +
                    ", Product: " + (product != null ? product.toString() : "No Product"));
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
        Product product = order.getProduct();    // Assuming Order has a getProduct() method

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
        existingOrder.setOrderDate(order.getOrderDate()); // Update other relevant details as needed

        // Log the successful update
        logger.info("Order updated successfully: " + existingOrder.toString());

        return existingOrder.toString();  // Return updated order as a string representation
    }
}
