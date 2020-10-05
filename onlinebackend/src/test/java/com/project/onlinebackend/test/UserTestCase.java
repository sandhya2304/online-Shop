package com.project.onlinebackend.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.onlinebackend.dao.UserDAO;
import com.project.onlinebackend.dto.Address;
import com.project.onlinebackend.dto.Cart;
import com.project.onlinebackend.dto.User;





public class UserTestCase 
{
	
	private static AnnotationConfigApplicationContext context ;
	private static UserDAO userDAO ;
	
	private User user = null;
	private Address address = null;
	private Cart cart =null;
	
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.project.onlinebackend");
		
		context.refresh();
		
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");		
	}
	
	@Test
	public void testAddUser()
	{
		
	    user=new User();
		user.setFirstName("Ram");
		user.setLastName("Sharma");
		user.setEmail("ram@gmail.com");
		user.setContactNumber("98730000");
		user.setRole("USER");
		user.setPassword("1234");
		
		
		assertEquals("Failed to add user",true,userDAO.addUser(user));
		

		address = new Address();
		address.setAddressLineOne("R/12 JP");
		address.setAddressLineTwo("School");
		address.setCity("Mumbai");
		address.setState("Maharastra");
		address.setCountry("India");
		address.setPostalCode("201101");
		address.setBilling(true);
		
		address.setUser_id(user.getId());
		
		assertEquals("Failed to add Address",true,userDAO.addAddress(address));
		
		if(user.getRole().equals("USER"))
		{
			cart = new Cart();
			cart.setUser_id(user.getId());
			
			assertEquals("Failed to add Cart",true,userDAO.addCart(cart));
			
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			
			//set shipping to true
			address.setShipping(true);
			
			address.setUser_id(user.getId());
			
			assertEquals("Failed to add shiipping Address",true,userDAO.addAddress(address));
			
		}
		
		
	}
	
	
	
	

}
