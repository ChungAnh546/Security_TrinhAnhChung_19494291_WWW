package com.example.webAdminEC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class LoginController {
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return "ui/login/login-v2";
	}
}
