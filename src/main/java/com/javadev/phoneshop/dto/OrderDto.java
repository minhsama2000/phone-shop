package com.javadev.phoneshop.dto;

import java.util.List;

import com.javadev.phoneshop.entity.DhOrderProduct;

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
	private String customerName;
	private String customerPhone;
	private String customerAddress;
	private String customerEmail;
	private List<OrderProductDto> dhOrderProductDtos;
}
