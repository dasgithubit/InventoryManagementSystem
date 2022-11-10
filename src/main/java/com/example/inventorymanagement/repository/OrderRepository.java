package com.example.inventorymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventorymanagement.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	
	public List<Order> findAllByCustomerId(Long id);
	
	public List<Order> findAllByProductId(Long id);
	
}

