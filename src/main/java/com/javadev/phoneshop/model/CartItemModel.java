package com.javadev.phoneshop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartItemModel {
	private Integer productId;
	private int quantity;
	private int color;
	private int storage;
}
