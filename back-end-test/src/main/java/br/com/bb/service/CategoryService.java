package br.com.bb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.entity.Category;
import br.com.bb.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> listAll() {
		return this.categoryRepository.listAll();
	}
	
	public Category findMoreOccurrences(char charac) {
		List<Category> allCategories = this.listAll();
		Category category = null;
		Integer geralOccurrences = 0;
		
		for (Category c: allCategories) {
			Integer localOccurrences = 0;
			for (char caractere : c.getName().toLowerCase().toCharArray()) {
				if (caractere == charac) {
					localOccurrences++; 
				} 
			}
			if (localOccurrences > geralOccurrences) {
				geralOccurrences = localOccurrences;
				category = c;
			}
		}
		return category;
	}

}
