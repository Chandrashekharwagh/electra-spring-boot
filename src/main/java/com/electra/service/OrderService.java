package com.electra.service;

import com.electra.domain.Customer;
import com.electra.domain.Order;
import com.electra.domain.Product;
import com.electra.domain.Supplier;
import com.electra.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository repo;

    public List<Order> retrieveOrders() {
        logger.info("Inside OrderService.retrieveOrders()");

        // Retrieve the list of Orders from the repository
        List<Order> orders = repo.retrieve();

        // Log the number of Orders retrieved
        logger.info("Number of Orders retrieved: " + orders.size());

        // Return the list of Orders
        return orders;
    }

    public String storeOrder(Order order , Product product , Customer customer , Supplier supplier) {
        logger.info("/inside the OrderService.addOrder()");;
        return repo.store(order , product , customer , supplier);
    }

    public String deleteOrder(int id) {
        logger.info("/inside the OrderService.removeOrder()");
        return repo.delete(id);
    }

    public String search(int id) {
        logger.info("/inside the OrderService.search()");
        return repo.search(id);
    }

    public String updateOrder(int id, Order order) {
        logger.info("/inside the OrderService.updateOrder()");
        order.setId(id);
        return repo.update(order);
    }

}
