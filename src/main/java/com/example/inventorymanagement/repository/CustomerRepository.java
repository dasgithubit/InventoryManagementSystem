package com.example.inventorymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventorymanagement.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long>{

	//Optional<Customer> findCustomerById(Long id);

	List<Customer> findByfirstName(String firstName);
	
	List<Customer> findByEmailId(String emailId);

}