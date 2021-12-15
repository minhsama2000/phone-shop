package com.javadev.phoneshop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.dto.OrderDto;
import com.javadev.phoneshop.entity.DhOrder;
import com.javadev.phoneshop.entity.DhOrderProduct;
import com.javadev.phoneshop.entity.DhUser;
import com.javadev.phoneshop.repository.OrderProductRepository;
import com.javadev.phoneshop.repository.OrderRepository;
import com.javadev.phoneshop.repository.UserRepository;
import com.javadev.phoneshop.service.OrderService;
import com.javadev.phoneshop.utility.DateUtil;
import com.javadev.phoneshop.utility.MapperUtil;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;

	private OrderProductRepository orderProductRepository;

	private UserRepository userRepository;

	@Override
	public ResponseEntity<ApiResponse> getAll() {
		ApiResponse apiResponse = null;
		List<DhOrder> dhOrders = new ArrayList<DhOrder>();
		List<OrderDto> dhOrderDtos = new ArrayList<OrderDto>();
		try {
			dhOrders = orderRepository.findAll();
			dhOrderDtos = dhOrders.stream().map(val -> MapperUtil.convertDhOrderToDto(val))
					.collect(Collectors.toList());
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", dhOrderDtos);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", dhOrderDtos);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> getAllByOrderStatus(int status) {
		ApiResponse apiResponse = null;
		List<DhOrder> dhOrders = new ArrayList<DhOrder>();
		List<OrderDto> orderDtos = null;
		try {
			dhOrders = orderRepository.findByOrderStatus(status);
			orderDtos = dhOrders.stream().map(val -> MapperUtil.convertDhOrderToDto(val)).collect(Collectors.toList());
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", orderDtos);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", orderDtos);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> getAllForUser(String username) {
		ApiResponse apiResponse = null;
		List<DhOrder> dhOrders = new ArrayList<DhOrder>();
		List<OrderDto> orderDtos = null;
		DhUser dhUser = null;
		try {
			Optional<DhUser> optionalUser = userRepository.findByUsername(username);
			if(optionalUser.isPresent()) {
				dhUser = optionalUser.get();
				dhOrders = orderRepository.findByUserId(dhUser.getId());
				orderDtos = dhOrders.stream().map(val -> MapperUtil.convertDhOrderToDto(val)).collect(Collectors.toList());
			}	
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", orderDtos);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", orderDtos);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> getOne(Integer orderId) {
		ApiResponse apiResponse = null;
		DhOrder dhOrder = null;
		OrderDto dhOrderDto = new OrderDto();
		List<DhOrderProduct> dhOrderProducts = null;
		try {
			Optional<DhOrder> optionalOrder = orderRepository.findById(orderId);
			if (optionalOrder.isPresent()) {
				dhOrder = optionalOrder.get();
				dhOrderProducts = orderProductRepository.findByOrderId(dhOrder.getId());
				dhOrderDto = MapperUtil.convertDhOrderToDto(dhOrder);
				dhOrderDto.setDhOrderProductDtos(MapperUtil.convertListOrderProductToListDto(dhOrderProducts));
			}
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", dhOrderDto);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", dhOrderDto);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> update(Integer orderId, int status) {
		ApiResponse apiResponse = null;
		DhOrder dhOrder = null;
		try {
			Optional<DhOrder> optionalOrder = orderRepository.findById(orderId);
			if (optionalOrder.isPresent()) {
				dhOrder = optionalOrder.get();
				if (status > 1 && status <= 4) {
					dhOrder.setOrderStatus(status);
					orderRepository.save(dhOrder);
				} else {
					apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()),
							"không thể đổi trạng thái khi đã xác nhận hoặc đã hoàn thành", null);
					return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
				}
			}
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", null);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", null);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Autowired
	public void setOrderProductRepository(OrderProductRepository orderProductRepository) {
		this.orderProductRepository = orderProductRepository;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
