package com.javadev.phoneshop.service;

import org.springframework.http.ResponseEntity;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.model.UserInfoModel;

public interface CheckoutService {
	ResponseEntity<ApiResponse> saveOrder(UserInfoModel userInfoModel);
	ResponseEntity<ApiResponse> deleteOrder(Integer orderId);
}
