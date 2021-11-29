package com.javadev.phoneshop.service;

import org.springframework.http.ResponseEntity;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.entity.DhCategory;

public interface CategoryService {
	ResponseEntity<ApiResponse> findAll();
	ResponseEntity<ApiResponse> saveOne(DhCategory category);
	ResponseEntity<ApiResponse> getOne(Integer id);
	ResponseEntity<ApiResponse> delete(Integer id);
	ResponseEntity<ApiResponse> getListChild(Integer id);
}
