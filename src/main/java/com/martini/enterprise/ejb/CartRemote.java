package com.martini.enterprise.ejb;

import com.tutorialspoint.model.Product;



//@Local
public interface CartRemote {
	
	String MAPPED_NAME = "cartEJBName";
	
	  void addProductToCart(Product product);
	  
	  void checkOut();
	  
	  StringBuilder listOfProducts();

}
