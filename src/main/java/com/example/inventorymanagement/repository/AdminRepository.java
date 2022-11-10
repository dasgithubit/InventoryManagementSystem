package com.example.inventorymanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.inventorymanagement.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>{
	
	
	public Optional<Admin> findByPassword(String string);

	


	
	


}
