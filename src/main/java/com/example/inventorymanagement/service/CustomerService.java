package com.example.inventorymanagement.service;

import java.util.List;

import com.example.inventorymanagement.entity.Customer;
import com.example.inventorymanagement.entity.Order;



public interface CustomerService {

	
	    public List<Customer> findAll();
	    
	    public Customer findByCustomerId(Long id);
	    
		public Customer saveCustomers(Customer customer);
		
		public Customer deleteCustomer(Long id);
		
		List<Customer> findByEmailId(String emailId);
		
		public List<Customer> findByfirstName(String firstName);

	   

		

		
		
		
		
		
	}