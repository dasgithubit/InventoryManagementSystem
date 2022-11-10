package com.example.inventorymanagement.service;

import java.util.List;


import com.example.inventorymanagement.entity.ProductCategory;

public interface CategoryService {

	
	    public List<ProductCategory> findAll();
		
	    public ProductCategory findByCategoryId(Long id);
		public ProductCategory saveCategorys(ProductCategory category);
		
		public ProductCategory deleteCategory(Long id);
		
		
		public List<ProductCategory> findByCategoryName(String categoryName);

}
