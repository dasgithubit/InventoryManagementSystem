package com.example.inventorymanagement.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.inventorymanagement.entity.Admin;
import com.example.inventorymanagement.entity.Order;
import com.example.inventorymanagement.entity.Product;
import com.example.inventorymanagement.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService{
	
	AdminRepository adminRepository;
	
	@Autowired
	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public String chkQuantity(Order order, Product product, Model model) {
		// TODO Auto-generated method stub
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