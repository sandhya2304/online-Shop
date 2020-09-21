package com.project.onlineshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.onlinebackend.dao.CategoryDAO;
import com.project.onlinebackend.dao.ProductDAO;
import com.project.onlinebackend.dto.Category;
import com.project.onlinebackend.dto.Product;



@Controller
@RequestMapping(value="/manage")
public class ManagementController
{
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@Autowired
	private ProductDAO productDAO;
	
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name="operation",required=false)String operation)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products ");
		
		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		if(operation != null){
			if(operation.equals("product")){
				mv.addObject("msg","Product Submitted Successfully !!!");
			}
		}
		
		
		mv.addObject("product",nProduct);
		
		return mv;
	}
	
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,BindingResult results,Model model)
	{
		
		if(results.hasErrors()){
			
			
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products ");
			model.addAttribute("msg","validation product submittion failed!! ");
			
			
			return "page";
		}
		
		logger.info(mProduct.toString());
		
		productDAO.addProduct(mProduct);
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	
	@ModelAttribute("categories")
	public List<Category> listCategories(){
		
		return categoryDAO.listCategory();	
	}
	
	
	
	
	
	
	
	
	

}
