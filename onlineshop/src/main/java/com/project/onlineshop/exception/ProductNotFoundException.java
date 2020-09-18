package com.project.onlineshop.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String msg;
	
	
	public ProductNotFoundException()
	{
		this("Product is not Found !!!");
	}


	public ProductNotFoundException(String msg) {
		this.msg = System.currentTimeMillis() +" : " +msg;
	}


	public String getMsg() {
		return msg;
	}


	

}
