package com.javadev.phoneshop.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.javadev.phoneshop.repository.BlogRepository;
import com.javadev.phoneshop.repository.ProductRepository;

@Controller("/clientBlogController")
public class BlogController {

	private BlogRepository blogRepository;
	private ProductRepository productRepository;

	@GetMapping("/news")
	public String news(Model model) {
		model.addAttribute("blogs",blogRepository.findAll());
		model.addAttribute("topProducts",productRepository.findTopAsc(4));
		model.addAttribute("topBlog",blogRepository.findTopAsc(3));
		return "client/news";
	}

	@Autowired
	public void setBlogRepository(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

}
