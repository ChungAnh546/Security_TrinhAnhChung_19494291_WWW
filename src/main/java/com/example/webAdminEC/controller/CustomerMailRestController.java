package com.example.webAdminEC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webAdminEC.model.Customer;
import com.example.webAdminEC.model.CustomerMail;
import com.example.webAdminEC.repostirory.CustomerMailRepostirory;
import com.example.webAdminEC.repostirory.CustomerRepostirory;

@RestController
@RequestMapping("/customer-mail")
public class CustomerMailRestController {
	@Autowired
CustomerMailRepostirory customerMailRepostirory;
	@Autowired
	CustomerRepostirory customerRepostirory;
	@PostMapping("/create")
	public boolean create(@RequestBody CustomerMail customerMail) {
		try {
				
			
			customerMailRepostirory.save(customerMail);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}
	@GetMapping("/search/email")
	public CustomerMail searchCustomerMailByEmail(@RequestParam("email")String email ) {
		try {
			CustomerMail customerMail =  customerMailRepostirory.findCustomerMailByEmail(email);
			
			customerMail.setCustomerId(null);
//			CustomerMail cusMail = new CustomerMail();
//			cusMail.setId(customerMail.getId());
//			cusMail.setMail(customerMail.getMail());
//			//cusMail.setCustomerId(customerMail.getCustomerId());
			return customerMail;
		} catch (Exception e) {
			//System.out.println(e);
			return null;
		}
		
		
	}
	@GetMapping("/delete")
	public Boolean delete(@RequestParam("email") String email) {
		try {
			customerMailRepostirory.deleteById(customerMailRepostirory.findCustomerMailByEmail(email).getId());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
}
