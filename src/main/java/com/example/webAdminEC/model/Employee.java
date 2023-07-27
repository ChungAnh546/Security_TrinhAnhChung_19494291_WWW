package com.example.webAdminEC.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity(name = "Employee")
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@JsonProperty("id")
	private int id;
	@Column(name = "full_name")
	@JsonProperty("full_name")
	private String fullName;
	@Column(name = "avatar")
	@JsonProperty("avatar")
	private String avatar;
	@Column(name = "phone")
	@JsonProperty("phone")
	private String phone;
	@Column(name = "email")
	@JsonProperty("email")
	private String email;
	@Column(name = "status")
	@JsonProperty("status")
	private String status;
	@Column(name = "address")
	@JsonProperty("address")
	private String address;
	@Column(name = "user_name")
	@JsonProperty("user_name")
	private String userName;
	@Column(name = "pass")
	@JsonProperty("pass")
	private String pass;
	@Column(name = "role")
	@JsonProperty("role")
	private Boolean role;
	@OneToMany(mappedBy = "EmployeeId")
	private List<Customer> customer;

	public Employee() {
		super();
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public Employee(int id, String fullName, String avatar, String phone, String email, String status, String address,
			String userName, String pass, Boolean role, List<Customer> customer) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.avatar = avatar;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.address = address;
		this.userName = userName;
		this.pass = pass;
		this.role = role;
		this.customer = customer;
	}

	public Employee(int id, String fullName, String avatar, String phone, String email, String status, String address,
			String userName, String pass, Boolean role) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.avatar = avatar;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.address = address;
		this.userName = userName;
		this.pass = pass;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", avatar=" + avatar + ", phone=" + phone + ", email="
				+ email + ", status=" + status + ", address=" + address + ", userName=" + userName + ", pass=" + pass
				+ ", role=" + role + ", customer=" + customer + "]";
	}
}
