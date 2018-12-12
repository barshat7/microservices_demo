package com.off;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.off.model.Product;
import com.off.model.UserDetails;

@Service
public class OfferService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Product> getSuggestedProducts(String email){
		
		String userDetailsURI = "http://localhost:8011/user?email=" +email;
		URI  uri = URI.create(userDetailsURI);
		UserDetails userDetails = restTemplate.getForObject(uri, UserDetails.class);
		String lastItem = "DEFAULT";
		if(userDetails!=null) {
			lastItem = userDetails.getLastItemPurchased();
		}
		
		String inventoryURI = "http://localhost:8012/product/related?cat=" +lastItem;
		URI uri2 = URI.create(inventoryURI);
		
		Product[] suggestedProducts = restTemplate.getForObject(uri2, Product[].class);
		List<Product> prods = null;
		if(suggestedProducts != null)
			prods = Arrays.asList(suggestedProducts);
		return prods;
	}
	
}
