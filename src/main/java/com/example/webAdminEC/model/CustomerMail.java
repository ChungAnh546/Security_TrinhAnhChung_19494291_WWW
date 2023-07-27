package com.example.webAdminEC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "CustomerMail")
@Table(name = "customer_mail")
public class CustomerMail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@JsonProperty("id")
	private int id;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerId;
	@Column(name = "mail")
	@JsonProperty("mail")
	private String mail;

	public CustomerMail(int id, Customer customerId, String mail) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.mail = mail;
	}

	public CustomerMail() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", mail=" + mail + "}";
	}

}
