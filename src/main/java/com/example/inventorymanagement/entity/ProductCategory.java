package com.example.inventorymanagement.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;
    
    // Many product can have one category - for that we used many to one association 
    @OneToMany
	private List<Product> products;

	public ProductCategory() {
		super();
	}

	public ProductCategory(Long id, String categoryName, List<Product> products) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", products=" + products + "]";
	}

	
    
}








