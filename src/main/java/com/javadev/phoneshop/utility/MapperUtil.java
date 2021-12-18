package com.javadev.phoneshop.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javadev.phoneshop.dto.CartItemDto;
import com.javadev.phoneshop.dto.OrderDto;
import com.javadev.phoneshop.dto.OrderProductDto;
import com.javadev.phoneshop.dto.UserAndRoleDto;
import com.javadev.phoneshop.dto.UserDto;
import com.javadev.phoneshop.entity.DhBlog;
import com.javadev.phoneshop.entity.DhCart;
import com.javadev.phoneshop.entity.DhContact;
import com.javadev.phoneshop.entity.DhOrder;
import com.javadev.phoneshop.entity.DhOrderProduct;
import com.javadev.phoneshop.entity.DhProduct;
import com.javadev.phoneshop.entity.DhRole;
import com.javadev.phoneshop.entity.DhUser;
import com.javadev.phoneshop.model.BlogModel;
import com.javadev.phoneshop.model.ContactModel;
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
	
	public static DhContact convertModelToContact(ContactModel contactModel) {
		DhContact contact = new DhContact();
		try {
			contact.setCreatedDate(new Date());
			contact.setEmail(contactModel.getEmail());
			contact.setName(contactModel.getName());
			contact.setPhone(contactModel.getPhone());
			contact.setMessage(contactModel.getMessage());
			return contact;
		} catch (Exception e) {
			// TODO: handle exception
			return contact;
		}
	}
	
	public static DhBlog convertModelToBlog(BlogModel blogModel) {
		DhBlog blog = new DhBlog();
		try {
			if (!FileUtil.isEmptyUploadFile(blogModel.getFile())) {
				blog.setAvatar(blogModel.getFile().getOriginalFilename());
			}
			blog.setCreatedDate(new Date());
			blog.setDetails(blogModel.getDetails());
			blog.setThumbnail(blogModel.getThumbnail());
			blog.setShortDescription(blogModel.getShortDescription());
			return blog;
		} catch (Exception e) {
			// TODO: handle exception
			return blog;
		} 
	}

	public static OrderDto convertDhOrderToDto(DhOrder dhOrder) {
		OrderDto dto = new OrderDto();
		try {
			dto.setId(dhOrder.getId());
			dto.setCodeName(dhOrder.getCodeName());
			dto.setCreatedDate(dhOrder.getCreatedDate());
			dto.setTotal(dhOrder.getTotal());
			dto.setOrderStatus(StringUtil.setOrderStatus(dhOrder.getOrderStatus()));
			dto.setCustomerAddress(dhOrder.getCustomerAddress());
			dto.setCustomerEmail(dhOrder.getCustomerEmail());
			dto.setCustomerName(dhOrder.getCustomerName());
			dto.setCustomerPhone(dhOrder.getCustomerPhone());
			return dto;
		} catch (Exception e) {
			// TODO: handle exception
			return dto;
		}
	}

	private static UserDto convertDhUserToDto(DhUser user) {
		UserDto dto = new UserDto();
		try {
			dto.setId(user.getId());
			dto.setAddress(user.getAddress());
			dto.setAvatar(user.getAvatar());
			dto.setEmail(user.getEmail());
			dto.setName(user.getName());
			dto.setPhone(user.getPhone());
			dto.setUsername(user.getUsername());
			return dto;
		} catch (Exception e) {
			// TODO: handle exception
			return dto;
		}
	}

	private static UserAndRoleDto convertDhUserDtoToDto(UserDto user) {
		UserAndRoleDto dto = new UserAndRoleDto();
		try {
			dto.setId(user.getId());
			dto.setAddress(user.getAddress());
			dto.setAvatar(user.getAvatar());
			dto.setEmail(user.getEmail());
			dto.setName(user.getName());
			dto.setPhone(user.getPhone());
			dto.setUsername(user.getUsername());
			return dto;
		} catch (Exception e) {
			// TODO: handle exception
			return dto;
		}
	}

	public static UserAndRoleDto getDtoFromUserAndRole(DhUser dhUser) {
		try {
			UserDto dhUserDto = convertDhUserToDto(dhUser);
			UserAndRoleDto dhUserAndRoleDto = convertDhUserDtoToDto(dhUserDto);
			for (DhRole dhRole : dhUser.getDhRoles()) {
				if (dhRole.getName().equals("FULLCONTROl")) {
					dhUserAndRoleDto.setRole(dhRole.getName());
					break;
				}
				if (dhRole.getName().equals("ADMIN") && (StringUtil.isNullOrEmpty(dhUserAndRoleDto.getRole())
						|| dhUserAndRoleDto.getRole().equals("USER"))) {
					dhUserAndRoleDto.setRole(dhRole.getName());
					continue;
				}
				dhUserAndRoleDto.setRole(dhRole.getName());
			}
			return dhUserAndRoleDto;

		} catch (Exception e) {

		}
		return null;
	}

	public static OrderProductDto convertOrderProductToDto(DhOrderProduct dhOrderProduct) {
		OrderProductDto dto = new OrderProductDto();
		try {
			dto.setId(dhOrderProduct.getId());
			dto.setName(dhOrderProduct.getName());
			dto.setQuantity(dhOrderProduct.getQuantity());
			dto.setProductId(dhOrderProduct.getProductId());
			dto.setPrice(dhOrderProduct.getPrice());
			return dto;
		} catch (Exception e) {
			// TODO: handle exception
			return dto;
		}
	}

	public static List<OrderProductDto> convertListOrderProductToListDto(List<DhOrderProduct> dhOrderProducts) {
		List<OrderProductDto> dtos = new ArrayList<OrderProductDto>();
		try {
			dtos = dhOrderProducts.stream().map(val -> convertOrderProductToDto(val)).collect(Collectors.toList());
			return dtos;
		} catch (Exception e) {
			// TODO: handle exception
			return dtos;
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
			dhOrder.setOrderStatus(1);
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
