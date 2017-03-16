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

import com.yuzu.dao.ProductDAO;
import com.yuzu.domain.Category;
import com.yuzu.domain.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;

	// add Product
	// method 1 for add Product
	@RequestMapping("/manage_product_create")
	public ModelAndView createProductForm() {
		System.out.println("createProductForm called*****************");
		ModelAndView mv = new ModelAndView("/createProductForm");
		mv.addObject("createProductObj", product);
		return mv;

	}

	// add Product
	// method 2 for add Product
	@RequestMapping(value = "/manage_product_create", method = RequestMethod.POST)
	public ModelAndView createProduct(@ModelAttribute(value = "createProductObj") Product product) {
		System.out.println("createProduct called****");
		ModelAndView mv = new ModelAndView("product");
		if (productDAO.save(product)) {
			mv.addObject("message", "Successfully created the product");
			List<Product> productList = productDAO.list();
			mv.addObject("productList", productList);

		} else {
			mv.addObject("message", "Not able to create Product.Please contact Administrator");

		}
		return mv;

	}

	// delete Product
	@RequestMapping(value = "/manage_product_delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable(value = "id") String id, Model model) {
		System.out.println("deleteProduct called****");

		ModelAndView mv = new ModelAndView("product");
		Product product = (Product) productDAO.getProductByID(id);
		if (productDAO.delete(product)) {
			mv.addObject("messsage", "Successfully deleted the product");
		} else {
			mv.addObject("messsage", "Not able to delete the  product,so please contact administrator");
		}

		model.addAttribute("productList", productDAO.list());
		return mv;

	}

	// edit Product
	// method 1 for edit Product
	@RequestMapping(value = "/manage_product_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditProductForm(@PathVariable(value = "id") String id) {
		System.out.println("getEditProductForm called******");
		
		Product product = (Product) this.productDAO.getProductByID(id);
		return new ModelAndView("editProductForm", "editProductObj", product);
	}

	// edit Product
	// method 2 for edit Product
	@RequestMapping(value = "/manage_product_edit", method = RequestMethod.POST)
	public ModelAndView editProduct(@ModelAttribute(value = "editProductObj") Category category, Model model) {
		System.out.println("editProduct  called****");

		this.productDAO.update(product);
		ModelAndView mv = new ModelAndView("product");
		model.addAttribute("productList", productDAO.list());
		return mv;

	}
}
