package com.example.lab4emt.service;

import com.example.lab4emt.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAll();
    Order save(Order order);
    Optional<Order> findById(Long id);
    void deleteById(Long id);
    Order update(Long id, Order updatedOrder);
}