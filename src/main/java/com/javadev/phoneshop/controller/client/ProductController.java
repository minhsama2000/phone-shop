package com.javadev.phoneshop.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.service.ProductService;

@RestController(value = "productControllerClient")
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products/desc")
	public ResponseEntity<ApiResponse> getDescProduct(@RequestParam int limit) {
		return productService.findLimitDesc(limit);
	}

	@GetMapping("/products/random")
	public ResponseEntity<ApiResponse> getRandomProduct(@RequestParam int limit) {
		return productService.findRandom(limit);
	}

	@GetMapping("/products")
	public ResponseEntity<ApiResponse> getById(@RequestParam Integer id,@RequestParam int limit) {
		return productService.findAllById(id,limit);
	}
}
