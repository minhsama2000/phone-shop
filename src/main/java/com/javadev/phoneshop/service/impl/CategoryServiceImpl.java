package com.javadev.phoneshop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.entity.DhCategory;
import com.javadev.phoneshop.repository.CategoryRepository;
import com.javadev.phoneshop.service.CategoryService;
import com.javadev.phoneshop.utility.DateUtil;
import com.javadev.phoneshop.utility.StringUtil;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public ResponseEntity<ApiResponse> findAll() {
		List<DhCategory> categorys = null;
		ApiResponse apiResponse = null;
		try {
			categorys = categoryRepository.findAll();
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", categorys);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", categorys);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> saveOne(DhCategory category) {
		ApiResponse apiResponse = null;
		DhCategory dhCategory = null;
		try {
			if (category.getId() == null || category.getId() < 0) {
				dhCategory = categoryRepository.save(CategoryServiceImpl.insertCategory(category));
			} else {
				dhCategory = categoryRepository.findById(category.getId()).get();
				dhCategory = CategoryServiceImpl.updateCategory(category, dhCategory);
				categoryRepository.save(dhCategory);
			}
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", dhCategory);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", dhCategory);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}

	}

	@Override
	public ResponseEntity<ApiResponse> getOne(Integer id) {
		Optional<DhCategory> category = null;
		ApiResponse apiResponse = null;
		try {
			category = Optional.of(categoryRepository.findById(id).get());
			if (category.isPresent()) {
				apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", category);
				return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", null);
		return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
	}

	@Override
	public ResponseEntity<ApiResponse> getListChild(Integer id) {
		List<DhCategory> categories = new ArrayList<DhCategory>();
		ApiResponse apiResponse = null;
		try {
			categories = categoryRepository.getChildById(id);
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", categories);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception

		}
		apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", null);
		return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
	}

	@Override
	public ResponseEntity<ApiResponse> delete(Integer id) {
		ApiResponse apiResponse = null;
		try {
			categoryRepository.deleteById(id);
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", "");
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);

		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", null);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);

		}

	}

	public static DhCategory insertCategory(DhCategory category) {
		category.setCreatedDate(new Date());
		category.setSeo(StringUtil.seo(category.getName() + "-" + System.currentTimeMillis()));
		return category;
	}

	public static DhCategory updateCategory(DhCategory category, DhCategory category2) {
		category2.setUpdatedDate(new Date());
		category2.setSeo(StringUtil.seo(category.getName()) + "-" + System.currentTimeMillis());
		category2.setParentId(category.getParentId());
		category2.setName(category.getName());
		return category2;
	}
}
