package com.javadev.phoneshop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContactModel {
	private String name;
	private String email;
	private String phone;
	private String message;
}
