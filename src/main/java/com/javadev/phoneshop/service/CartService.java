package com.javadev.phoneshop.service;

import org.springframework.http.ResponseEntity;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.model.CartItemModel;

public interface CartService {
	ResponseEntity<ApiResponse> addCart(CartItemModel cartItemModel);

	ResponseEntity<ApiResponse> getAllCart(String userName);
}
