package com.project.onlinebackend.dao;

import com.project.onlinebackend.dto.Address;
import com.project.onlinebackend.dto.Cart;
import com.project.onlinebackend.dto.User;

public interface UserDAO 
{
	
	public boolean addUser(User user);
	
	public boolean addAddress(Address address);
	
	public boolean addCart(Cart cart);
	

}
