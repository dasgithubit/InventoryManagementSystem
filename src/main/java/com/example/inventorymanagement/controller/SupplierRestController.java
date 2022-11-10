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
import com.example.inventorymanagement.entity.Supplier;
import com.example.inventorymanagement.service.SupplierService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/suppliers")

public class SupplierRestController {

	public SupplierRestController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	SupplierService  supplierService;
	
	@GetMapping("/")
	public List<Supplier> getAllSupplierDetails()
	{
		List<Supplier> suppliers = supplierService.findAll();
		return suppliers;
	}
	
	@PostMapping("/")
	public Supplier saveSupplier(@Valid @RequestBody Supplier supplier) {
		Supplier theSupplier = supplierService.saveSuppliers(supplier);
		
		return theSupplier;
	}
	
	@GetMapping("/{id}")
	public Supplier getSupplierById(@PathVariable Long id) {
		Supplier supplier = supplierService.findBySupplierId(id);
		return supplier;
	}
	
	@GetMapping("/bySupplierName/{supplierName}")
	public List<Supplier> getByfirstname(@PathVariable String supplierName){
		List<Supplier> suppliers = supplierService.findBySupplierName(supplierName);
	
		return suppliers ; 
	}
	
	@DeleteMapping("/{id}")
	public Supplier deleteSupplier(@PathVariable Long id) {
		Supplier result = supplierService.findBySupplierId(id);
		
		if(result.getId() == id) 
			supplierService.deleteSupplier(id);
			
			return result ;	
	}
	
	@PutMapping("/")
	public Supplier upadteSupplier(@RequestBody Supplier supplier) {
		
		Supplier result = supplierService.saveSuppliers(supplier);
		
		System.err.println("Updated");
		return result;
	}


}
