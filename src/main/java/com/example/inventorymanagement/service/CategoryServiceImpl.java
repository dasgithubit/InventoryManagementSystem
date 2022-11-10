package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventorymanagement.entity.ProductCategory;
import com.example.inventorymanagement.exception.DataNotFoundException;
import com.example.inventorymanagement.repository.ProductCategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	
	ProductCategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(ProductCategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	

	@Override
	public List<ProductCategory> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public ProductCategory findByCategoryId(Long id) {
		// TODO Auto-generated method stub
		Optional<ProductCategory> result = categoryRepository.findById(id);

		ProductCategory theCategory = null;
		if (!result.isPresent()) {
			throw new DataNotFoundException(" Category is not found !!!, whose id is  " + id);

		} else {
			theCategory = result.get();
			return theCategory;
		}
	
	}

	@Override
	public ProductCategory saveCategorys(ProductCategory categorys) {
		// TODO Auto-generated method stub
		ProductCategory category = categoryRepository.save(categorys);
		if (categorys == null) {
			throw new DataNotFoundException("Something Went Wrong");
		}
		return category;
	}

	@Override
	public ProductCategory deleteCategory(Long id) {
		// TODO Auto-generated method stub
		ProductCategory theCategory= findByCategoryId(id);

		if (theCategory != null)
			categoryRepository.delete(theCategory);
		else
			throw new DataNotFoundException("Category not found!!!");
		return theCategory;
	}

	@Override
	public List<ProductCategory> findByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		List<ProductCategory> categorys = categoryRepository.findByCategoryName(categoryName);
		if(categorys.size() == 0) {
			throw new DataNotFoundException("Currently this Categoryname is not available !!");
		}
		return categorys;	
	}

}
