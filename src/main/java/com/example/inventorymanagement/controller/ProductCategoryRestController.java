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

import com.example.inventorymanagement.entity.ProductCategory;
import com.example.inventorymanagement.entity.Order;
import com.example.inventorymanagement.service.CategoryService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/categorys")

public class ProductCategoryRestController {

	public ProductCategoryRestController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public List<ProductCategory> getAllCategoryDetails()
	{
		List<ProductCategory> categories = categoryService.findAll();
		return categories;
	}
	
	@PostMapping("/")
	public ProductCategory saveCategory(@Valid @RequestBody ProductCategory category) {
		ProductCategory theCategory = categoryService.saveCategorys(category);
		
		return theCategory;
	}
	
	@GetMapping("/{id}")
	public ProductCategory getCustomerById(@PathVariable Long id) {
		ProductCategory category = categoryService.findByCategoryId(id);
		return category;
	}
	
	@GetMapping("/byCategoryName/{categoryName}")
	public List<ProductCategory> getByfirstName(@PathVariable String categoryName){
		List<ProductCategory> categorys = categoryService.findByCategoryName(categoryName);
	
		return categorys ; 
	}
	
	@DeleteMapping("/{id}")
	public ProductCategory deleteCategory(@PathVariable Long id) {
		ProductCategory result = categoryService.findByCategoryId(id);
		
		if(result.getId() == id) 
			categoryService.deleteCategory(id);
			
			return result ;	
	}
	
	@PutMapping("/")
	public ProductCategory upadteCategory(@RequestBody ProductCategory category) {
		
		ProductCategory result = categoryService.saveCategorys(category);
		
		System.err.println("Updated");
		return result;
	}

	
}
