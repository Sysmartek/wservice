package com.martini.overhead.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import com.martini.utils.Utils;

@Stateful(name= RealRemoteStatefulEJB.MAPPED_STATEFULL_NAME, mappedName=RealRemoteStatefulEJB.MAPPED_STATEFULL_NAME)
@Remote(RealRemoteStatefulEJB.class)
public class RealRemoteStatefulEJBImpl implements RealRemoteStatefulEJB{
	
	public String someOutPut(){
        return "Te amo Benzin minha Claudinha -> Retorna Remote Stateful EJB \n Date: " + Utils.DateNowMMMddyyyyHHmmssSSS(); //System.currentTimeMillis();
	}
	

}
