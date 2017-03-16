package com.yuzu.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yuzu.dao.ProductDAO;
import com.yuzu.domain.Product;

import junit.framework.Assert;

public class ProductTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Product product;
	@Autowired
	private static ProductDAO productDAO;

	@BeforeClass
	public static void initialize() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.yuzu.*");
		context.refresh();
		product = (Product) context.getBean(Product.class);

		productDAO = (ProductDAO) context.getBean("productDAO");

	}

	/*@Test
	public void createProductTestCase() {
		product.setId("IDC3090");
		product.setName("NikonP924");
		product.setPrice(30000);
		product.setDescription("Long Zoom Digital Camera");
		product.setCategory_id("CIDC3000");
		product.setSupplier_id("S13000");
		boolean flag = productDAO.save(product);
		Assert.assertEquals("createProductTestCase", true, flag);
	}*/
	
	@Test
	public void deleteProductTestCase() {
		Product product = (Product) productDAO.getProductByID("IDC3002");
		boolean flag = productDAO.delete(product);
		Assert.assertEquals(true, flag);}
		
	/*@Test
	public void updateCategoryTestCase() {
		product.setId("IDC3002");
		product.setName("NikonP900");
		product.setPrice(30000);
		product.setDescription("Long Zoom Digital Camera");
		product.setCategory_id("CIDC3000");
		product.setSupplier_id("S13000");
		boolean flag=productDAO.update(category);
		Assert.assertEquals("update product test case",true, flag);}*/
	
}
