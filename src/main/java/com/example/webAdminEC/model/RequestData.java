package com.example.webAdminEC.model;

public class RequestData {
	  private Customer customer;
	  private CustomerMail customerMail;
	  
	  // Constructors, getters, and setters
	  
	  public RequestData() {
	  }
	  
	  public Customer getCustomer() {
	    return customer;
	  }
	  
	  public void setCustomer(Customer customer) {
	    this.customer = customer;
	  }
	  
	  public CustomerMail getCustomerMail() {
	    return customerMail;
	  }
	  
	  public void setCustomerMail(CustomerMail customerMail) {
	    this.customerMail = customerMail;
	  }
	}
