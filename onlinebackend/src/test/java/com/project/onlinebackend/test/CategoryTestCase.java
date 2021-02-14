package com.project.onlinebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.onlinebackend.dao.CategoryDAO;
import com.project.onlinebackend.dto.Category;

public class CategoryTestCase 
{
	
	
	private static AnnotationConfigApplicationContext context = null;
	private static CategoryDAO categoryDAO = null;
	private Category category = null;
	
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.project.onlinebackend");
		context.refresh();
		
		categoryDAO= (CategoryDAO) context.getBean("categoryDAO");
		
	}
	
	/*@Test
	public void testAddCategory(){
		
		category = new Category();
		category.setName("Music Player");
		category.setDescription("this is for Voice Recording");
		category.setImageURL("music.jpg");
		
		category = new Category();
		category.setName("Television");
		category.setDescription("this is for Television");
		category.setImageURL("Television.jpg");
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("this is for Laptop");
		category.setImageURL("Laptop.jpg");
		
		assertEquals("successfully add the category in table",true,categoryDAO.add(category));
		
	}
	*/
	
	/*
	@Test
	public void testGeCategory(){
		
		category = categoryDAO.get(1);	
		assertEquals("successfully fetch category in table","Television",category.getName());
		
	}*/
	
	

	/*@Test
	public void testUpdateCategory(){
		
		category = categoryDAO.get(1);
		category.setName("TV");
		assertEquals("successfully update single category in table",true,categoryDAO.update(category));
		
	}
	*/

/*	
	
	@Test
	public void testdeleteCategory(){
		
		category = categoryDAO.get(1);
		assertEquals("successfully delete single category in table",true,categoryDAO.delete(category));
		
	}*/
	
	
	/*
	@Test
	public void testListCategory(){
		
		assertEquals("successfully active all category in table",1,categoryDAO.listCategory().size());
		
	}
	*/
	
	

	@Test
	public void testCrudCategory()
	{
		
		category = new Category();
		category.setName("Bags");
		category.setDescription("this is for Bags");
		category.setImageURL("bags.jpg");
		
		assertEquals("successfully add the category in table",true,categoryDAO.add(category));
		
		category = new Category();
		category.setName("Electronics");
		category.setDescription("this is for electronics");
		category.setImageURL("elctronics.jpg");
		
		assertEquals("successfully add the category in table",true,categoryDAO.add(category));
		
		category = categoryDAO.get(1);
		category.setName("Bags");
		assertEquals("successfully update single category in table",true,categoryDAO.update(category));
		
		category = categoryDAO.get(2);
		assertEquals("successfully delete single category in table",true,categoryDAO.delete(category));
		
		
		assertEquals("successfully active all category in table",1,categoryDAO.listCategory().size());
		
	}
	
	
	
	
	
	
}
