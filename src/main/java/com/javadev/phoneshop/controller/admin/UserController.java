package com.javadev.phoneshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.service.UserService;

@RestController("userControllerAdmin")
@RequestMapping("/admin/api/v1/users")
public class UserController {
	
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<ApiResponse> getAll(){
		return userService.getAll();
	}
	
	@GetMapping("/user")
	public ResponseEntity<ApiResponse> getOne(@RequestParam Integer id){
		return userService.getOne(id);
	}
	
	@PutMapping("/user")
	public ResponseEntity<ApiResponse> update(@RequestParam Integer id,@RequestParam String role){
		return userService.updateRole(id, role);
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
