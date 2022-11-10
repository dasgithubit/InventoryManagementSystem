package com.example.inventorymanagement.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.inventorymanagement.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
	
	//Optional<Product> findProductById(Long id);

		List<Product> findByProductName(String productName);
		
		


}
