package com.martini.overhead.ejb;

import javax.ejb.Stateless;

@Stateless
public class RealLocalStatelessEJB {
	
	public String someOutPut(){
        return "Retorna Local Stateless EJB \n Claudia Time: " + System.currentTimeMillis();
	}
	

}
