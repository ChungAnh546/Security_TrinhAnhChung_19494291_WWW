package com.example.webAdminEC.repostirory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.webAdminEC.model.Employee;



public interface  EmployeeRepostirory extends JpaRepository<Employee,Integer>{
	@Query(value = "SELECT * FROM employee u WHERE u.email LIKE ?1",nativeQuery = true)
	List<Employee> findEmployeeByEmail(String email);
	@Query(value = "SELECT * FROM employee u WHERE u.email LIKE ?1 AND u.id LIKE ?2",nativeQuery = true)
	Employee findEmployeeByEmailAndId(String email,String id);
	
	@Query(value = "SELECT * FROM employee u WHERE u.phone LIKE ?1",nativeQuery = true)
	List<Employee> findEmployeeByPhone(String phone);
	@Query(value = "SELECT * FROM employee u WHERE u.phone LIKE ?1 AND u.id LIKE ?2",nativeQuery = true)
	Employee findEmployeeByPhoneAndId(String phone,String id);
	
	@Query(value = "SELECT * FROM employee u WHERE u.user_name LIKE ?1",nativeQuery = true)
	Employee findEmployeeByUserName(String userName);
}
