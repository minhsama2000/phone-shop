package com.javadev.phoneshop.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javadev.phoneshop.entity.DhProduct;
import com.javadev.phoneshop.repository.CategoryRepository;
import com.javadev.phoneshop.repository.ProductRepository;
import com.javadev.phoneshop.utility.StringUtil;

@Controller
public class HomeController {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = { "/index", "/home", "/" })
	public String index(Model model) {
		model.addAttribute("phones", categoryRepository.getChildById(14));
		model.addAttribute("tablets", categoryRepository.getChildById(15));
		model.addAttribute("tools", categoryRepository.getChildById(16));
		model.addAttribute("laptops", categoryRepository.getChildById(17));
		return "client/index";
	}

	@GetMapping("/product-details")
	public String productDetails(Model model, @RequestParam Integer id) {
		model.addAttribute("product", productRepository.findById(id).get());
		return "client/product-details";
	}

	@GetMapping("/search")
	public String search(Model model, @RequestParam(required = false) Integer categoryId,
			@RequestParam(required = false) String select, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "8") int size, @RequestParam(required = false) String searchText) {
		int totalSize = 0;
		int choise = 0;
		Integer id = categoryId;
		List<DhProduct> dhProducts = new ArrayList<DhProduct>();
		Pageable paging = PageRequest.of(page, size);
		Page<DhProduct> pageProduct = null;

		if (categoryId != null && categoryId > 0) {
			if (select != null) {
				totalSize = productRepository.findByCategoryId(categoryId).size() % size == 0
						? productRepository.findByCategoryId(categoryId).size() / size
						: productRepository.findByCategoryId(categoryId).size() / size + 1;
				dhProducts = productRepository.findByCategoryIdWithPage(page, size, categoryId);
				choise = 1;
			} else {
				totalSize = productRepository.findByCategoryIdChild(categoryId).size() % size == 0
						? productRepository.findByCategoryIdChild(categoryId).size() / size
						: productRepository.findByCategoryIdChild(categoryId).size() / size + 1;
				dhProducts = productRepository.findByCategoryIdChildWithPage(page, size, categoryId);
				choise = 2;
			}

		} else if (!StringUtil.isNullOrEmpty(searchText)) {
			totalSize = productRepository.findBySearchText(searchText).size() % size == 0
					? productRepository.findBySearchText(searchText).size() / size
					: productRepository.findBySearchText(searchText).size() / size + 1;
			dhProducts = productRepository.findBySearchTextWithPage(page, size, searchText);
			choise = 0;
		} else {
			choise = 3;
			totalSize = productRepository.findAll().size() % size == 0 ? productRepository.findAll().size() / size
					: productRepository.findAll().size() / size + 1;
			pageProduct = productRepository.findAll(paging);
			dhProducts = pageProduct.getContent();
		}
		model.addAttribute("choise", choise);
		model.addAttribute("products", dhProducts);
		model.addAttribute("totalSize", totalSize);
		model.addAttribute("categoryId", id);
		return "client/search";
	}

	@PostMapping("/search")
	public String searchByText(Model model, @RequestParam String searchText, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "8") int size) {
		List<DhProduct> dhProducts = new ArrayList<DhProduct>();
		int choise = 0;
		model.addAttribute("choise", choise);
		model.addAttribute("products", productRepository.findBySearchTextWithPage(page, size, searchText));
		model.addAttribute("totalSize",
				productRepository.findBySearchText(searchText).size() % size == 0
						? productRepository.findBySearchText(searchText).size() / size
						: productRepository.findBySearchText(searchText).size() / size + 1);
		model.addAttribute("searchText", searchText);
		return "client/search";
	}
}
