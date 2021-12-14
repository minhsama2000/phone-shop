package com.javadev.phoneshop.service;

import org.springframework.http.ResponseEntity;

import com.javadev.phoneshop.dto.ApiResponse;

public interface OrderService {
	ResponseEntity<ApiResponse> getAll();
}
