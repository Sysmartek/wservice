package com.martini.overhead.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.martini.utils.Utils;

@Stateless(name= RealRemoteStatelessEJB.MAPPED_STATELESS_NAME, mappedName=RealRemoteStatelessEJB.MAPPED_STATELESS_NAME)
@Remote(RealRemoteStatelessEJB.class)
public class RealRemoteStatelessEJBImpl implements RealRemoteStatelessEJB{
	
	public String someOutPut(){
        return "Te amo Benzin minha Claudinha -> Retorna Remote Stateless EJB \n Date: " + Utils.DateNowMMMddyyyyHHmmssSSS(); //System.currentTimeMillis();
	}
	

}
