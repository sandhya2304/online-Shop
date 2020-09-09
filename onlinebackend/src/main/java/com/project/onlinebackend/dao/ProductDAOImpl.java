package com.project.onlinebackend.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.onlinebackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int productId)
	{
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Product.class,Integer.valueOf(productId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	@Override
	public Boolean addProduct(Product product)
	{
		try
		{
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean updateProduct(Product product) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();		
			return false;		
		}		
	
	}

	@Override
	public Boolean deleteProduct(Product product) {
		product.setActive(false);
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listAll() {
		
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product" , Product.class)
						.getResultList();
	}

	@Override
	public List<Product> listActiveProduct() 
	{
		String string = "From Product where active =:active";		
		Query query = sessionFactory.getCurrentSession().createQuery(string);
		query.setParameter("active",true);
		
		return query.getResultList();
		
	}

	@Override
	public List<Product> listActiveProductByCategory(int categoryId) {
		String string = "From Product where active =:active And categoryId =:categoryId";		
		Query query = sessionFactory.getCurrentSession().createQuery(string);
		query.setParameter("active",true);
		query.setParameter("categoryId", categoryId);
		
		return query.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		String string = "From Product where active =:active order by id";		
		Query query = sessionFactory.getCurrentSession().createQuery(string);
		query.setParameter("active",true);
		query.setFirstResult(0);
		query.setMaxResults(count);
		
		return query.getResultList();
	}
	
	
	
	
	

}
