package br.com.bb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.entity.Product;
import br.com.bb.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product/listByCategory/{categoryId}")
	public ResponseEntity<List<Product>> get(@PathVariable Integer categoryId) {
		return new ResponseEntity<List<Product>>(
				this.productService.findByIdCategory(categoryId),
				HttpStatus.OK);
	}
	
	@GetMapping("/product/findAvgPriceValue")
	public ResponseEntity<Double> findAvgPriceValue() {
		return new ResponseEntity<Double>(
				this.productService.findAvgPriceValue(),
				HttpStatus.OK);
	}

}
