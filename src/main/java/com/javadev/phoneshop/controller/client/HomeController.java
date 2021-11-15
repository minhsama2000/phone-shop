package com.javadev.phoneshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/index","/home","/"})
	public String index() {
		return "client/index";
	}
	
	@GetMapping("/product-details")
	public String productDetails() {
		return "client/product-details";
	}
}
