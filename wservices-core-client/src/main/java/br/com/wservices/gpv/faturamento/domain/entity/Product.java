package br.com.wservices.gpv.faturamento.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	private Long id;


 private String productName;
 
 private double price;
 
 @ManyToOne
 private Category category;
}
