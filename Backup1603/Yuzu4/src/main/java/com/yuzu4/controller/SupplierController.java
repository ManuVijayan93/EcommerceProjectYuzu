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

import com.yuzu.dao.SupplierDAO;
import com.yuzu.domain.Product;
import com.yuzu.domain.Supplier;

@Controller
public class SupplierController {

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	// add Supplier
	// method 1 for add Supplier
	@RequestMapping("/manage_supplier_create")
	public ModelAndView createSupplierForm() {
		System.out.println("createSupplierForm called*****************");
		ModelAndView mv = new ModelAndView("/createSupplierForm");
		mv.addObject("createSupplierObj", supplier);
		return mv;

	}

	// add Product
	// method 2 for add Product
	@RequestMapping(value = "/manage_supplier_create", method = RequestMethod.POST)
	public ModelAndView createSupplier(@ModelAttribute(value = "createProductObj") Product product) {
		System.out.println("createProduct called****");
		ModelAndView mv = new ModelAndView("supplier");
		if (supplierDAO.save(supplier)) {
			mv.addObject("message", "Successfully created the Supplier");
			List<Supplier> supplierList = supplierDAO.list();
			mv.addObject("supplierList", supplierList);

		} else {
			mv.addObject("message", "Not able to create Product.Please contact Administrator");

		}
		return mv;

	}

	// delete a supplier
	@RequestMapping(value = "/manage_supplier_delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSupplier(@PathVariable(value = "id") String id, Model model) {
		System.out.println("deleteSupplier called****");

		ModelAndView mv = new ModelAndView("supplier");
		Supplier supplier = (Supplier) supplierDAO.getSupplierByID(id);
		if (supplierDAO.delete(supplier)) {
			mv.addObject("messsage", "Successfully deleted the supplier");
		} else {
			mv.addObject("messsage", "Not able to delete the  supplier,so please contact administrator");
		}

		model.addAttribute("supplierList", supplierDAO.list());
		return mv;

	}

	// edit Supplier
	// method 1 for edit Supplier
	@RequestMapping(value = "/manage_supplier_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditSupplierForm(@PathVariable(value = "id") String id) {
		System.out.println("getEditSupplierForm called******");

		Supplier supplier = (Supplier) this.supplierDAO.getSupplierByID(id);
		return new ModelAndView("editSupplierForm", "editSupplierObj", supplier);
	}

	// edit Supplier
	// method 2 for edit Supplier
	@RequestMapping(value = "/manage_supplier_edit", method = RequestMethod.POST)
	public ModelAndView editSupplier(@ModelAttribute(value = "editProductObj") Supplier supplier, Model model) {
		System.out.println("editSupplier  called****");

		this.supplierDAO.update(supplier);
		ModelAndView mv = new ModelAndView("supplier");
		model.addAttribute("supplierList", supplierDAO.list());
		return mv;

	}

}
