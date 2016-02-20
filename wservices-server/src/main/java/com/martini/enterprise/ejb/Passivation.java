package com.martini.enterprise.ejb;

import javax.ejb.Local;

import com.martini.enterprise.ejb.property.PropertyObject;

@Local
public interface Passivation {

	void setPropertyObject(PropertyObject propertyObject);

	PropertyObject getPropertyObject();

}