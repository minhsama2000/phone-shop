package com.javadev.phoneshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminHomeController {

	@RequestMapping(value = {"/index","/","home",""},method = RequestMethod.GET)
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("/table")
	public String table() {
		return "admin/table";
	}
	
	@GetMapping("/order")
	public String order() {
		return "admin/order";
	}
	
	@GetMapping("/user")
	public String user() {
		return "admin/user";
	}
	
	@GetMapping("/blog")
	public String blog() {
		return "admin/blog";
	}
}
