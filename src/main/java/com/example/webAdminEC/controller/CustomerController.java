package com.example.webAdminEC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webAdminEC.model.Customer;
import com.example.webAdminEC.model.CustomerMail;
import com.example.webAdminEC.repostirory.CustomerRepostirory;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepostirory customerRepostirory;
	
	@GetMapping("/add")
	public String addCustomerPape(Model model) {
		return "ui/addCustomer.html";
	}
	@GetMapping("/list")
	public String listCustomerPape(Model model) {

		///
//		Customer customer = customerRepostirory.findById(2).orElse(null);
//        if (customer != null) {
//            System.out.println("Customer Name: " + customer.getCustomerName());
//            
//            List<CustomerMail> customerMails = customer.getCustomerMails();
//            for (CustomerMail customerMail : customerMails) {
//                System.out.println("Email: " + customerMail.getMail());
//            }
//        } else {
//            System.out.println("Customer not found.");
//        }
		///
		List<Customer> customers = customerRepostirory.findAll();
		model.addAttribute("cList", customers);

		return "ui/listCustomer.html";
	}
}
