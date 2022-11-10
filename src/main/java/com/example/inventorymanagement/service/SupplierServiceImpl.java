package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventorymanagement.entity.Supplier;
import com.example.inventorymanagement.exception.DataNotFoundException;
import com.example.inventorymanagement.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	
	SupplierRepository supplierRepository;
	
    @Autowired
	public SupplierServiceImpl(SupplierRepository supplierRepository) {
		super();
		this.supplierRepository = supplierRepository;
	}

	@Override
	public List<Supplier> findAll() {
		// TODO Auto-generated method stub
		return supplierRepository.findAll();
	}

	@Override
	public Supplier findBySupplierId(Long id) {
		// TODO Auto-generated method stub
		Optional<Supplier> result = supplierRepository.findById(id);

		Supplier theSupplier = null;
		if (!result.isPresent()) {
			throw new DataNotFoundException(" Supplier is not found !!!, whose id is  " + id);

		} else {
			theSupplier = result.get();
			return theSupplier;
		}
	}

	@Override
	public Supplier saveSuppliers(Supplier suppliers) {
		// TODO Auto-generated method stub
		Supplier supplier = supplierRepository.save(suppliers);
		if (suppliers == null) {
			throw new DataNotFoundException("Something Went Wrong");
		}
		return supplier;
	}

	@Override
	public Supplier deleteSupplier(Long id) {
		// TODO Auto-generated method stub
		Supplier theSupplier= findBySupplierId(id);

		if (theSupplier != null)
			supplierRepository.delete(theSupplier);
		else
			throw new DataNotFoundException("Supplier not found!!!");
		return theSupplier;
	}

	@Override
	public List<Supplier> findBySupplierName(String supplierName) {
		// TODO Auto-generated method stub
		List<Supplier> suppliers = supplierRepository.findBySupplierName(supplierName);
		if(suppliers.size() == 0) {
			throw new DataNotFoundException("Currently this Supplier name is not available !!");
		}
		return suppliers;	
	
	}

}
