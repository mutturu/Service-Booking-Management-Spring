package com.productmanagement.microservice.servicebookingmanagemntproduct.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productmanagement.microservice.servicebookingmanagemntproduct.exception.ResourceNotFoundException;
import com.productmanagement.microservice.servicebookingmanagemntproduct.model.Product;
import com.productmanagement.microservice.servicebookingmanagemntproduct.repository.ProductRepository;
//import com.productmanagement.microservice.servicebookingmanagemntproduct.model.Product;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	// get all Products
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}		
	
	// create Product rest api
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	// get Product by id rest api
		@GetMapping("/products/{id}")
		public ResponseEntity<Product> getProductById(@PathVariable Long id) {
			Product product = productRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
			return ResponseEntity.ok(product);
		}
	// update Product rest api
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
		
		product.setName(productDetails.getName());
		product.setMake(productDetails.getMake());
		product.setModel(productDetails.getModel());
		product.setCost(productDetails.getCost());
		product.setCreatedDate(productDetails.getCreatedDate());
		
		Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	// delete Product rest api
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
		
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
