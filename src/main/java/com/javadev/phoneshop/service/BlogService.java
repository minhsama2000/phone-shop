package com.javadev.phoneshop.service;

import org.springframework.http.ResponseEntity;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.model.BlogModel;

public interface BlogService {
	 ResponseEntity<ApiResponse> getAll();
	 ResponseEntity<ApiResponse> saveOne(BlogModel blogModel);
	 ResponseEntity<ApiResponse> getOne(Integer blogId);
	 ResponseEntity<ApiResponse> updateOne(BlogModel blogModel);
	 ResponseEntity<ApiResponse> delete(Integer blogId);
}
