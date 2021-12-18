package com.javadev.phoneshop.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.model.ContactModel;
import com.javadev.phoneshop.service.ContactService;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

	private ContactService contactService;

	@PostMapping("/contact")
	public ResponseEntity<ApiResponse> sendContact(@ModelAttribute ContactModel contactModel){
		return contactService.saveContact(contactModel);
	}

	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

}
