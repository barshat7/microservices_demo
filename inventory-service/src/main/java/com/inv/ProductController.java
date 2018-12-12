package com.inv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/related")
	public List<Product> related(@RequestParam("cat") String cat){
		return service.getRelatedProducts(cat);
	}
	
	@GetMapping("/all")
	public List<Product> all(){
		return service.getAllProducts();
	}
	@GetMapping("/bycode")
	public Product byCode(@RequestParam("code") String code) {
		return service.findByCode(code);
	}
}
