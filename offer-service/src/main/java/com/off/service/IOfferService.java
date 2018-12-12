package com.off.service;

import java.util.List;

import com.off.model.Product;

public interface IOfferService {

	public List<Product> getSuggestedProducts(String email);
}