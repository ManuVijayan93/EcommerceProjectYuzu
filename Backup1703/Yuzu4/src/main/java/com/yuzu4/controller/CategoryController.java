package com.yuzu4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yuzu.dao.CategoryDAO;
import com.yuzu.domain.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;

	// add Category
	// method 1 for add Categry
	@RequestMapping("/manage_category_create")
	public ModelAndView getcreateCategoryForm() {
		System.out.println("getcreateCategoryForm called*****************");
		ModelAndView mv = new ModelAndView("/createCategoryForm");
		mv.addObject("createCategoryObj", category);
		return mv;

	}

	// add Category
	// method 2 for add Categry
	@RequestMapping(value = "/manage_category_create", method = RequestMethod.POST)
	public ModelAndView createCategory(@ModelAttribute(value = "createCategoryObj") Category category) {
		System.out.println("create category called*****************");

		ModelAndView mv = new ModelAndView("category");
		if (categoryDAO.save(category)) {
			mv.addObject("message", "Successfully created the category");
			List<Category> categoryList = categoryDAO.list();
			mv.addObject("categoryList", categoryList);

		} else {
			mv.addObject("message", "Not able to create Category.Please contact Administrator");

		}
		return mv;

	}

	// @GetMapping("/manage_category_delete/{id}")
	@RequestMapping(value = "/manage_categories_delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable(value = "id") String id, Model model) {
		System.out.println("delete Category called****");

		ModelAndView mv = new ModelAndView("category");
		Category category = (Category) categoryDAO.getCategoryByID(id);
		if (categoryDAO.delete(category)) {
			mv.addObject("messsage", "Successfully deleted the category");
		} else {
			mv.addObject("messsage", "Not able to delete the  category,so please contact administrator");
		}

		model.addAttribute("categoryList", categoryDAO.list());

		return mv;

	}

	// edit Category
	// method 1 for edit Categry
	@RequestMapping(value = "/manage_categories_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditCategoryForm(@PathVariable(value = "id") String id) {
		System.out.println("getEditForm called******");
		Category category = this.categoryDAO.getCategoryByID(id);
		return new ModelAndView("editCategoryForm", "editCategoryObj", category);
	}

	// edit Category
	// method 2 for edit Categry
	@RequestMapping(value = "/manage_categories_edit", method = RequestMethod.POST)
	public ModelAndView editCategory(@ModelAttribute(value = "editCategoryObj") Category category, Model model) {
		System.out.println("edit category called****");

		this.categoryDAO.update(category);
		ModelAndView mv = new ModelAndView("category");
		model.addAttribute("categoryList", categoryDAO.list());
		return mv;

	}
}
