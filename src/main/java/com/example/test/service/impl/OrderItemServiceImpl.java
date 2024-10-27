package com.example.test.service.impl;
import java.util.List;

import com.example.test.exception.ResourceNotFoundException;
import com.example.test.model.OrderItem;
import com.example.test.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {


    private final OrderItemRepository orderItemRepository;


    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }


    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }


    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order item not found for this id :: " + id));
    }


    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }


    @Override
    public OrderItem updateOrderItem(Long id, OrderItem orderItemDetails) {
        OrderItem orderItem = getOrderItemById(id);
        // Update the relevant fields of orderItem with orderItemDetails
        return orderItemRepository.save(orderItem);
    }


    @Override
    public void deleteOrderItem(Long id) {
        OrderItem orderItem = getOrderItemById(id);
        orderItemRepository.delete(orderItem);
    }
}




