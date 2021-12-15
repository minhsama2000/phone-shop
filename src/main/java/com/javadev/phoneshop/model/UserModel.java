package com.javadev.phoneshop.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
public class UserModel {
	private String name;
	private String username;
	private String address;
	private String email;
	private String phone;
	private String password;
	private MultipartFile file;
}
