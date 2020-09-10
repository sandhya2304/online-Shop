package com.project.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.onlinebackend.dao.ProductDAO;
import com.project.onlinebackend.dto.Product;

@Controller
@RequestMapping(value="/json/data")
public class JsonDataController
{
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value="/all/products")
	@ResponseBody
	public List<Product> listAllProduct(){
		return productDAO.listActiveProduct();
	}
	
	
	@RequestMapping(value="/category/{id}/products")
	@ResponseBody
	public List<Product> getPrdouctByCategory(@PathVariable int id){
		return productDAO.listActiveProductByCategory(id);
	}
	

}
