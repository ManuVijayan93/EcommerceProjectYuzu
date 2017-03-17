package com.yuzu.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yuzu.dao.UserDAO;
import com.yuzu.domain.User;

public class UserTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static User user;
	@Autowired
	private static UserDAO userDAO;

	@BeforeClass
	public static void initialize()
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.yuzu.*");
		context.refresh();
		user=(User) context.getBean("user");
		
		userDAO=(UserDAO) context.getBean("userDAO");
		
	}
	@Test
	public void validateCredentialsTestCase()
	{
		
		boolean flag=userDAO.validate("M64", "manu");
		assertEquals("ValidateCredentialsTestCase",true,flag);
	}

}
