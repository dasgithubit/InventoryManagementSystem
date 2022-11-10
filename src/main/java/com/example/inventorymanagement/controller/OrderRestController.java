package com.example.inventorymanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventorymanagement.entity.Order;
import com.example.inventorymanagement.entity.Product;
import com.example.inventorymanagement.service.OrderService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/orders")
public class OrderRestController {
	
	private OrderService orderService;

	@Autowired
	public OrderRestController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@PostMapping("/")
	public Order saveOrders(@Valid @RequestBody Order order ) {
		
		Order tOrder = orderService.saveOrUpdate(order);
		
		return tOrder;
	}

	//expose "/orders" returns list of order
	@GetMapping("/")
	public List<Order> getAllOrderDetails()
	{
		List<Order> orders = orderService.findAll();
		return orders;
	}
	

	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable Long id)
	{
		Order employee=orderService.findOrderById(id);
		return employee;
	}
	
	//expose "/" -update existing order
	@PutMapping("/")
	public Order updateOrder(@RequestBody Order order)
	{
		Order rOrder =  orderService.saveOrUpdate(order);
		System.err.println("Updated");
		return rOrder;
	}
	
	//expose "/orders/{orderId}" -delete order by Id
	@DeleteMapping("/{id}")
	public String deleteOrder(@PathVariable Long id)
	{
		Order rs = orderService.findOrderById(id);
		
		if(rs.getId()== id)
			orderService.deleteOrder(id);
		return "Order Deleted";
		
	}
	
	@GetMapping("/findByCustomerId/{id}")
	public List<Order> getAllByCustomerId(@PathVariable Long id)
	{
		List<Order> orders = orderService.findAllByCustomerId(id);
		return orders;
	}
	
	@GetMapping("/findByProductId/{id}")
	public List<Order> getAllByProductId(@PathVariable Long id)
	{
		List<Order> orders = orderService.findAllByProductId(id);
		return orders;
	}
	
	
	
	
	
	

	
	

}
