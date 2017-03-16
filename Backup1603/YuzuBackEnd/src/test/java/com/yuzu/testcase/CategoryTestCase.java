package com.yuzu.testcase;

import org.junit.BeforeClass;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yuzu.dao.CategoryDAO;
import com.yuzu.domain.Category;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CategoryTestCase {

	@Autowired
	 private static Category category;
	
	@Autowired
	 private static CategoryDAO categoryDAO;
	
	
	@BeforeClass
	public static void init()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.yuzu.*");
		context.refresh();
		category=(Category) context.getBean("category");
		
		categoryDAO=(CategoryDAO) context.getBean("categoryDao");
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void createCategoryTestCase()
	{
		category.setId("MyId3");
		category.setName("CAMERA");
		category.setDescription("This is Camera Category");
		boolean flag=categoryDAO.save(category);
		Assert.assertEquals("createCategoryTestCase",true,flag);
	}
	/*@Test
	public void deleteCategoryTestCase() {
		Category category = (Category) categoryDAO.getCategoryByID("MyId1");
		boolean flag = categoryDAO.delete(category);
		Assert.assertEquals(true, flag);}
	@Test
	public void updateCategoryTestCase() {
		category.setId("MyId2");
		category.setName("Canon");
		category.setDescription("This is Camera Category");
		boolean flag=categoryDAO.update(category);
		Assert.assertEquals("update category test case",true, flag);}
	*/
	
	

}
