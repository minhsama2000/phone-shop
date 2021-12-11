package com.javadev.phoneshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter 
@ToString
public class CartItemDto {
	private Integer productId;
	private String name;
	private int quantity;
	private Long price;
	private int color;
	private int storage;
	private String avatar;
}
