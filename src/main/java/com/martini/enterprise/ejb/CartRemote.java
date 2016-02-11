package com.martini.enterprise.ejb;

import com.tutorialspoint.model.Product;



//@Local
public interface CartRemote {
	
	  void addProductToCart(Product product);
	  
	  void checkOut();
	  
	  StringBuilder listOfProducts();

}
