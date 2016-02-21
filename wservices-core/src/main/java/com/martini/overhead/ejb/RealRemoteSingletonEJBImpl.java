package com.martini.overhead.ejb;

import javax.ejb.Remote;
import javax.ejb.Singleton;

import com.martini.overhead.ejb.interfaces.RealRemoteSingletonEJB;
import com.martini.utils.Utils;

@Singleton(name= RealRemoteSingletonEJB.MAPPED_SINGLETON_NAME, mappedName=RealRemoteSingletonEJB.MAPPED_SINGLETON_NAME)
@Remote(RealRemoteSingletonEJB.class)
public class RealRemoteSingletonEJBImpl implements RealRemoteSingletonEJB{
	
	public String someOutPut(){
        return "Retorna Remote Singleton EJB \n Date: " + Utils.DateNowMMMddyyyyHHmmssSSS(); //System.currentTimeMillis();
	}
	

}
