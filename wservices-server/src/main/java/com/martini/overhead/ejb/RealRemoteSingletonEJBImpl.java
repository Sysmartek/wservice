package com.martini.overhead.ejb;

import javax.ejb.Remote;
import javax.ejb.Singleton;

@Singleton(name= RealRemoteSingletonEJB.MAPPED_SINGLETON_NAME, mappedName=RealRemoteSingletonEJB.MAPPED_SINGLETON_NAME)
@Remote(RealRemoteSingletonEJB.class)
public class RealRemoteSingletonEJBImpl implements RealRemoteSingletonEJB{
	
	public String someOutPut(){
        return "Retorna Remote Singleton EJB \n Claudia Time: " + System.currentTimeMillis();
	}
	

}
