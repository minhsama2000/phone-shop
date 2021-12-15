package com.javadev.phoneshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto extends BaseDto{
	private String name;
	private String username;
	private String address;
	private String email;
	private String phone;
	private String avatar;
}
