package com.javadev.phoneshop.controller.client;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.entity.DhUser;
import com.javadev.phoneshop.model.UserInfoModel;
import com.javadev.phoneshop.repository.CartRepository;
import com.javadev.phoneshop.repository.UserRepository;
import com.javadev.phoneshop.service.CheckoutService;
import com.javadev.phoneshop.utility.DateUtil;
import com.javadev.phoneshop.utility.SecurityUtil;

@RestController
@RequestMapping(value = "/api/v1/checkout")
public class CheckoutController {

	private CheckoutService checkoutService;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	public void setCheckoutService(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}

	@PostMapping("/order")
	public ResponseEntity<ApiResponse> saveOrder(@RequestBody UserInfoModel userInfoModel) {
		UserDetails userDetails = SecurityUtil.getUserDetails();
		DhUser dhUser = null;
		Optional<DhUser> optionalUser = userRepository.findByUsername(userDetails.getUsername());
		if (optionalUser.isPresent()) {
			dhUser = optionalUser.get();
		}
		if (cartRepository.findAllByUserId(dhUser.getId()) != null) {
			return checkoutService.saveOrder(userInfoModel);
		} else {
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST)
					.ok(new ApiResponse(415, DateUtil.toStrDate(new Date()), "have no cart", null));
		}

	}
}
