package com.javadev.phoneshop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.entity.DhCart;
import com.javadev.phoneshop.entity.DhOrder;
import com.javadev.phoneshop.entity.DhOrderProduct;
import com.javadev.phoneshop.entity.DhProduct;
import com.javadev.phoneshop.entity.DhUser;
import com.javadev.phoneshop.model.UserInfoModel;
import com.javadev.phoneshop.repository.CartRepository;
import com.javadev.phoneshop.repository.OrderProductRepository;
import com.javadev.phoneshop.repository.OrderRepository;
import com.javadev.phoneshop.repository.ProductRepository;
import com.javadev.phoneshop.repository.UserRepository;
import com.javadev.phoneshop.service.CheckoutService;
import com.javadev.phoneshop.utility.DateUtil;
import com.javadev.phoneshop.utility.MapperUtil;
import com.javadev.phoneshop.utility.SecurityUtil;
import com.javadev.phoneshop.utility.StringUtil;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	private UserRepository userRepository;
	private CartRepository cartRepository;
	private OrderProductRepository orderProductRepository;
	private ProductRepository productRepository;
	private OrderRepository orderRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setCartRepository(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Autowired
	public void setOrderProductRepository(OrderProductRepository orderProductRepository) {
		this.orderProductRepository = orderProductRepository;
	}

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public ResponseEntity<ApiResponse> saveOrder(UserInfoModel userInfoModel) {
		// TODO Auto-generated method stub
		UserDetails userDetails = SecurityUtil.getUserDetails();
		ApiResponse apiResponse = null;
		DhUser dhUser = null;
		List<DhCart> dhCart = null;
		DhProduct dhProduct = null;
		Optional<DhUser> optionalUser = userRepository.findByUsername(userDetails.getUsername());
		if (optionalUser.isPresent()) {
			dhUser = optionalUser.get();
		}

		try {		
				dhCart = cartRepository.findAllByUserId(dhUser.getId());
				DhOrder dhOrder = MapperUtil.convertModelToEntityOrder(userInfoModel);			
				dhOrder.setDhUser(dhUser);
				DhOrderProduct dhOrderProduct = new DhOrderProduct();
				long total = 0;
				for (DhCart cart : dhCart) {
					dhProduct = productRepository.findByProductId(cart.getProductId());
					dhOrderProduct.setDhProduct(dhProduct);
					dhOrderProduct.setQuantity(cart.getQuantity());
					total += cart.getQuantity() * cart.getPrice();
				}
				dhOrder.setTotal(total);
				dhOrder.addOrderProduct(dhOrderProduct);
				dhOrderProduct.setOrder(orderRepository.save(dhOrder));
				orderProductRepository.save(dhOrderProduct);
				cartRepository.deleteAllCartByUserId(dhUser.getId());
				apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", null);
				return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", null);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}

	}

}
