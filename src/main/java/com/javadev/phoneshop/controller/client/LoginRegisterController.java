package com.javadev.phoneshop.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.model.SignUpModel;
import com.javadev.phoneshop.service.UserService;

@Controller
public class LoginRegisterController {

	
	@GetMapping("/login")
	public String login() {
		return "client/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "client/register";
	}
	

}
