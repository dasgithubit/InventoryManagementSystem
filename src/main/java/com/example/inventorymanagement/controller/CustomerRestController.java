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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventorymanagement.entity.Customer;
import com.example.inventorymanagement.entity.Order;
import com.example.inventorymanagement.service.CustomerService;


//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/customers")

public class CustomerRestController {

	public CustomerRestController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomerDetails()
	{
		List<Customer> customers = customerService.findAll();
		return customers;
	}
	
	@PostMapping("/register")
	public String register(@RequestBody Customer customer) {
		customerService.saveCustomers(customer);
		return "Hi " + customer.getFirstName() + "Your Registration process succeffuly completed";
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		Customer customer = customerService.findByCustomerId(id);
		return customer;
	}
	
	@GetMapping("/byCustomerName/{customerName}")
	public List<Customer> getByfirstName(@PathVariable String firstName){
		List<Customer> customers = customerService.findByfirstName(firstName);
	
		return customers ; 
	}
	
	@DeleteMapping("/cancel/{id}")
	public Customer deleteCustomer(@PathVariable Long id) {
		Customer result = customerService.findByCustomerId(id);
		
		if(result.getId() == id) 
			customerService.deleteCustomer(id);
			
			return result ;	
	}
	
	@PutMapping("/")
	public Customer upadteCustomer(@RequestBody Customer customer) {
		
	Customer result = customerService.saveCustomers(customer);
		
		System.err.println("Updated");
		return result;
	}
	
	@GetMapping("/findCustomer/{email}")
	public List<Customer> findCustomer(@PathVariable String emailId) {
		List<Customer> customers = customerService.findByEmailId(emailId);
	    return customers;
	}
}


