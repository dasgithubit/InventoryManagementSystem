package com.example.inventorymanagement.entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer_details")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long id;
	
	@Column(name = "first_name")
	@NotEmpty(message = "Please provide your first name")
	private String firstName;
	
	@Column(name = "last_name")
	@NotEmpty(message = "Please provide your last name")
	@Size(min = 1,message = "lastName is manadatory")
	private String lastName;
	
	@Column(name = "email_id", nullable = false, unique = true)
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
	private String emailId;
	
	@NotBlank(message = "Phone number must be required.")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Invalid Number") 
	private String phoneNumber;
	
	@NotBlank(message = "password must be Strong.")
	private String password;
	
	// one cutomer can order multiple orders
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	List<Order> orderList = new ArrayList<Order>();

	public Customer() {
		super();
	}

	public Customer(Long id, @NotEmpty(message = "Please provide your first name") String firstName,
			@NotEmpty(message = "Please provide your last name") @Size(min = 1, message = "lastName is manadatory") String lastName,
			@Email(message = "Please provide a valid e-mail") @NotEmpty(message = "Please provide an e-mail") String emailId,
			@NotBlank(message = "Phone number must be required.") @Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid Number") String phoneNumber,
			@NotBlank(message = "password must be Strong.") String password, List<Order> orderList) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.orderList = orderList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", orderList=" + orderList + "]";
	}

	
}
