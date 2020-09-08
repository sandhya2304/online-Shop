package com.project.onlinebackend.dao;

import java.util.List;

import com.project.onlinebackend.dto.Category;

public interface CategoryDAO
{
	
	List<Category> listCategory();

	Category get(int id);

}
