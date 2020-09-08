package com.project.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.onlinebackend.dao.CategoryDAO;
import com.project.onlinebackend.dto.Category;

@Controller
public class PageController
{
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@RequestMapping(value={"/index","/home","/"})
	 public ModelAndView index(){
		  ModelAndView mv = new ModelAndView("page");
		  mv.addObject("title","Home");
		  
		  
		  mv.addObject("categories",categoryDAO.listCategory());
		  
		  mv.addObject("userClickHome",true);
		 return mv;  
	 }
	
	@RequestMapping(value="/about")
	 public ModelAndView abput(){
		  ModelAndView mv = new ModelAndView("page");
		  mv.addObject("title","About Us");
		  mv.addObject("userClickAbout",true);
		 return mv;  
	 }
	

	@RequestMapping(value="/contact")
	 public ModelAndView contact(){
		  ModelAndView mv = new ModelAndView("page");
		  mv.addObject("title","Contact Us");
		  mv.addObject("userClickContact",true);
		 return mv;  
	 }
	
	/*
	 *   method to load all products and based on category
	 * 
	 */
	
	@RequestMapping(value="/show/all/products")
	 public ModelAndView showAllProducts(){
		  ModelAndView mv = new ModelAndView("page");
		  mv.addObject("title","All Products");
		  		  
		  mv.addObject("categories",categoryDAO.listCategory());
		  
		  mv.addObject("userClickAllProducts",true);
		 return mv;  
	 }

	
	/*
	 *   method to load all products and based on category
	 * 
	 */
	
	@RequestMapping(value="/show/category/{id}/products")
	 public ModelAndView showCategoryProducts(@PathVariable int id){
		  ModelAndView mv = new ModelAndView("page");
		  
		  //categorydao to fetch a single category
		  
		  Category cat = null;
		  cat = categoryDAO.get(id);
		  
		  mv.addObject("title",cat.getName());
		  	  
		  mv.addObject("categories",categoryDAO.listCategory());
		  
		  //passing single category object
		  mv.addObject("category",cat);
		  
		  mv.addObject("userClickCategoryProducts",true);
		 return mv;  
	 }
	
	
}
