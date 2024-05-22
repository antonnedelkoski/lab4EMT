package com.example.lab4emt.service.impl;
import com.example.lab4emt.model.Order;
import com.example.lab4emt.model.Status;
import com.example.lab4emt.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements com.example.lab4emt.service.OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order save(Order order) {
        // Business rule: Ensure that the order contains at least one record
        if (order.getRecords().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one record");
        }
        // Business rule: Set default status if not already set
        if (order.getStatus() == null) {
            order.setStatus(String.valueOf(new Status("NEW")));
        }
        return orderRepository.save(order);
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public Order update(Long id, Order updatedOrder) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setOrderDate(updatedOrder.getOrderDate());
                    order.setStatus(updatedOrder.getStatus());
                    order.setRecords(updatedOrder.getRecords());
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }
}