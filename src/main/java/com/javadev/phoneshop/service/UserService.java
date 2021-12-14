package com.javadev.phoneshop.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.entity.DhUser;
import com.javadev.phoneshop.model.SignUpModel;
import com.javadev.phoneshop.model.UserModel;

public interface UserService {
	Optional<DhUser> findByUserName(String userName);

	ResponseEntity<ApiResponse> signup(SignUpModel signUpModel);

	Optional<DhUser> findByEmail(String email);

	ResponseEntity<ApiResponse> update(UserModel userModel);
}
