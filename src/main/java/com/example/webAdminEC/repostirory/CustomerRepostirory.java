package com.example.webAdminEC.repostirory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.webAdminEC.model.Customer;
import com.example.webAdminEC.model.Employee;

public interface CustomerRepostirory extends JpaRepository<Customer, Integer>{
	@Query(value = "SELECT * FROM customer u WHERE u.email LIKE ?1",nativeQuery = true)
	Customer findCustomerByEmail(String email);
	@Query(value = "SELECT * FROM customer u WHERE u.phone LIKE ?1",nativeQuery = true)
	Customer findCustomerByPhone(String phone);
	@Query(value = "SELECT * FROM customer u WHERE u.phone LIKE ?1 AND u.id LIKE ?2",nativeQuery = true)
	Customer findCustomerByPhoneAndId(String phone,String id);
}
