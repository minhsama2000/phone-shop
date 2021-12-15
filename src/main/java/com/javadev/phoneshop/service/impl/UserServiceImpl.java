package com.javadev.phoneshop.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javadev.phoneshop.constant.Constant;
import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.dto.UserAndRoleDto;
import com.javadev.phoneshop.dto.UserDto;
import com.javadev.phoneshop.entity.DhUser;
import com.javadev.phoneshop.model.SignUpModel;
import com.javadev.phoneshop.model.UserModel;
import com.javadev.phoneshop.repository.RoleRepository;
import com.javadev.phoneshop.repository.UserRepository;
import com.javadev.phoneshop.service.UserService;
import com.javadev.phoneshop.utility.DateUtil;
import com.javadev.phoneshop.utility.MapperUtil;
import com.javadev.phoneshop.utility.StringUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	private UserDetails userDetails;

	@Override
	public Optional<DhUser> findByUserName(String userName) {
		try {
			return userRepository.findByUsername(userName);
		} catch (Exception ex) {

		}
		return Optional.empty();
	}

	@Override
	public Optional<DhUser> findByEmail(String email) {
		try {
			return userRepository.findByEmail(email);
		} catch (Exception ex) {
			
		}
		return Optional.empty();
	}

	@Override
	public ResponseEntity<ApiResponse> update(UserModel userModel) {
		ApiResponse apiResponse = null;
		DhUser dhUser = null;
		try {
			Optional<DhUser> optionalUser = userRepository.findByUsername(userModel.getUsername());
			if (optionalUser.isPresent()) {
				dhUser = optionalUser.get();
			}
			if(StringUtil.isNullOrEmpty(userModel.getPassword())) {
				dhUser.setAddress(userModel.getAddress());
				dhUser.setEmail(userModel.getEmail());
				dhUser.setPhone(userModel.getPhone());
				dhUser.setName(userModel.getName());
				if(!userModel.getFile().isEmpty()) {
					dhUser.setAvatar(userModel.getFile().getOriginalFilename());
					userModel.getFile().transferTo(new File(Constant.ROOT_UPLOAD_USER + dhUser.getAvatar()));
				}
			}else {
				dhUser.setPassword(new BCryptPasswordEncoder(4).encode(userModel.getPassword()));
			}	
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", dhUser);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", dhUser);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}

	}
	
	@Override
	public ResponseEntity<ApiResponse> updateRole(Integer userId, String role) {
		ApiResponse apiResponse = null;
		DhUser dhUser = null;
		try {
			Optional<DhUser> optionalUser = userRepository.findById(userId);
			if (optionalUser.isPresent()) {
				dhUser = optionalUser.get();
			}
			if(!role.equals("FULLCONTROL")) {
				dhUser.getDhRoles().add(roleRepository.findByName(role).get());
				dhUser.setUpdatedDate(new Date());
				userRepository.save(dhUser);
			}else {
				apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "cannot change role", role);
				return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
			}
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", role);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", role);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}

	}
	
	@Override
	public ResponseEntity<ApiResponse> getAll() {
		ApiResponse apiResponse = null;
		List<DhUser> dhUsers = null;
		List<UserAndRoleDto> userAndRoleDtos = null;
		try {
			dhUsers = userRepository.findAll();
			userAndRoleDtos = dhUsers.stream()
                    .map(val -> MapperUtil.getDtoFromUserAndRole(val)).collect(Collectors.toList());
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", userAndRoleDtos);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", userAndRoleDtos);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}

	}
	
	@Override
	public ResponseEntity<ApiResponse> getOne(Integer id) {
		ApiResponse apiResponse = null;
		UserAndRoleDto dhUserDto = null;
		DhUser dhUser = null;
		try {
			Optional<DhUser> optionalUser = userRepository.findById(id);
			if(optionalUser.isPresent()) {
				dhUser = optionalUser.get();
				dhUserDto = MapperUtil.getDtoFromUserAndRole(dhUser);
			}		
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", dhUserDto);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", dhUserDto);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}

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
			if (findByEmail(signUpModel.getEmail()).isPresent()) {
				apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "email already used", signUpModel);
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
