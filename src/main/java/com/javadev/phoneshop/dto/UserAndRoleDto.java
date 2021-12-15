package com.javadev.phoneshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserAndRoleDto extends BaseDto {
	private String name;
	private String address;
	private String username;
	private String email;
	private String phone;
	private String avatar;
	private String role;
}
