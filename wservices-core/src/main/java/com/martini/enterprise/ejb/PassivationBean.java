package com.martini.enterprise.ejb;


import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

import com.martini.enterprise.ejb.interfaces.Passivation;
import com.martini.enterprise.ejb.property.PropertyObject;

@Stateful
public class PassivationBean implements Passivation {

	private PropertyObject myProperty;

	@Override
	public void setPropertyObject(PropertyObject propertyObject) {
		this.myProperty = propertyObject;

	}

	@Override
	public PropertyObject getPropertyObject() {

		return this.myProperty;
	}

	@PrePassivate
	private void prePassivate(){
	    // Free resources 
	    // ...

	    System.out.println("Passivating EJB. Property value: " 
	      + myProperty.getProperty());
	}

	@PostActivate
	private void postActivate(){
	    // Reactivate resources
	    // ...

	    System.out.println("Activating EJB. Property value: " 
	      + myProperty.getProperty());
	}


}