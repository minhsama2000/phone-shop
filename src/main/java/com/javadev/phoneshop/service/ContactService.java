package com.javadev.phoneshop.service;

import org.springframework.http.ResponseEntity;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.model.ContactModel;

public interface ContactService {
	ResponseEntity<ApiResponse> saveContact(ContactModel contactModel);
}
