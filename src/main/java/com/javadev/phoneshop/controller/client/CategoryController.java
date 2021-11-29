package com.javadev.phoneshop.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.service.CategoryService;

@RestController(value = "categoryControllerClient")
@RequestMapping(value = "/api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/category")
	public ResponseEntity<ApiResponse> getChild(@RequestParam Integer id){
		return categoryService.getListChild(id);
	}
	
}
