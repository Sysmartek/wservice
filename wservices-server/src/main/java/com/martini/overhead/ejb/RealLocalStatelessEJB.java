package com.martini.overhead.ejb;

import javax.ejb.Stateless;

import com.martini.utils.Utils;

@Stateless
public class RealLocalStatelessEJB {
	
	public String someOutPut(){
        return "Retorna Local Stateless EJB \n Date: " + Utils.DateNowMMMddyyyyHHmmssSSS(); //System.currentTimeMillis();
	}
	

}
