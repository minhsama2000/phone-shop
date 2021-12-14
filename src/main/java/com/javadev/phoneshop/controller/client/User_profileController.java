package com.javadev.phoneshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class User_profileController {
	
	@GetMapping("/user-profile")
	public String user_profile() {
		return "client/user-profile";
	}

}
