package com.project.onlineshop.handler;

import java.io.Serializable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.onlinebackend.dao.UserDAO;
import com.project.onlinebackend.dto.Address;
import com.project.onlinebackend.dto.Cart;
import com.project.onlinebackend.dto.User;
import com.project.onlineshop.model.RegisterModel;


@Component
public class RegisterHandler implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Autowired
	private UserDAO userDAO;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	public RegisterModel init(){
		
		return new RegisterModel();
	}
	
	
	public String validateUser(User user,MessageContext error){
		String transitionValue = "success";
		
		if(!(user.getPassword().equals(user.getConfirmPassword())))
		{
			
			error.addMessage(new MessageBuilder()
					        .error()
					        .source("confirmPassword")
					        .defaultText("Password doesnot macth the conforim password")
					        .build());
			
			transitionValue = "failure";
		}
		
		
		if(userDAO.userByEmail(user.getEmail())!= null)
		{
			
			error.addMessage(new MessageBuilder()
			        .error()
			        .source("email")
			        .defaultText("email alread used!!!")
			        .build());
			
			
			transitionValue = "failure";
		}
		
		return transitionValue;
	}
	
	
	public void addUser(RegisterModel registerModel,User user)
	{
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel,Address billing)
	{
		registerModel.setBilling(billing);
	}
	
	
	public String saveAll(RegisterModel registerModel)
	{
		String transitionValue = "success";
		
		User user = registerModel.getUser();
		
		
		//fetch the user
		if(user.getRole().equals("USER"))
		{
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		
		// encode the password
		  user.setPassword(passwordEncoder.encode(user.getPassword()));
		  
		
		
		//save the user
		userDAO.addUser(user);
		
		//get the address
		
		Address billing = registerModel.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
	
	
	

}
