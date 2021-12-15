package com.javadev.phoneshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderProductDto extends BaseDto{
	private int quantity;
	private Integer productId;
	private String name;
	private Long price;
}
