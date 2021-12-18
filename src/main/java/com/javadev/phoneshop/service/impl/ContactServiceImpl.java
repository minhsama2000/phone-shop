package com.javadev.phoneshop.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.entity.DhContact;
import com.javadev.phoneshop.model.ContactModel;
import com.javadev.phoneshop.repository.ContactRepository;
import com.javadev.phoneshop.service.ContactService;
import com.javadev.phoneshop.utility.DateUtil;
import com.javadev.phoneshop.utility.MapperUtil;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository contactRepository;

	@Override
	public ResponseEntity<ApiResponse> saveContact(ContactModel contactModel) {
		ApiResponse apiResponse = null;
		DhContact dhContact = new DhContact();
		try {
			dhContact = MapperUtil.convertModelToContact(contactModel);
			contactRepository.save(dhContact);
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", dhContact);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", dhContact);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Autowired
	public void setContactRepository(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

}
