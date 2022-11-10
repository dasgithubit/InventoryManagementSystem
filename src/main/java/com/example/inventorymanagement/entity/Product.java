package com.example.inventorymanagement.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product_details")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long id;
	
	@NotBlank(message = "Product name must be required")
	@Column(name="product_name")
	private String name;
	
	@Column(name = "discription")
    private String discription;

	@Column(name="price")
	private BigDecimal unitPrice;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="quantity")
	private int quantity;
	
	// One categories can have multiple product- for that we used one to many associations
	@JsonIgnore  // It will ignore serialization and deserialization functionality
	@ManyToOne(cascade = CascadeType.ALL)
	private ProductCategory categories ;
	
	@ManyToOne
	private Order order;

	public Product() {
		super();
	}

	public Product(Long id, @NotBlank(message = "Product name must be required") String name, String discription,
			BigDecimal unitPrice, String imageUrl, int quantity, ProductCategory categories, Order order) {
		super();
		this.id = id;
		this.name = name;
		this.discription = discription;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.categories = categories;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductCategory getCategories() {
		return categories;
	}

	public void setCategories(ProductCategory categories) {
		this.categories = categories;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", discription=" + discription + ", unitPrice=" + unitPrice
				+ ", imageUrl=" + imageUrl + ", quantity=" + quantity + ", categories=" + categories + ", order="
				+ order + "]";
	}

	
	
}
