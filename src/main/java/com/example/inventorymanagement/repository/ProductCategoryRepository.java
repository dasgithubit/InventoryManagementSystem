package com.example.inventorymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventorymanagement.entity.ProductCategory;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{
	//Optional<Customer> findCustomerById(Long id);

		List<ProductCategory> findByCategoryName(String categoryName);

		


}
