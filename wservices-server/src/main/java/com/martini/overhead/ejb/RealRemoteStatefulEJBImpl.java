package com.martini.overhead.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful(name= RealRemoteStatefulEJB.MAPPED_STATEFULL_NAME, mappedName=RealRemoteStatefulEJB.MAPPED_STATEFULL_NAME)
@Remote(RealRemoteStatefulEJB.class)
public class RealRemoteStatefulEJBImpl implements RealRemoteStatefulEJB{
	
	public String someOutPut(){
        return "Retorna Remote Stateful EJB \n Claudia Time: " + System.currentTimeMillis();
	}
	

}
