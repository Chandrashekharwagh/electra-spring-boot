package com.electra.controller;

import com.electra.domain.Order;
import com.electra.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    //@RequestMapping(path = "/order", method = RequestMethod.GET)
    @GetMapping("/order")
    public List<Order> retrieveCustomers() {
        return orderService.retrieveOrders();
    }

    @GetMapping("/order/{orderId}")
    public String retrieveOrderForOrderId(@PathVariable int orderId) {
        return orderService.search(orderId);
    }

    @DeleteMapping("/order/{orderId}")
    public String deleteOrderForOrderId(@PathVariable int orderId) {
        return orderService.deleteOrder(orderId);
    }

    @PostMapping("/order")
    public String addOrder(@RequestBody Order order) {
        return orderService.storeOrder(order);
    }

    @PutMapping("/order/{orderId}")
    public String updateOrderForOrderId(@PathVariable int orderId, @RequestBody Order order) {
        return orderService.updateOrder(orderId, order);
    }
}
