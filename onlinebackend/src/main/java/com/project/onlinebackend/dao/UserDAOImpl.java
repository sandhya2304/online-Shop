package com.project.onlinebackend.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.onlinebackend.dto.Address;
import com.project.onlinebackend.dto.Cart;
import com.project.onlinebackend.dto.User;



@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public boolean addUser(User user) {
		 
		try
		{
			
			sessionFactory.getCurrentSession().persist(user);
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addAddress(Address address) {
		try
		{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public User userByEmail(String email) {
		String query = "FROM User where email = :email";
		
		try
		{
		    return sessionFactory.getCurrentSession()
		    		     .createQuery(query,User.class)
		    		     .setParameter("email",email)
			               .getSingleResult();
			
		}catch(Exception e){
			//e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public Address getBillingAddress(User user) {
       String query = "FROM Address where user = :user AND billing = :billing";
		
		try
		{
		    return sessionFactory.getCurrentSession()
		    		     .createQuery(query,Address.class)
		    		     .setParameter("user",user)
		    		     .setParameter("billing",true)
			               .getSingleResult();
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> getListAddress(User user) {
		  String query = "FROM Address where user = :user AND shipping = :shipping";
			
			try
			{
			    return sessionFactory.getCurrentSession()
			    		     .createQuery(query,Address.class)
			    		     .setParameter("user",user)
			    		     .setParameter("shipping",true)
				               .getResultList();
				
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
	}
	
	

}
