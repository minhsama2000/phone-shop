package com.javadev.phoneshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CrawProduct {
	private String url;
	private String name;
	private String price;
	private String avatar;

	public CrawProduct() {
		super();
	}

	public CrawProduct(String url, String name, String price, String avatar) {
		super();
		this.url = url;
		this.name = name;
		this.price = price;
		this.avatar = avatar;
	}

	
}
