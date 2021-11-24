package com.javadev.phoneshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.entity.DhCategory;
import com.javadev.phoneshop.service.CategoryService;

@Controller
@RequestMapping("/admin/api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public ResponseEntity<ApiResponse> findAll(){
		return categoryService.findAll();
	}
	
	@PostMapping("/category")
	public ResponseEntity<ApiResponse> saveOne(@RequestBody DhCategory category){
		return categoryService.saveOne(category);
	}
	
	@GetMapping("/category")
	public ResponseEntity<ApiResponse> getOne(@RequestParam Integer id){
		return categoryService.getOne(id);
	}
	
	@PutMapping("/category")
	public ResponseEntity<ApiResponse> update(@RequestBody DhCategory category){
		return categoryService.saveOne(category);
	}
	
	@DeleteMapping("/category")
	public ResponseEntity<ApiResponse> delete(@RequestParam Integer id){
		return categoryService.delete(id);
	}

}
