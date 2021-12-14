package com.javadev.phoneshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDto extends BaseDto{
	private String codeName;
	private Long total;
	private String orderStatus;
}
