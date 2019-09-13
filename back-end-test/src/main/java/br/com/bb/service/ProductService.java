package br.com.bb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.entity.Product;
import br.com.bb.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> findByIdCategory(Integer id) {
		return this.productRepository.findByIdCategory(id);
	}
	
	public Double findAvgPriceValue() {
		return this.productRepository.findAvgPriceValue();
	}
}
