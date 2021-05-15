package com.alexyom.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexyom.spring.models.Category;
import com.alexyom.spring.models.Product;
import com.alexyom.spring.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	
	// Get All
	public List<Product> getAllProducts() {
		return this.pRepo.findAll();
	}
	
	//Find by ID
	public Product findById(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	//Create
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	//Update a Category
	public Product updateProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	//
	public List<Product> getUniqueCategory(Category category) {
		return this.pRepo.findByCategoriesNotContains(category);
	}
}
