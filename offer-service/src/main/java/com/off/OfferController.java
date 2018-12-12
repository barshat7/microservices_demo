package com.off;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.off.model.Product;
import com.off.service.IOfferService;

@RestController
public class OfferController {
	
	@Autowired
	private IOfferService service;
	
	@GetMapping("/offer/{email}")
	public List<Product> getSuggestedProducts(@PathVariable("email") String email){
		
		return service.getSuggestedProducts(email);
	}
}
