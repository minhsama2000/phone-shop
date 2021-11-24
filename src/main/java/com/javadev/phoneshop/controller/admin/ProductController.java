package com.javadev.phoneshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.model.DhProductModel;
import com.javadev.phoneshop.service.ProductService;

@Controller
@RequestMapping(value = {"/admin/api/v1/product"})
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<ApiResponse> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/product")
	public ResponseEntity<ApiResponse> getOne(@RequestParam Integer id){
		return productService.getOne(id);
	}
	
	@PostMapping("/product")
	public ResponseEntity<ApiResponse> saveOne(@ModelAttribute DhProductModel dhProductModel){
		return productService.saveOne(dhProductModel);
	}
	
	@PutMapping("/product")
	public ResponseEntity<ApiResponse> update(@ModelAttribute DhProductModel dhProductModel){
		return productService.update(dhProductModel);
	}
	
	@DeleteMapping("/product")
	public ResponseEntity<ApiResponse> delete(@RequestParam Integer id){
		return productService.delete(id);
	}
	
}
