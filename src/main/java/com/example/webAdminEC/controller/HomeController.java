package com.example.webAdminEC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.webAdminEC.model.Employee;
import com.example.webAdminEC.repostirory.EmployeeRepostirory;

@Controller
public class HomeController {
	@Autowired
	EmployeeRepostirory employeeRepostirory;
@GetMapping("/")
public String homePape(Model model) {
	List<Employee> employee = employeeRepostirory.findAll();
	model.addAttribute("eList", employee);

	return "ui/listEmployee.html";
}

}
