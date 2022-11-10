package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventorymanagement.entity.Order;
import com.example.inventorymanagement.entity.Product;
import com.example.inventorymanagement.exception.DataNotFoundException;
import com.example.inventorymanagement.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	
	@Override
	public Order saveOrUpdate(Order order) {
		// TODO Auto-generated method stub
		Order tOrder = orderRepository.save(order);
		if(order == null) {
			throw new DataNotFoundException("Something is Wrong");
		}
		return tOrder;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		List<Order> orders = orderRepository.findAll();
		if(orders.size()==0)
			throw new DataNotFoundException("Currently list is empty");
		return orders;
	}

	@Override
	public Order findOrderById(Long id) {
		// TODO Auto-generated method stub
		Optional<Order> reOptional = orderRepository.findById(id);
		
		Order order = null;
		if(!reOptional.isPresent()) {
			throw new DataNotFoundException("Order is not found , whose id is "+id);
		}else {
			order = reOptional.get();
			return order;
		}
		
	}

	@Override
	public Order deleteOrder(Long id) {
		// TODO Auto-generated method stub
		Order order = findOrderById(id);
		
		if(order != null)
			orderRepository.delete(order);
		else
			throw new DataNotFoundException("Order not found!!");
		return order;
	}
	
	

	@Override
	public List<Order> findAllByCustomerId(Long id) {
		// TODO Auto-generated method stub
		List<Order> orders = orderRepository.findAllByCustomerId(id);
		
		if(orders.size()>0) {
			return orders;
		}
		else {
			throw new DataNotFoundException("This Customer "+id+" is not ordered yet!!!");
		}
		
	}

	@Override
	public List<Order> findAllByProductId(Long id) {
		// TODO Auto-generated method stub
		List<Order> orders = orderRepository.findAllByProductId(id);
		
		if(orders.size()==0)
			throw new DataNotFoundException("This product "+id+" is not available yet!!!");
		return orders;
	}

	
	
	

}

