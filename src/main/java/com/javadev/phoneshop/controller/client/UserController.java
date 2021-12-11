package com.javadev.phoneshop.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.model.SignUpModel;
import com.javadev.phoneshop.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<ApiResponse> signup(@ModelAttribute SignUpModel signUpModel) {
		return userService.signup(signUpModel);
	}

}
