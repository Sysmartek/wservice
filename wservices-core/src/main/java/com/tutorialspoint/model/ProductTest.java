package com.tutorialspoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PRODUCT_TEST") //, catalog = "shopping")
public class ProductTest implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private int id;

  @Column(name = "TYPE", nullable = false)
  private String type;

  @Column(name = "Classif", nullable = false)
  private String classif;

  
  public int getId() {
	return id;
  }

  public String getType() {
	return type;
  }

  public void setType(String description) {
	this.type = description;
  }

    
  public String getClassif() {
	return classif;
}

public void setClassif(String classif) {
	this.classif = classif;
}

@Override
  public String toString(){
	  return Integer.toString(id) + '-' + type + " Classif: " + classif;
  }
}