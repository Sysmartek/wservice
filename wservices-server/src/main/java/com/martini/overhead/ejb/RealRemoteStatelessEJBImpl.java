package com.martini.overhead.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name= RealRemoteStatelessEJB.MAPPED_STATELESS_NAME, mappedName=RealRemoteStatelessEJB.MAPPED_STATELESS_NAME)
@Remote(RealRemoteStatelessEJB.class)
public class RealRemoteStatelessEJBImpl implements RealRemoteStatelessEJB{
	
	public String someOutPut(){
        return "Retorna Remote Stateless EJB \n Claudia Time: " + System.currentTimeMillis();
	}
	

}
