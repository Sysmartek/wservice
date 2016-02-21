package br.com.wservices.gpv.faturamento.domain.entity;

import java.util.List;

import com.mysema.query.jpa.hibernate.HibernateQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import static br.com.wservices.gpv.faturamento.domain.entity.QProduct.product;

public class DemoService {
	
	public List<Product> findProductsByNameAndCategoryID(String name, Long categoryId){
		HibernateQuery qry = createQuery(product);
		
		if (name != null) {
			qry.where(product.productName.like(name));
		}
		
		if (categoryId != null) {
			qry.where(product.category.id.eq(categoryId));
		}
		
		return qry.list(product);
		
	}

	private HibernateQuery createQuery(QProduct product) {
		return new HibernateQuery().from(product);
	}
	
	

	

}
