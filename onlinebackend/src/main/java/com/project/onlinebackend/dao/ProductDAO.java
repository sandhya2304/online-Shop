package com.project.onlinebackend.dao;

import java.util.List;

import com.project.onlinebackend.dto.Product;

public interface ProductDAO
{
	public Product get(int productId);
	
	public Boolean addProduct(Product product);
	public Boolean updateProduct(Product product);
	public Boolean deleteProduct(Product product);
	
	public List<Product> listAll();
	
	//bussiness methods
	List<Product> listActiveProduct();
	List<Product> listActiveProductByCategory(int categoryId);
	List<Product> getLatestActiveProduct(int count);
	

}
