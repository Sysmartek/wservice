package com.tutorialspoint.model;

import java.io.Serializable;


public class Books  implements Serializable {
	private String name;
	
	public Books(){
	}

	
	public Books(String name){
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

}
