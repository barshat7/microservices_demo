package com.inv.configs;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inv.Product;
import com.inv.ProductRepository;

@Component
public class AutoConfigs {
	@Autowired
	private ProductRepository repo;
	@PostConstruct
	public void init() {
		Product p1 = new  Product(0L,"V_FH","VEG","Farm House","A pizza that goes ballistic on veggies!","Medium",399.0);
		Product p2 = new  Product(0L,"V_M","VEG","Veg Margherita","A hugely popular margherita, with a deliciously tangy single cheese topping","Medium",299.0);
		Product p3 = new  Product(0L,"V_MG","VEG","Mexican Green Wave","A pizza loaded with crunchy onions, crisp capsicum, juicy tomatoes and jalapeno with a liberal sprinkling of exotic Mexican herbs.","Large",699.0);
		
		Product p4 = new  Product(0L,"NV_PB","NON_VEG","PEPPER BARBECUE","Pepper Barbecue Chicken I Cheese","Medium",299.0);
		Product p5 = new  Product(0L,"NV_GD","NON_VEG","Golden Delight","Barbeque chicken with a topping of golden corn ","Medium",399.0);
		
		repo.save(p1);
		repo.save(p2);
		repo.save(p3);
		repo.save(p4);
		repo.save(p5);
		
	}
}
