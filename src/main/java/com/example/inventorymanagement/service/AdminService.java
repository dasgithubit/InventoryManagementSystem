package com.example.inventorymanagement.service;

import org.springframework.ui.Model;

import com.example.inventorymanagement.entity.Admin;
import com.example.inventorymanagement.entity.Order;
import com.example.inventorymanagement.entity.Product;

public interface AdminService {
	
	public String chkQuantity(Order order, Product product, Model model);

	
	
	

}
