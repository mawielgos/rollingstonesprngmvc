package com.rollingstone.customer.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.rollingstone.customer.model.Product;
import com.rollingstone.customer.service.IProductService;

@Controller
public class ProductController {
	Logger logger = Logger.getLogger(ProductController.class);

	private IProductService productService;

	public IProductService getProductService() {
		return productService;
	}

	@Autowired
	@Required
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/product/add.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String uploadImage(@RequestBody MultipartFile file,
			@RequestParam("productShortName") String productShortName,
			@RequestParam("productName") String productName,
			@RequestParam("productPrice") String productPrice) throws Exception {

		Product product = new Product();
		product.setProductName(productName);
		product.setProductShortName(productShortName);
		product.setProductPrice(Float.parseFloat(productPrice));

		productService.addProduct(product, file);

		return "Success";
	}

	@RequestMapping(value = { "/product/remove.do", "/product/delete.do" }, method = RequestMethod.GET)
	@ResponseBody
	public boolean removeCustomer(@RequestParam("productId") long productId)
			throws Exception {
		System.out.println("Inside removeCustomer");
		productService.removeProduct(productId);
		return true;
	}

	@RequestMapping(value = "/product/update.do", method = RequestMethod.POST)
	@ResponseBody
	public String updateProduct(@RequestBody MultipartFile file,
			@RequestParam("productId") int productId,
			@RequestParam("productShortName") String productShortName,
			@RequestParam("productName") String productName,
			@RequestParam("productPrice") String productPrice,
			@RequestParam("productImageName") String productImageName,
			@RequestParam("sameImage") String sameImage) throws Exception {

		boolean isSameImage = Boolean.parseBoolean(sameImage);
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductShortName(productShortName);
		product.setProductPrice(Float.parseFloat(productPrice));
		if (isSameImage){
			product.setProductImagePath(productImageName);	
		}
		
		productService.updateProduct(product, file, isSameImage);

		return "Success";
	}

	@RequestMapping(value = "/product/list.view", method = RequestMethod.GET)
	public @ResponseBody
	List<Product> listProducts() {
		List<Product> products = productService.getAllProducts();

		return products;
	}

	@RequestMapping(value = "/product/image.view", method = RequestMethod.GET, headers = "Accept=image/jpeg, image/jpg, image/png, image/gif")
	@ResponseBody
	public byte[] displayDocument(@RequestParam("imagePath") String productId) throws IOException {
		return productService.getImage(productId);
	}
}
