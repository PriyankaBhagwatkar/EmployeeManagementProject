package com.employee.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/")
	public String index() {
		return "index"; // Returns the view name (index.jsp in this case)
	}
	
	@GetMapping("otp")
	public String otp() {
		return "otpValidate"; // Returns the view name (index.jsp in this case)
	}
	
	@GetMapping("dashboard")
	public String dashboard() {
		return "dashboard"; // Returns the view name (index.jsp in this case)
	}
}
