package com.martini.overhead.ejb;

import javax.ejb.Stateless;

import com.martini.utils.Utils;

@Stateless
public class RealLocalStatelessEJB {
	
	public String someOutPut(){
        return "Te amo Benzin minha Claudinha -> Retorna Local Stateless EJB \n Date: " + Utils.DateNowMMMddyyyyHHmmssSSS(); //System.currentTimeMillis();
	}
	

}
