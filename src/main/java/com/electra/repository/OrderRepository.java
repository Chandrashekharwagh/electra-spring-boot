package com.electra.repository;

import com.electra.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository implements  OrderEntryRepository<Order>{
    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);
    private final List<Order> orderList = new ArrayList<>();
    private int index = -1;

    public String store(Order order) {
        logger.info("/inside the OrderRepository.store()");
        order.setId(++index);
        orderList.add(index, order);
        return order.toString();
    }

    @Override
    public String delete(int id) {
        logger.info("/inside the OrderRepository.delete()");
        orderList.remove(id);
        return "order removed";
    }

    @Override
    public List<Order> retrieve() {
        logger.info("/inside the OrderRepository.retrieve()");
        return orderList;
    }

    @Override
    public String search(int index) {
        logger.info("/inside the OrderRepository.search()");
        return this.orderList.get(index).toString();
    }

    @Override
    public String update(Order order) {
        logger.info("/inside the OrderRepository.update()");
        // Check if the productId is valid (greater than 0)
        if (order.getProductId() > 0) {
            order.setProductId(order.getProductId());
        }
        return order.toString();
    }
}
