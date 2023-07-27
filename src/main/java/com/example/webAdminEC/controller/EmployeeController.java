package com.example.webAdminEC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webAdminEC.model.Employee;
import com.example.webAdminEC.repostirory.EmployeeRepostirory;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeRepostirory employeeRepostirory;

	@GetMapping("/add")
	public String addEmployeePape(Model model) {

		return "ui/addEmployee.html";
	}

	@GetMapping("/list")
	public String listEmployeePape(Model model) {

		List<Employee> employee = employeeRepostirory.findAll();
		model.addAttribute("eList", employee);

		return "ui/listEmployee.html";
	}
}
