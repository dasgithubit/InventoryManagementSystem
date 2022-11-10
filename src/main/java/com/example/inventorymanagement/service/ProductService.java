package com.example.inventorymanagement.service;

import java.util.List;

import com.example.inventorymanagement.entity.Product;



public interface ProductService {
	
	public List<Product> findAll();
	
    public Product findByProductId(Long product_id);
    
    
	public Product saveProducts(Product product);
	
	public Product deleteProduct(Long product_id);
	
	
	public List<Product> findByProductName(String productName);


}
