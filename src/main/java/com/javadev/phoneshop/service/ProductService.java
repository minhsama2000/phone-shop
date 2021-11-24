package com.javadev.phoneshop.service;

import org.springframework.http.ResponseEntity;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.model.DhProductModel;

public interface ProductService {
	ResponseEntity<ApiResponse> findAll();
	ResponseEntity<ApiResponse> saveOne(DhProductModel dhProductModel);
	ResponseEntity<ApiResponse> update(DhProductModel dhProductModel);
	ResponseEntity<ApiResponse> getOne(Integer id);
	ResponseEntity<ApiResponse> delete(Integer id);
}
