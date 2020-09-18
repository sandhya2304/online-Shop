package com.project.onlineshop.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class GlobalDefaultExceptionHandler
{
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView HandlerNoHandlerFoundException()
	{
		
		ModelAndView mv =new ModelAndView("error");
		mv.addObject("errorTitle","This page is not constructed!!!");
		mv.addObject("errorDescription","This page is not Available Now :) !!!");
		mv.addObject("title","404 Error");
		
		return mv;
	}
	
	

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView HandlerProductNotFoundException()
	{
		
		ModelAndView mv =new ModelAndView("error");
		mv.addObject("errorTitle","Product Not Available!!!");
		mv.addObject("errorDescription","This product is not Available Right Now :) !!!");
		mv.addObject("title","Product Error");
		
		return mv;
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView HandlerException(Exception ex)
	{
		
		ModelAndView mv =new ModelAndView("error");
		mv.addObject("errorTitle","Contact Your Administrator !!!");
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription",sw.toString());
		mv.addObject("title","Error");
		
		return mv;
	}
	
	

}
