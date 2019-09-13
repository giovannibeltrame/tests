package br.com.bb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.entity.Category;
import br.com.bb.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/category/listAll")
	public ResponseEntity<List<Category>> get() {
		return new ResponseEntity<List<Category>>(
				this.categoryService.listAll(),
				HttpStatus.OK);
	}
	
	@GetMapping("/category/findMoreOccurrences/{charac}")
	public ResponseEntity<Category> findMoreOccurrences(@PathVariable char charac) {
		return new ResponseEntity<Category>(
				this.categoryService.findMoreOccurrences(charac),
				HttpStatus.OK);
	}

}
