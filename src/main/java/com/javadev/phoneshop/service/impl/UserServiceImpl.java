package com.javadev.phoneshop.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.entity.DhUser;
import com.javadev.phoneshop.model.SignUpModel;
import com.javadev.phoneshop.repository.RoleRepository;
import com.javadev.phoneshop.repository.UserRepository;
import com.javadev.phoneshop.service.UserService;
import com.javadev.phoneshop.utility.DateUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<DhUser> findByUserName(String userName) {
		try {
			return userRepository.findByUsername(userName);
		} catch (Exception ex) {

		}
		return Optional.empty();
	}

	@Override
	public ResponseEntity<ApiResponse> signup(SignUpModel signUpModel) {
		DhUser dhUser = null;
		ApiResponse apiResponse = null;
		try {
			if (findByUserName(signUpModel.getUsername()).isPresent()) {
				apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "username already used",
						signUpModel);
				return new ResponseEntity<ApiResponse>(HttpStatus.METHOD_FAILURE).ok(apiResponse);
			}
			if (!signUpModel.getPassword().equals(signUpModel.getPassword_confirmation())) {
				apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "password is not same", signUpModel);
				return new ResponseEntity<ApiResponse>(HttpStatus.METHOD_FAILURE).ok(apiResponse);
			}
			dhUser = convertUserModelToUser(signUpModel);
			userRepository.save(dhUser);
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", signUpModel);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", signUpModel);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}

	}

	private DhUser convertUserModelToUser(SignUpModel model) {
		DhUser dhUser = new DhUser();
		dhUser.setName(model.getName());
		dhUser.setEmail(model.getEmail());
		dhUser.setCreatedDate(new Date());
		dhUser.setPassword(new BCryptPasswordEncoder(4).encode(model.getPassword_confirmation()));
		dhUser.setUsername(model.getUsername());
		dhUser.getDhRoles().add(roleRepository.findByName("USER").get());
		return dhUser;
	}
}
