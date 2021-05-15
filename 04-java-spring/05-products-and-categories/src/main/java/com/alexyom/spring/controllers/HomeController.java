package com.alexyom.spring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexyom.spring.models.Category;
import com.alexyom.spring.models.Product;
import com.alexyom.spring.services.CategoryService;
import com.alexyom.spring.services.ProductService;

@Controller
public class HomeController {
	@Autowired
	private CategoryService cService;
	@Autowired
	private ProductService pService;
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/new.jsp";
		}
		pService.createProduct(product);
		return "redirect:/products/new";
	}
	
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		}
		cService.createCategory(category);
		return "redirect:/categories/new";
	}
	
	@GetMapping("/product/{id}")
	public String showProduct(@PathVariable("id") Long id, Model viewModel) {
		Product product = this.pService.findById(id);
		viewModel.addAtribute("product", product);
		
	}
}
