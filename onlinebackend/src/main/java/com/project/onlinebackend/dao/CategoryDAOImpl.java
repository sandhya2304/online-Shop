package com.project.onlinebackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.onlinebackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO
{
	private static List<Category> list = new ArrayList<>(); 
	
	
	static{
		Category cat = new Category();
		cat.setId(1);
		cat.setName("soap");
		cat.setDescription("this is for beauty bar");
		cat.setImageURL("soap.jpg");
		cat.setActive(true);
		
		Category cat2 = new Category();
		cat2.setId(1);
		cat2.setName("Drink");
		cat2.setDescription("this is for Drink");
		cat2.setImageURL("soap.jpg");
		cat2.setActive(true);
		
		list.add(cat);
		list.add(cat2);
		
	}
	
	

	@Override
	public List<Category> listCategory()
	{	
		return list;
	}
	
	

}
