package com.project.onlineshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.onlinebackend.dao.CategoryDAO;
import com.project.onlinebackend.dao.ProductDAO;
import com.project.onlinebackend.dto.Category;
import com.project.onlinebackend.dto.Product;
import com.project.onlineshop.util.FileUploadUtility;
import com.project.onlineshop.validator.ProductValidator;



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
			}else if(operation.equals("category")){
				mv.addObject("msg","Catgeory Submitted Successfully !!!");
			}
		}
		
		
		mv.addObject("product",nProduct);
		
		return mv;
	}
	
	

	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products ");
		
		//fetch the product id
		Product nProduct = productDAO.get(id);

		//set the product fetch from database
		mv.addObject("product",nProduct);
		
		return mv;
	}
	
	
	
	
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,
			                                BindingResult results,Model model,HttpServletRequest request)
	{
		
		if(mProduct.getId() == 0)
		{
		  new ProductValidator().validate(mProduct, results);
		}else{
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				 new ProductValidator().validate(mProduct, results);
			}
		}
		
		if(results.hasErrors()){
			
			
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products ");
			model.addAttribute("msg","validation product submittion failed!! ");
			
			
			return "page";
		}
		
		logger.info(mProduct.toString());
		
		
		if(mProduct.getId() == 0)
		{
		  productDAO.addProduct(mProduct);
		}else{
			productDAO.updateProduct(mProduct);
		}
		  
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id)
	{
		
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		
		product.setActive(!product.isActive());
		productDAO.updateProduct(product);
		
		return (isActive) ? "You have successfully deactivate the product is "+ product.getId() : 
			                 "You have successfully activate the product is "+ product.getId() ;
	}
	
	
	@ModelAttribute("categories")
	public List<Category> listCategories(){
		
		return categoryDAO.listCategory();	
	}
	
	@ModelAttribute("category")
	public Category getCategory()
	{
		return new Category();
	}
	
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category)
	{	
		categoryDAO.add(category);
	
		return "redirect:/manage/products/?operation=category";
	}
	
	

}
