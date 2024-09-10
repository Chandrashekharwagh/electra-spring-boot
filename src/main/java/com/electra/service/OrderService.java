package com.electra.service;

import com.electra.domain.Order;
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
        logger.info("/inside the OrderService.retrieveOrders()");
        return repo.retrieve();
    }

    public String storeOrder(Order order) {
        logger.info("/inside the OrderService.addOrder()");;
        return repo.store(order);
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
