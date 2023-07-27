package com.example.webAdminEC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webAdminEC.model.Employee;
import com.example.webAdminEC.repostirory.EmployeeRepostirory;


@RestController
@RequestMapping("/login")
public class loginRestController {
	@Autowired
	EmployeeRepostirory employeeRepostirory;
	
	@GetMapping("/user-name")
	public boolean search(@RequestParam("user") String user,@RequestParam("password")String password) {

		Employee employee = employeeRepostirory.findEmployeeByUserName(user);
		String password2 = employee.getPass();
		 
	       
		return BCrypt.checkpw(password, password2);
	}
	@GetMapping("/user-login")
	public Employee searchEmployeeLogin(@RequestParam("user")String user ) {
		Employee employee =  employeeRepostirory.findEmployeeByUserName(user);
		Employee e2 = new Employee();
		e2.setAvatar(employee.getAvatar());
		e2.setRole(employee.getRole());
		e2.setFullName(employee.getFullName());
		e2.setId(employee.getId());
		return e2;
	}

}
