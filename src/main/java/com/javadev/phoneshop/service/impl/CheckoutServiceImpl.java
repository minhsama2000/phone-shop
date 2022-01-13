package com.javadev.phoneshop.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.javadev.phoneshop.constant.Constant;
import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.dto.CheckoutResponse;
import com.javadev.phoneshop.entity.DhCart;
import com.javadev.phoneshop.entity.DhOrder;
import com.javadev.phoneshop.entity.DhOrderProduct;
import com.javadev.phoneshop.entity.DhProduct;
import com.javadev.phoneshop.entity.DhUser;
import com.javadev.phoneshop.helper.MomoHelper;
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
import com.mservice.allinone.models.CaptureMoMoResponse;
import com.mservice.allinone.processor.allinone.CaptureMoMo;
import com.mservice.shared.sharedmodels.Environment;

@Service("checkoutService")
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
		Constant.PaymentMethod paymentMethod = Constant.PaymentMethod.getFromEnum(userInfoModel.getPaymentMethod());

		try {
			dhCart = cartRepository.findAllByUserId(dhUser.getId());
			DhOrder dhOrder = MapperUtil.convertModelToEntityOrder(userInfoModel);
			dhOrder.setUserId(dhUser.getId());
			DhOrderProduct dhOrderProduct = null;
			long total = 0;
			for (DhCart cart : dhCart) {
				total += cart.getQuantity() * cart.getPrice();
			}
			dhOrder.setTotal(total);
			dhOrder.setPaymentMethod(userInfoModel.getPaymentMethod());
			CheckoutResponse checkoutResponse = null;
			if (Objects.nonNull(paymentMethod) && paymentMethod.equals(Constant.PaymentMethod.MOMO)) {
				try {
					String transactionId = UUID.randomUUID().toString();
					String requestId = UUID.randomUUID().toString();
					String orderInfo = (new Date()).toString();
					Long totalOrderAmount = total;
					userInfoModel.setTransactionId(transactionId);
					userInfoModel.setRequestId(requestId);
					Environment momoEnvironment = MomoHelper.getMomoEnvironment();
					CaptureMoMoResponse captureMoMoResponse = CaptureMoMo.process(momoEnvironment, transactionId,
							requestId, totalOrderAmount.toString(), orderInfo, "http://localhost:8080/purchase",
							"http://localhost:8080/purchase", StringUtils.EMPTY);
					if (Objects.nonNull(captureMoMoResponse)) {
						userInfoModel.setPayUrl(captureMoMoResponse.getPayUrl());
					}
					 checkoutResponse = findCheckoutResponse(paymentMethod,
							userInfoModel.getPayUrl());
				} catch (Exception ex) {

				}
			}

			DhOrder newOrder = orderRepository.save(dhOrder);
			for (DhCart cart : dhCart) {
				dhOrderProduct = new DhOrderProduct();
				dhProduct = productRepository.findByProductId(cart.getProductId());
				dhOrderProduct.setProductId(cart.getProductId());
				dhOrderProduct.setProductId(cart.getProductId());
				dhOrderProduct.setName(dhProduct.getName());
				dhOrderProduct.setPrice(dhProduct.getPrice());
				dhOrderProduct.setQuantity(cart.getQuantity());
				orderProductRepository.save(dhOrderProduct);
				dhOrderProduct.setOrderId(newOrder.getId());
			}
			cartRepository.deleteAllCartByUserId(dhUser.getId());
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", checkoutResponse);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", null);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}

	}

	@Override
	public ResponseEntity<ApiResponse> deleteOrder(Integer orderId) {
		ApiResponse apiResponse = null;
		DhOrder dhOrder = null;
		try {
			Optional<DhOrder> tempOrder = orderRepository.findById(orderId);
			if (tempOrder.isPresent()) {
				dhOrder = tempOrder.get();
				if (dhOrder.getOrderStatus() < 2) {
					orderProductRepository.deleteByOrderId(orderId);
					orderRepository.deleteById(orderId);
					apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", null);
					return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
				}
			}
			apiResponse = new ApiResponse(415, DateUtil.toStrDate(new Date()), "cannot delete", null);
			return new ResponseEntity<ApiResponse>(HttpStatus.CONFLICT).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", null);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	private com.javadev.phoneshop.dto.CheckoutResponse findCheckoutResponse(Constant.PaymentMethod paymentMethod,
			String payUrl) {
		switch (paymentMethod) {
		case MOMO:
			return com.javadev.phoneshop.dto.CheckoutResponse.getSuccessMomoResponseWithPayUrl(payUrl);
		default:
			return com.javadev.phoneshop.dto.CheckoutResponse.getSuccessCodResponse();
		}
	}

}
