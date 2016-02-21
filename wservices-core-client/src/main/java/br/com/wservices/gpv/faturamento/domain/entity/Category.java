package br.com.wservices.gpv.faturamento.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	private Long id;
	
	private String name;

}
