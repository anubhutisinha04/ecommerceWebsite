package com.example.test.service.impl;
import com.example.test.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
}




