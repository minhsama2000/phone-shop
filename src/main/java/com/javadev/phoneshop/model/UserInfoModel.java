package com.javadev.phoneshop.model;


import lombok.ToString;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
@ToString
public class UserInfoModel {
	private String customerName;
	private String customerEmail;
	private String customerPhone;
	private String customerAddress;
}
