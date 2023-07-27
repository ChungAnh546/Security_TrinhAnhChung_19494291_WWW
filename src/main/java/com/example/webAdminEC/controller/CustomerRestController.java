package com.example.webAdminEC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webAdminEC.model.Customer;
import com.example.webAdminEC.model.CustomerMail;
import com.example.webAdminEC.model.Employee;
import com.example.webAdminEC.model.RequestData;
import com.example.webAdminEC.repostirory.CustomerMailRepostirory;
import com.example.webAdminEC.repostirory.CustomerRepostirory;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
@Autowired
CustomerRepostirory customerRepostirory;

@Autowired
CustomerMailRepostirory customerMailRepostirory;
@PostMapping("/create")
public boolean create(@RequestBody RequestData requestData) {
	try {
		Customer customer = requestData.getCustomer();
	    CustomerMail customerMail = requestData.getCustomerMail();
		customerRepostirory.save(customer);
		customerMail.setCustomerId(customer);
		customerMailRepostirory.save(customerMail);
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		return false;
	}

}
@PostMapping("/update")
public Boolean edit(@RequestBody Customer customer)
{try {
//	Customer customerData = customerRepostirory.getById(customer.getId());
//	customer.setUserName(customerData.getUserName());
//	customer.setPass(customerData.getPass());
	customerRepostirory.save(customer);
	return true;
} catch (Exception e) {
	return false;
}
	
}
@GetMapping("/search/email")
public Customer searchCustomerByEmail(@RequestParam("email")String email ) {
	Customer customer =  customerRepostirory.findCustomerByEmail(email);
	return customer;
}
@GetMapping("/search/phone")
public Customer searchCustomerByPhone(@RequestParam("phone")String phone ) {
	try {
		Customer customer =  customerRepostirory.findCustomerByPhone(phone);
	Customer cus2 = new Customer();
		cus2.setId(customer.getId());
		
		return cus2;
	} catch (Exception e) {
		return null;
	}

	
}//
@GetMapping("/search/phone-and-id")
public Customer searchCustomerByPhoneAndId(@RequestParam("phone")String phone,@RequestParam("id")String id ) {
	Customer customer1 = customerRepostirory.findCustomerByPhoneAndId(phone,id);
	Customer customer2 =  customerRepostirory.findCustomerByPhone(phone);
	if(customer1 != null && customer2!=null) {
		return null;
	}
	customer2.setCustomerMails(null);	

	return customer2;
}
@GetMapping("/delete")
public Boolean delete(@RequestParam("phone") String phone) {
	try {
		int idCustomerDelete = customerRepostirory.findCustomerByPhone(phone).getId();
		List<CustomerMail> dsCusMail= 	customerMailRepostirory.findCustomerMailByCustomerId(idCustomerDelete);
		for(CustomerMail ds :dsCusMail) {
			customerMailRepostirory.deleteById(ds.getId());
		}
		customerRepostirory.deleteById(idCustomerDelete);
		return true;
	} catch (Exception e) {
		return false;
	}
	
}
}
