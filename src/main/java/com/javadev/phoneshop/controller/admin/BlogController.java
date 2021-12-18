package com.javadev.phoneshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.model.BlogModel;
import com.javadev.phoneshop.service.BlogService;

@RestController
@RequestMapping("/admin/api/v1/blog")
public class BlogController {

	private BlogService blogService;

	@GetMapping("/blogs")
	public ResponseEntity<ApiResponse> getAll() {
		return blogService.getAll();
	}

	@GetMapping("/blog")
	public ResponseEntity<ApiResponse> getOne(@RequestParam Integer id) {
		return blogService.getOne(id);
	}

	@PostMapping("/blog")
	public ResponseEntity<ApiResponse> saveOne(@ModelAttribute BlogModel blogModel) {
		return blogService.saveOne(blogModel);
	}

	@PutMapping("/blog")
	public ResponseEntity<ApiResponse> updateOne(@ModelAttribute BlogModel blogModel) {
		return blogService.updateOne(blogModel);
	}

	@DeleteMapping("/blog")
	public ResponseEntity<ApiResponse> deleteOne(@RequestParam Integer id) {
		return blogService.delete(id);
	}

	@Autowired
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

}
