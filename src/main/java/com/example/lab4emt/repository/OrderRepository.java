package com.example.lab4emt.repository;
import com.example.lab4emt.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // You can define custom query methods here if needed
}