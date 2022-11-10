package com.example.inventorymanagement.controller;

import java.util.List;

//import java.util.List;

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

import com.example.inventorymanagement.entity.ProductCategory;
import com.example.inventorymanagement.entity.Order;
import com.example.inventorymanagement.entity.Product;
import com.example.inventorymanagement.service.ProductService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/products")

public class ProductRestController {

	public ProductRestController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public List<Product> getAllProductDetails()
	{
		List<Product> products = productService.findAll();
		return products;
	}
	
	@GetMapping("/byProductName/{productName}")
	public List<Product> getByfirstName(@PathVariable String productName){
		List<Product> products = productService.findByProductName(productName);
	
		return products ; 
	}
	
	@PostMapping("/")
	public Product saveProduct(@Valid @RequestBody Product product) {
		Product theProduct = productService.saveProducts(product);
		
		return theProduct;
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		Product product = productService.findByProductId(id);
		return product;
	}
	
	
	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable Long id) {
		Product result = productService.findByProductId(id);
		
		if(result.getId() == id) 
			productService.deleteProduct(id);
			
			return result ;	
	}
	
	@PutMapping("/")
	public Product upadteProduct(@RequestBody Product product) {
		
		Product result = productService.saveProducts(product);
		
		System.err.println("Updated");
		return result;
	}


}
