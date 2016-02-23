package com.martini.enterprise.ejb.property;

import java.io.Serializable;

public class PropertyObject implements  Serializable  {

	private static final long serialVersionUID = 1L;

	 private String property;

	public PropertyObject(String value){
	    this.property = value;
	  }

	  public String getProperty() {
	    return property;
	  }

}