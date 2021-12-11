package com.javadev.phoneshop.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javadev.phoneshop.dto.CartItemDto;
import com.javadev.phoneshop.entity.DhCart;
import com.javadev.phoneshop.entity.DhProduct;
import com.javadev.phoneshop.model.DhProductModel;

public class MapperUtil {
	
	private static ObjectMapper objectMapper = new ObjectMapper();

	public static DhProduct convertModelToEntityProduct(DhProductModel dhProductModel) {
		try {
			return objectMapper.readValue(objectMapper.writeValueAsString(dhProductModel), DhProduct.class);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static CartItemDto convertDhCartToDto(DhCart cart) {
		CartItemDto cartItemDto = new CartItemDto();
		try {
			cartItemDto.setName(cart.getName());
			cartItemDto.setAvatar(cart.getAvatar());
			cartItemDto.setColor(cart.getColor());
			cartItemDto.setPrice(cart.getPrice());
			cartItemDto.setProductId(cart.getProductId());
			cartItemDto.setStorage(cart.getStorage());
			cartItemDto.setQuantity(cart.getQuantity());
			return cartItemDto;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
