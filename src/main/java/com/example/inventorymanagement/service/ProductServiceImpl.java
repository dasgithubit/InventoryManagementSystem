package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventorymanagement.entity.Product;
import com.example.inventorymanagement.exception.DataNotFoundException;
import com.example.inventorymanagement.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
    ProductRepository productRepository;
	
    @Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}


	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product findByProductId(Long product_id) {
		// TODO Auto-generated method stub
		//Optional<Product> result = productRepository.findById(product_id);
		Optional<Product> result =productRepository.findById(product_id);
		Product theProduct = null;
		if (!result.isPresent()) {
			throw new DataNotFoundException(" product is not found !!!, whose id is  " + product_id);

		} else {
			theProduct = result.get();
			return theProduct;
		}
		
	}

	@Override
	public Product saveProducts(Product product) {
		// TODO Auto-generated method stub
		Product theProduct = productRepository.save(product);
		if (product == null) {
			throw new DataNotFoundException("Something Went Wrong");
		}
		return theProduct;
	}

	@Override
	public Product deleteProduct(Long product_id) {
		// TODO Auto-generated method stub
		Product theProduct= findByProductId(product_id);

		if (theProduct != null)
			productRepository.delete(theProduct);
		else
			throw new DataNotFoundException("product not found!!!");
		return theProduct;
	}

	@Override
	public List<Product> findByProductName(String productName) {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findByProductName(productName);
		if(products.size() == 0) {
			throw new DataNotFoundException("Currently this product name is not available !!");
		}
		return products;
	}


	
	

}
