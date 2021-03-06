package com.project.onlineshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.onlinebackend.dao.CategoryDAO;
import com.project.onlinebackend.dao.ProductDAO;
import com.project.onlinebackend.dto.Category;
import com.project.onlinebackend.dto.Product;
import com.project.onlinebackend.dto.User;
import com.project.onlineshop.exception.ProductNotFoundException;

@Controller
public class PageController
{
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value={"/index","/home","/"})
	 public ModelAndView index(){
		  ModelAndView mv = new ModelAndView("page");
		  mv.addObject("title","Home");
		  
		  logger.info("inside page control index  -INFO");
		  logger.debug("inside page control index  -DEBUG");
		  
		  mv.addObject("categories",categoryDAO.listCategory());
		  
		  mv.addObject("userClickHome",true);
		 return mv;  
	 }
	
	@RequestMapping(value="/about")
	 public ModelAndView about(){
		  ModelAndView mv = new ModelAndView("page");
		  mv.addObject("title","About Us");
		  mv.addObject("userClickAbout",true);
		 return mv;  
	 }
	
	/* Login Page  */
	@RequestMapping(value="/login")
	 public ModelAndView login(@RequestParam(name="error",required=false)String error,
			              @RequestParam(name="logout",required=false)String logout)
	{
		
		ModelAndView mv = new ModelAndView("login");
		  
		  if(error != null)
		  {
			  mv.addObject("msg","Invalid credentials");
		  }
		  
		  if(logout != null)
		  {
			  mv.addObject("logout","Logout Successfully ..");
		  }
		  
		  mv.addObject("title","Login");
		 return mv;  
	 }
	
	//logout
		@RequestMapping(value="/performlogout")
		public String logout(HttpServletRequest request,HttpServletResponse response)
		{
			Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		
			
			if(auth != null)
			{
				new SecurityContextLogoutHandler().logout(request,response, auth);
			}
			
			
			return "redirect:/login?logout";
		}
		
	
	@RequestMapping(value="/access-denied")
	 public ModelAndView error(){
		  ModelAndView mv = new ModelAndView("error");
		  mv.addObject("title","403- Error");
		  mv.addObject("errorTitle","Aha Caught you !!!");
		  mv.addObject("errorDescription","You are not Authorized to view this page !!!");
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
	/*
	 * 
	 * View Single Product
	 * 
	 */
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id)throws ProductNotFoundException
	{
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		if(product == null){
			throw new ProductNotFoundException();
		}
		
		//update the views
		product.setViews(product.getViews() + 1);
		productDAO.updateProduct(product);
		
		//display the product
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		
		mv.addObject("userClickShowProduct",true);
		
		return mv;
	}
	
	
	/**  having similar mapping to flow id   **/
	@RequestMapping(value="/register")
	 public ModelAndView register(){
		  ModelAndView mv = new ModelAndView("page");
		  mv.addObject("title","Contact Us");
		 return mv;  
	 }
	
	
	
	
}
