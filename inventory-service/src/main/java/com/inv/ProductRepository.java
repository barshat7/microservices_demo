package com.inv;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
	public Product findByProductCode(String productCode);
}
