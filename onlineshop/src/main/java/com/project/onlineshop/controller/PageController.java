package com.project.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController
{
	
	@RequestMapping(value={"/index","/"})
	 public ModelAndView index(){
		  ModelAndView mv = new ModelAndView("page");
		  mv.addObject("message","hello spring ... : ) ");
		 return mv;  
	 }
	

}
