package com.javadev.phoneshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
	@GetMapping("/shop-cart")
	public String shopCart() {
		return "client/shop-cart";
	}
	
	@GetMapping("/checkout")
	public String checkout() {
		return "client/checkout";
	}
}
