package com.javadev.phoneshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javadev.phoneshop.repository.OrderRepository;
import com.javadev.phoneshop.repository.UserRepository;

@Controller
@RequestMapping(value = "/admin")
public class AdminHomeController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = {"/index","/","home",""},method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("totalEarn",orderRepository.totalEarn(4));
		model.addAttribute("totalUser",userRepository.findAll().size());
		return "admin/index";
	}
	
	@GetMapping("/table")
	public String table() {
		return "admin/table";
	}
	
	@GetMapping("/order")
	public String order() {
		return "admin/order";
	}
	
	@GetMapping("/user")
	public String user() {
		return "admin/user";
	}
	
	@GetMapping("/blog")
	public String blog() {
		return "admin/blog";
	}
}
