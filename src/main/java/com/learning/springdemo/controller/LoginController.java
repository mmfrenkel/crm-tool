package com.learning.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

	@GetMapping("/loginPage")
	public String showLoginPage() {
		return "bootstrap-login";
	}
	
	// adding request mapping for "/access-denied"
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
