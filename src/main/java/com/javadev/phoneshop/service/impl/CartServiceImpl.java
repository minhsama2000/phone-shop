package com.javadev.phoneshop.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.dto.CartItemDto;
import com.javadev.phoneshop.entity.DhCart;
import com.javadev.phoneshop.entity.DhProduct;
import com.javadev.phoneshop.entity.DhUser;
import com.javadev.phoneshop.model.CartItemModel;
import com.javadev.phoneshop.repository.CartRepository;
import com.javadev.phoneshop.repository.ProductRepository;
import com.javadev.phoneshop.repository.UserRepository;
import com.javadev.phoneshop.service.CartService;
import com.javadev.phoneshop.utility.DateUtil;
import com.javadev.phoneshop.utility.MapperUtil;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	private UserDetails userDetails;

	@Override
	public ResponseEntity<ApiResponse> addCart(CartItemModel cartItemModel) {
		ApiResponse apiResponse = null;
		try {
			saveOne(cartItemModel);
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", cartItemModel);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", cartItemModel);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> getAllCart(String userName) {
		ApiResponse apiResponse = null;
		List<CartItemDto> cartItemDto = null;
		try {
			Optional<DhUser> optionalUser = userRepository.findByUsername(userName);
			if(optionalUser.isPresent()) {
				cartItemDto = cartRepository.findAllByUserId(optionalUser.get().getId()).stream()
						.map(val -> MapperUtil.convertDhCartToDto(val)).collect(Collectors.toList());
				apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", cartItemDto);
				return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
			}		
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", cartItemDto);
		return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
	}

	public void saveOne(CartItemModel cartItemModel) {
		DhUser dhUser = null;
		DhProduct dhProduct = null;
		DhCart cart = null;
		userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Optional<DhUser> optionalUser = userRepository.findByUsername(userDetails.getUsername());
		if (optionalUser.isPresent()) {
			dhUser = optionalUser.get();
		}

		Optional<DhProduct> optionalProd = productRepository.findById(cartItemModel.getProductId());
		if (optionalProd.isPresent()) {
			dhProduct = optionalProd.get();
			if (cartRepository.findByUserIdAndProductIdAndStorageAndColor(dhUser.getId(), cartItemModel.getProductId(),
					cartItemModel.getStorage(), cartItemModel.getColor()).isPresent()) {
				cart = cartRepository.findByUserIdAndProductIdAndStorageAndColor(dhUser.getId(),
						cartItemModel.getProductId(), cartItemModel.getStorage(), cartItemModel.getColor()).get();
				cart.setQuantity(cart.getQuantity() + 1);
			} else {
				cart = new DhCart();
				cart.setProductId(dhProduct.getId());
				cart.setAvatar(dhProduct.getAvatar());
				cart.setName(dhProduct.getName());
				cart.setQuantity(cartItemModel.getQuantity());
				cart.setPrice(dhProduct.getPrice());
				cart.setUserId(dhUser.getId());
				cart.setColor(cartItemModel.getColor());
				cart.setStorage(cartItemModel.getStorage());
			}
			cartRepository.save(cart);
		}
	}

}
