package com.javadev.phoneshop.utility;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
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
}
