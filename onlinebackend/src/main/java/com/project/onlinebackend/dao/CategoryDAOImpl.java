package com.project.onlinebackend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.onlinebackend.dto.Category;


@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO
{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Category> listCategory()
	{
		
		String selectQuery = "From Category where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectQuery);
		query.setParameter("active",true);
		
		return query.getResultList();	
		
	}

	@Override
	public Category get(int id) {
		return  sessionFactory
				  .getCurrentSession()
				     .get(Category.class,Integer.valueOf(id));
	}


	@Override

	public boolean add(Category category) {
          try
          {
        	  sessionFactory.getCurrentSession().persist(category);
        	  return true;
          }catch(Exception e){
        	  e.printStackTrace();
        	  return false;
          }
		
	}



	@Override
	public boolean delete(Category category) {
  		category.setActive(false);
		  try
          {
        	  sessionFactory.getCurrentSession().update(category);
        	  return true;
          }catch(Exception e){
        	  e.printStackTrace();
        	  return false;
          }
}
	

	@Override
	public boolean update(Category category) {
	
		   try
	          {
	        	  sessionFactory.getCurrentSession().update(category);
	        	  return true;
	          }catch(Exception e){
	        	  e.printStackTrace();
	        	  return false;
	          }
	}
	
	

}
