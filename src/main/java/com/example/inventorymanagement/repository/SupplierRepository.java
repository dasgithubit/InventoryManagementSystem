package com.example.inventorymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.inventorymanagement.entity.Supplier;



public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	
	//Optional<Supplier> findSupplierById(Long id);

		List<Supplier> findBySupplierName(String supplierName);


}
