package com.tutorialspoint.model;

import java.io.Serializable;
import java.util.Date;

public class Widget implements Serializable {
	
	private Integer id;
	private String name;
	private Date date;
	private String desc;
	
	Widget(Integer id, String name, Date date, String desc) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.desc = desc;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDesc(String desc){
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
}