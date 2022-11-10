package com.example.inventorymanagement.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "supplier_details")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "supplier_id")
	private Long id;
	
	@NotBlank(message = "name must be required")
	@Column(name = "supplierName")
	private String supplierName;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "DateTime")
	private Date createdDateTime;
	
	@NotBlank(message = "Phone number must be required.")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Invalid Number") 
	@Column(name = "phoneNumber")
	private String phoneNumber;

	public Supplier() {
		super();
	}

	public Supplier(Long id, @NotBlank(message = "name must be required") String supplierName, String emailId,
			Date createdDateTime,
			@NotBlank(message = "Phone number must be required.") @Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid Number") String phoneNumber) {
		super();
		this.id = id;
		this.supplierName = supplierName;
		this.emailId = emailId;
		this.createdDateTime = createdDateTime;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", supplierName=" + supplierName + ", emailId=" + emailId + ", createdDateTime="
				+ createdDateTime + ", phoneNumber=" + phoneNumber + "]";
	}

	
}
