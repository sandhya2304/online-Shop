package com.project.onlinebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.project.onlinebackend.dao.ProductDAO;
import com.project.onlinebackend.dto.Product;



public class ProductTestCase
{
	
	private static AnnotationConfigApplicationContext context = null;
	private static ProductDAO productDao = null;
	
	private Product product ;
	
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.project.onlinebackend");
		context.refresh();
		
		productDao = (ProductDAO) context.getBean("productDAO");		
	}
	
	@Test
	public void test(){
		
		product = new Product();
		product.setName("This is OPPO");
		product.setBrand("OPPP");
		product.setDescription("This is OPPO description");
		product.setUnitPrice(23770);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("product is add in table",true,productDao.addProduct(product));		
	}
	
	
	
	@Test
	public void testListActiveProducts(){
	
		assertEquals("product is not list in table",1,productDao.getLatestActiveProduct(1).size());
			
	}
	
	
	
	
	
	
	
	

}
