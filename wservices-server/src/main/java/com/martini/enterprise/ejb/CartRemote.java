package com.martini.enterprise.ejb;

import javax.ejb.Remote;

import com.tutorialspoint.model.Product;



@Remote
public interface CartRemote {
	
	String MAPPED_NAME = "CartRemoteNamed";
	
	  void addProductToCart(Product product);
	  
	  void checkOut();
	  
	  StringBuilder listOfProducts();

}
