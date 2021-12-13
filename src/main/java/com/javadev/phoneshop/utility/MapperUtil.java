package com.javadev.phoneshop.utility;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javadev.phoneshop.dto.CartItemDto;
import com.javadev.phoneshop.entity.DhCart;
import com.javadev.phoneshop.entity.DhOrder;
import com.javadev.phoneshop.entity.DhProduct;
import com.javadev.phoneshop.model.DhProductModel;
import com.javadev.phoneshop.model.UserInfoModel;

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
	
	public static DhOrder convertModelToEntityOrder(UserInfoModel userInfoModel) {
		DhOrder dhOrder = new DhOrder();
		try {
			dhOrder.setCustomerName(userInfoModel.getCustomerName());
			dhOrder.setCustomerPhone(userInfoModel.getCustomerPhone());
			dhOrder.setCustomerAddress(userInfoModel.getCustomerAddress());
			dhOrder.setCustomerEmail(userInfoModel.getCustomerEmail());
			dhOrder.setCodeName(StringUtil.randomOrderCode());	
			dhOrder.setCreatedDate(new Date());
			return dhOrder;
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
