package com.martini.enterprise.ejb.interfaces;

import javax.ejb.Remote;

import com.martini.enterprise.ejb.property.PropertyObject;
import com.tutorialspoint.model.Product;

@Remote
public interface CartRemote {
	String MAPPED_NAME = "CartRemoteNamed";

	void setPropertyObject(PropertyObject propertyObject);

	PropertyObject getPropertyObject();

	void addProductToCart(Product product);

	void checkOut();

	StringBuilder listOfProducts();

	 public String doSomething();
	
}
