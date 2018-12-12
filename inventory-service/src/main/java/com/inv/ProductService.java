package com.inv;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> getRelatedProducts(String category){
		
		List<Product> allProds = repository.findAll();
		
		return allProds.stream()
			.filter(p->p.getCategory().equalsIgnoreCase(category))
			.collect(Collectors.toList());
	}
	
	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	
	public Product findByCode(String code) {
		return repository.findByProductCode(code);
	}
	public void saveProduct(Product prod) {
		repository.save(prod);
	}
	
}
