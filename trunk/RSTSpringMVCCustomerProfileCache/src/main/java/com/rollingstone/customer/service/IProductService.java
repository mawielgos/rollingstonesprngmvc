package com.rollingstone.customer.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rollingstone.customer.model.Product;

public interface IProductService {

	void addProduct(Product product, MultipartFile file) throws Exception;
	
	List<Product> getAllProducts();
	
	public byte[] getImage(String productId) throws IOException;
	
	boolean removeProduct(long productId) throws Exception;
	
	void updateProduct(Product product, MultipartFile file, boolean sameImage) throws Exception;
}
