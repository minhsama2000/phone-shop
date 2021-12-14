package com.javadev.phoneshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.service.CheckoutService;
import com.javadev.phoneshop.service.OrderService;

@RestController
@RequestMapping("/admin/api/v1/orders")
public class OrderController {

	private OrderService orderService;
	
	private CheckoutService checkoutService;

	@GetMapping("/orders")
	public ResponseEntity<ApiResponse> getAll() {
		return orderService.getAll();
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<ApiResponse> getOne(@PathVariable Integer id){
		
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
