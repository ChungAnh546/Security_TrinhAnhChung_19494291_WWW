package com.example.webAdminEC.repostirory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.webAdminEC.model.CustomerMail;

public interface CustomerMailRepostirory extends JpaRepository<CustomerMail, Integer>{
	@Query(value = "SELECT * FROM customer_mail u WHERE u.mail LIKE ?1",nativeQuery = true)
	CustomerMail findCustomerMailByEmail(String email);
	@Query(value = "SELECT * FROM customer_mail u WHERE u.customer_id LIKE ?1",nativeQuery = true)
	List<CustomerMail> findCustomerMailByCustomerId(int id);
}
