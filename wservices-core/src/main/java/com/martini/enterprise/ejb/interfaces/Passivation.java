package com.martini.enterprise.ejb.interfaces;

import javax.ejb.Local;

import com.martini.enterprise.ejb.property.PropertyObject;

@Local
public interface Passivation {

	void setPropertyObject(PropertyObject propertyObject);

	PropertyObject getPropertyObject();

}