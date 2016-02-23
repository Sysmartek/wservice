package com.martini.enterprise.ejb.interfaces;

import javax.ejb.Remote;

import com.martini.enterprise.ejb.property.PropertyObject;
import com.tutorialspoint.model.ProductTest;

@Remote
public interface CartRemote {
	String MAPPED_NAME = "CartRemoteNamed";

	void setPropertyObject(PropertyObject propertyObject);

	PropertyObject getPropertyObject();

	void addProductToCart(ProductTest product);

	void checkOut();

	StringBuilder listOfProducts();

	 public String doSomething();
	
}
