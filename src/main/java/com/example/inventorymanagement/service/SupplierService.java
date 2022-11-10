package com.example.inventorymanagement.service;

import java.util.List;

import com.example.inventorymanagement.entity.Supplier;

public interface SupplierService {
	public List<Supplier> findAll();
	
    public Supplier findBySupplierId(Long id);
	public Supplier saveSuppliers(Supplier supplier);
	
	public Supplier deleteSupplier(Long id);
	
	
	public List<Supplier> findBySupplierName(String supplierName);


}
