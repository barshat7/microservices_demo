package com.off.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.off.model.Product;
import com.off.model.UserDetails;

@Service
@Primary
public class NewOfferService implements IOfferService {

	@Value("${membership.name}")
	private String membershipService;
	
	@Value("${inventory.name}")
	private String inventoryService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Product> getSuggestedProducts(String email) {
		
		String userDetailsURI = "http://" + membershipService + "/user?email=" +email;
		URI  uri = URI.create(userDetailsURI);
		UserDetails userDetails = restTemplate.getForObject(uri, UserDetails.class);
		String lastItem = "DEFAULT";
		if(userDetails!=null) {
			lastItem = userDetails.getLastItemPurchased();
		}
		
		String inventoryURI = "http://" +inventoryService +"/product/related?cat=" +lastItem;
		URI uri2 = URI.create(inventoryURI);
		
		Product[] suggestedProducts = restTemplate.getForObject(uri2, Product[].class);
		List<Product> prods = null;
		if(suggestedProducts != null)
			prods = Arrays.asList(suggestedProducts);
		return prods;
		
	}

}
