package com.example.inventorymanagement.controller;


import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventorymanagement.entity.Admin;
import com.example.inventorymanagement.entity.Order;
import com.example.inventorymanagement.entity.Product;
import com.example.inventorymanagement.service.AdminService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminRestController {
	
	@Autowired
	AdminService adminService;
	
	
	@PostMapping("/")
	public String chkQuantity(@Valid @RequestBody Admin admin, Product product, Order order, Model model) {
		order.setDateCreated(new Date());
		
		int current_stock = product.getQuantity();
		System.out.println(current_stock);
		
		int quantity = order.getTotalQuantity();
		System.out.println(quantity);
		
		if(quantity <= current_stock) {
			current_stock-=quantity;
			System.out.println("after reducing quantity: "+current_stock);
			
			product.setQuantity(quantity);
			return product.getName();
		}
		else {
			model.addAttribute("error","Quantity can got be greater than current stock");
			return "order";
			
		}
	}
	
	
	

}
