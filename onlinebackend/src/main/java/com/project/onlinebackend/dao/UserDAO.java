package com.project.onlinebackend.dao;

import java.util.List;

import com.project.onlinebackend.dto.Address;
import com.project.onlinebackend.dto.Cart;
import com.project.onlinebackend.dto.User;

public interface UserDAO 
{
	
	public boolean addUser(User user);
	
	public User userByEmail(String email);
	
	public boolean addAddress(Address address);
	public Address getBillingAddress(User user);
	public List<Address> getListAddress(User user);
	
	public boolean updateCart(Cart cart);
	

}
