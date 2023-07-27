package com.example.webAdminEC.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Setter
//@Getter
//@NoArgsConstructor
@Data
@Entity(name = "Customer")
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@JsonProperty("id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee EmployeeId;
	@Column(name = "customer_name")
	@JsonProperty("customer_name")
	private String customerName;
	@Column(name = "address")
	@JsonProperty("address")
	private String address;
	@Column(name = "phone")
	@JsonProperty("phone")
	private String phone;
	@Column(name = "take_note")
	@JsonProperty("take_note")
	private String takeNote;
	@Column(name = "status")
	@JsonProperty("status")		
	private String status;
	 @OneToMany(mappedBy = "customerId")
	    private List<CustomerMail> customerMails;
	 
//	@OneToMany(mappedBy="customerId")
//	@Column(name = "customer_mail")
//	private Set<CustomerMail> customerMail;

	
public List<CustomerMail> getCustomerMails() {
		return customerMails;
	}
	public void setCustomerMails(List<CustomerMail> customerMails) {
		this.customerMails = customerMails;
	}
	//	public void setCustomerMail(Set<CustomerMail> customerMail) {
//		this.customerMail = customerMail;
//	}
	public Customer() {
		super();
	}
	public Customer(int id, Employee employeeId, String customerName, String address, String phone, String takeNote,
			String status) {
		super();
		this.id = id;
		EmployeeId = employeeId;
		this.customerName = customerName;
		this.address = address;
		this.phone = phone;
		this.takeNote = takeNote;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		EmployeeId = employeeId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTakeNote() {
		return takeNote;
	}
	public void setTakeNote(String takeNote) {
		this.takeNote = takeNote;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "{id=" + id + ", EmployeeId=" + EmployeeId + ", customerName=" + customerName + ", address="
				+ address + ", phone=" + phone + ", takeNote=" + takeNote + ", status=" + status + ", customerMails="+customerMails+"}";
	}

}
