package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.inventorymanagement.entity.Customer;
import com.example.inventorymanagement.exception.DataNotFoundException;
import com.example.inventorymanagement.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
  
	
	CustomerRepository customerRepository;
	
    @Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	public List<Customer> findAll() {
		
		// TODO Auto-generated method stub
		
		return customerRepository.findAll();

	}

	@Override
	public Customer findByCustomerId(Long id) {
		// TODO Auto-generated method stub
		
		Optional<Customer> result = customerRepository.findById(id);

		Customer theCustomer = null;
		if (!result.isPresent()) {
			throw new DataNotFoundException(" Customer is not found !!!, whose id is  " + id);

		} else {
			theCustomer = result.get();
			return theCustomer;
		}
	
	}

	@Override
	public Customer saveCustomers(Customer customers) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.save(customers);
		if (customers == null) {
			throw new DataNotFoundException("Something Went Wrong");
		}
		return customer;
	
	}

	@Override
	public Customer deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		
		Customer theCustomer= findByCustomerId(id);

		if (theCustomer != null)
			customerRepository.delete(theCustomer);
		else
			throw new DataNotFoundException("Customer not found!!!");
		return theCustomer;
		
	}

	
	@Override
	public List<Customer> findByfirstName(String firstName) {
		// TODO Auto-generated method stub
		
		
		List<Customer> customers = customerRepository.findByfirstName(firstName);
		if(customers.size() == 0) {
			throw new DataNotFoundException("Currently this customername is not available !!");
		}
		return customers;	
	}


	@Override
	public List<Customer> findByEmailId(String emailId) {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.findByEmailId(emailId);
		if(customers.size() == 0) {
			throw new DataNotFoundException("Currently this customer emailId is not available !!");
		}
		return null;
	}

}
				


