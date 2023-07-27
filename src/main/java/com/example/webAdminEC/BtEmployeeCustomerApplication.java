package com.example.webAdminEC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BtEmployeeCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtEmployeeCustomerApplication.class, args);
	}

}
