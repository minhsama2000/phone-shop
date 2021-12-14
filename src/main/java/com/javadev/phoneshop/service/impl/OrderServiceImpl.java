package com.javadev.phoneshop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.dto.OrderDto;
import com.javadev.phoneshop.entity.DhOrder;
import com.javadev.phoneshop.repository.OrderRepository;
import com.javadev.phoneshop.service.OrderService;
import com.javadev.phoneshop.utility.DateUtil;
import com.javadev.phoneshop.utility.MapperUtil;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;

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

	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

}
