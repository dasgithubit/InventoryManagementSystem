package com.example.inventorymanagement.service;

import java.util.List;

import com.example.inventorymanagement.entity.Order;
import com.example.inventorymanagement.entity.Product;

public interface OrderService {
	
	public Order saveOrUpdate(Order order);
	
	public List<Order> findAll();
	
	public Order findOrderById(Long id);
	
	public Order deleteOrder(Long id);
	
	public List<Order> findAllByCustomerId(Long id);
	
	public List<Order> findAllByProductId(Long id);
	
	

	
}

