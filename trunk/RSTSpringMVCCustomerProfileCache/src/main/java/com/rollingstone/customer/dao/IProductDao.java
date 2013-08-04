package com.rollingstone.customer.dao;

import java.util.List;

import com.rollingstone.customer.model.Product;

public interface IProductDao {

	void addProduct(Product product) throws Exception;
	
	List<Product> getAllProducts();
	
	boolean removeProduct(long productId) throws Exception;
	
	boolean updateProduct(Product product) throws Exception;
}
