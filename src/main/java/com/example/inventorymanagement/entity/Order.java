package com.example.inventorymanagement.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name = "orders")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;
	
	@Column(name="total_quantity")
	private int totalQuantity;
	
	@Column(name="total_price")
	private BigDecimal totalPrice;
	
	@ManyToOne
    @JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name="date_created")
	private Date dateCreated;
	
	@OneToMany
	private List<Product> products;
	 
	// Many orders by only one customer.
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Order() {
		super();
	}

	public Order(Long id, int totalQuantity, BigDecimal totalPrice, Product product, Date dateCreated,
			List<Product> products, Customer customer) {
		super();
		this.id = id;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.product = product;
		this.dateCreated = dateCreated;
		this.products = products;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", totalQuantity=" + totalQuantity + ", totalPrice=" + totalPrice + ", product="
				+ product + ", dateCreated=" + dateCreated + ", products=" + products + ", customer=" + customer + "]";
	}

	
}

