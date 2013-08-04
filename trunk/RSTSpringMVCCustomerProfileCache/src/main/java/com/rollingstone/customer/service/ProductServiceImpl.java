package com.rollingstone.customer.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rollingstone.customer.dao.IProductDao;
import com.rollingstone.customer.model.Product;

@Service
public class ProductServiceImpl implements IProductService {
	Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Autowired
	@Qualifier("eCommProps")
	private Properties eCommProps;

	IProductDao productDao;

	public IProductDao getProductDao() {
		return productDao;
	}

	@Autowired
	@Required
	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void addProduct(Product product, MultipartFile file) throws Exception {
		String fileName = file.getOriginalFilename();
		String destPath = eCommProps.getProperty("imageDir")+fileName;
		
		InputStream sourceFile = file.getInputStream();
		this.saveFile(sourceFile, destPath);
		
		product.setProductImagePath(fileName);
		productDao.addProduct(product);
		
		sourceFile.close();
		destPath = null;
	}

	public byte[] getImage(String fileName) throws IOException {
		InputStream is = new FileInputStream(eCommProps.getProperty("imageDir")+fileName);
		BufferedImage img = ImageIO.read(is);
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ImageIO.write(img, FilenameUtils.getExtension(fileName), bao);
		
		return bao.toByteArray();
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public boolean removeProduct(long productId) throws Exception {
		return productDao.removeProduct(productId);
	}

	@Override
	public void updateProduct(Product product, MultipartFile file, boolean isSameImage) throws Exception {
		if(!isSameImage){
			String fileName = file.getOriginalFilename();
			String destPath = eCommProps.getProperty("imageDir")+fileName;
			
			InputStream sourceFile = file.getInputStream();
			this.saveFile(sourceFile, destPath);
			product.setProductImagePath(fileName);
			sourceFile.close();
			destPath = null;
		}
		
		productDao.updateProduct(product);
	}

	public void saveFile(InputStream iStream, String destFile) throws IOException {
		File file = new File(destFile);
		if (!file.exists()) {
			file.createNewFile();
		}
		OutputStream os = new FileOutputStream(file);
		try {
			byte[] buffer = new byte[4096];
			for (int n; (n = iStream.read(buffer)) != -1;) {
				os.write(buffer, 0, n);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			os.close();
		}
	}
}
