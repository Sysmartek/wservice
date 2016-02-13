package com.martini.overhead.ejb;

import javax.ejb.Stateless;

@Stateless
public class RealEJB {
	
	public String someOutPut(){
        return "Retorna Stateless Real EJB \n Claudia Time: " + System.currentTimeMillis();
	}
	

}
