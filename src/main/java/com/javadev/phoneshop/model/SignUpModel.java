package com.javadev.phoneshop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignUpModel {
	private String username;
	private String password;
	private String password_confirmation;
	private String email;
	private String name;
}
