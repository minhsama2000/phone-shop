package com.javadev.phoneshop.service;

import org.springframework.http.ResponseEntity;

import com.javadev.phoneshop.dto.ApiResponse;

public interface OrderService {
	ResponseEntity<ApiResponse> getAll();
	ResponseEntity<ApiResponse> getOne(Integer orderId);
	ResponseEntity<ApiResponse> update(Integer orderId,int status);
	ResponseEntity<ApiResponse> getAllByOrderStatus(int status);
	ResponseEntity<ApiResponse> getAllForUser(String username);
}
