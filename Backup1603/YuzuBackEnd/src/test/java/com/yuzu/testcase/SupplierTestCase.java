package com.yuzu.testcase;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yuzu.dao.SupplierDAO;
import com.yuzu.domain.Supplier;

public class SupplierTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Supplier supplier;
	@Autowired
	private static SupplierDAO supplierDAO;

	@BeforeClass
	public static void initialize() 
	{

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.yuzu.*");
		context.refresh();
		supplier = (Supplier) context.getBean(Supplier.class);

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
	}

	/*@Test
	public void createSupplierTestCase()
	{
		supplier.setId("S3004");
		supplier.setName("Ezone");

		supplier.setAddress("Ayodhya321,Noida");

		boolean flag = supplierDAO.save(supplier);
		Assert.assertEquals("createSupplierTestCase", true, flag);
	}*/

	
	 /* @Test 
	  public void deleteSupplierTestCase() 
	  { 
		  Supplier supplier =(Supplier) supplierDAO.getSupplierByID("S3004"); 
	  boolean flag =supplierDAO.delete(supplier); 
	  Assert.assertEquals("delete supplier test case",true, flag);
	  }*/
	 

	
	  @Test
   public void updateSupplierTestCase() 
	  {
		  Supplier supplier =(Supplier) supplierDAO.getSupplierByID("S3007");
		  supplier.setId("S3012");
	  supplier.setName("MCameras");
	  
	 supplier.setAddress("Ayodhya22,Bombay");
	 
	  boolean flag = supplierDAO.update(supplier);
	  
	  Assert.assertEquals("update supplier test case",true, flag);}
	 

}
