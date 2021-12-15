package com.javadev.phoneshop.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.service.CheckoutService;
import com.javadev.phoneshop.service.OrderService;
import com.javadev.phoneshop.utility.SecurityUtil;
import com.javadev.phoneshop.utility.StringUtil;

@RestController("orderControllerClient")
@RequestMapping("/api-security/v1/orders")
public class OrderController {

	private OrderService orderService;

	private CheckoutService checkoutService;

	@GetMapping("/orders")
	public ResponseEntity<ApiResponse> getAllForUser() {
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		return orderService.getAllForUser(username);
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<ApiResponse> getOne(@PathVariable Integer id){
		return orderService.getOne(id);
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<ApiResponse> getAll(@PathVariable Integer id) {
		return checkoutService.deleteOrder(id);
	}

	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Autowired
	public void setCheckoutService(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}

}
