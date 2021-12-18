package com.javadev.phoneshop.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.model.CartItemModel;
import com.javadev.phoneshop.service.CartService;
import com.javadev.phoneshop.utility.SecurityUtil;

@Controller
@RequestMapping("/api-security/v1/carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart")
	public ResponseEntity<ApiResponse> addCart(@RequestBody CartItemModel cartItemModel){
		return cartService.addCart(cartItemModel);
	}
	
	@GetMapping("/carts")
	public ResponseEntity<ApiResponse> getAllCart(){
		UserDetails currentUser = SecurityUtil.getUserDetails();
		return cartService.getAllCart(currentUser.getUsername());
	}
	
	@PutMapping("/cart")
	public ResponseEntity<ApiResponse> updateCart(@RequestBody CartItemModel cartItemModel){
		return cartService.updateCart(cartItemModel);
	}
	
	@DeleteMapping("/cart")
	public ResponseEntity<ApiResponse> removeCart(@RequestParam Integer productId,@RequestParam Integer color,@RequestParam Integer storage){
		return cartService.deleteCart(productId,color,storage);
	}
}
