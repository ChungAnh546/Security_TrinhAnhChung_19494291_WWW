package com.example.webAdminEC.controller;

import java.awt.print.Book;
import java.util.List;

import javax.validation.constraints.Email;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webAdminEC.model.Employee;
import com.example.webAdminEC.repostirory.EmployeeRepostirory;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	EmployeeRepostirory employeeRepostirory;

	@PostMapping("/create")
	public boolean create(@RequestBody Employee employee) {
		try {
			List<Employee> employeeExict = employeeRepostirory.findEmployeeByPhone(employee.getPhone());
			if(employeeExict.size() == 0) {
				employee.setPass(passwordHashing(employee.getPass()));
			employeeRepostirory.save(employee);
			return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}
	@PostMapping("/update")
	public Boolean edit(@RequestBody Employee employee)
	{try {
		Employee employeeData = employeeRepostirory.getById(employee.getId());
		if(employee.getAvatar()== null) {
			employee.setAvatar(employeeData.getAvatar());
		}
		employee.setUserName(employeeData.getUserName());
		employee.setPass(employeeData.getPass());
		employeeRepostirory.save(employee);
		return true;
	} catch (Exception e) {
		return false;
	}
		
	}

	public String passwordHashing(String pass) {
		//System.out.println(pass);131
		String salt = BCrypt.gensalt(10);
		String hashedPassword = BCrypt.hashpw(pass, salt);
		//System.out.println(hashedPassword);
		return hashedPassword;
	}
	
	@GetMapping("/search/email")
	public Employee searchEmployeeByEmail(@RequestParam("email")String email ) {
		List<Employee> employee =  employeeRepostirory.findEmployeeByEmail(email);
		if(employee.size()!=0) {
			return employee.get(0);
		}return null;
	}
	
	@GetMapping("/search/email-and-id")
	public Employee searchEmployeeByEmailAndId(@RequestParam("email")String email,@RequestParam("id")String id  ) {
		Employee employee1 =  employeeRepostirory.findEmployeeByEmailAndId(email,id);
		List<Employee> employee2 =  employeeRepostirory.findEmployeeByEmail(email);
		if(employee1 != null && employee2.get(0)!=null) {
			return null;
		}
		if(employee2.size()!=0) {
			return employee2.get(0);
		}return null;
	}
	@GetMapping("/search/phone")
	public Employee searchEmployeeByPhone(@RequestParam("phone")String phone ) {
		List<Employee> employee =  employeeRepostirory.findEmployeeByPhone(phone);
		
		if(employee.size()!=0) {
		
				return employee.get(0);
			
		}return null;
		
	}//
	@GetMapping("/search/phone-and-id")
	public Employee searchEmployeeByPhoneAndId(@RequestParam("phone")String phone,@RequestParam("id")String id ) {
		Employee employee1 =  employeeRepostirory.findEmployeeByPhoneAndId(phone,id);
		List<Employee> employee2 =  employeeRepostirory.findEmployeeByPhone(phone);
		if(employee1 != null && employee2.get(0)!=null) {
			return null;
		}
		if(employee2.size()!=0) {
			return employee2.get(0);
		}return null;
	}
	@GetMapping("/search/user-name")
	public Employee searchEmployeeByUserName(@RequestParam("userName")String userName ) {
		Employee employee =  employeeRepostirory.findEmployeeByUserName(userName);
		return employee;
	}
	@GetMapping("/delete")
	public Boolean delete(@RequestParam("phone") String phone) {
		try {
			employeeRepostirory.deleteById(employeeRepostirory.findEmployeeByPhone(phone).get(0).getId());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
