package com.yuzu4.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yuzu.dao.CategoryDAO;
import com.yuzu.domain.Category;



@Controller
public class AdminController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;


	@RequestMapping("/manage_categories")
	public ModelAndView manageCategories()
	{
		System.out.println("manageCategories");
		ModelAndView mv = new ModelAndView("adminHome");
		mv.addObject("isUserClickedCategories", "true");
	
		List<Category> categoryList= categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		mv.addObject("category", category);
		return mv;

	}

	@RequestMapping("/manage_products")
	public ModelAndView manageProducts() {
		System.out.println("manageProducts");
		ModelAndView mv = new ModelAndView("adminHome");
		mv.addObject("isUserClickedProducts", "true");
		return mv;
	}

	@RequestMapping("/manage_suppliers")
	public ModelAndView manageSuppliers() {
		System.out.println("manageSupplier");
		ModelAndView mv = new ModelAndView("adminHome");
		mv.addObject("isUserClickedSuppliers", "true");
		return mv;

	}

}
