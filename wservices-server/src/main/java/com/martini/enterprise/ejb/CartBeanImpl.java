package com.martini.enterprise.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Init;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.tutorialspoint.model.Product;

//@Stateful
//@Stateless(mappedName = CidadeRepositoryRemote.MAPPED_NAME)

//@StatefulTimeout(unit = TimeUnit.SECONDS, value = 20)
//@Remote(CartRemote.class)
@Stateful(name = CartRemote.MAPPED_NAME, mappedName = CartRemote.MAPPED_NAME)
public class CartBeanImpl implements CartRemote {
	
	int counter;
	 
    public String doSomething() {
        counter++;
        System.out.println("Value of counter is " + counter);
        return "Value of counter is " + counter;
 
    }

	@PersistenceContext(unitName = "appCDIUnit", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	private List<Product> products;

	@PostConstruct
	private void initializeBean() {
		products = new ArrayList<Product>();
		System.out.println("Post Construct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("CartBean.preDestroy:" + " bean removed: "
				+ this.getClass().getName());
	}

	@PrePassivate
	public void beforePassivate() {
		System.out.println("CartBean.PrePassivate : BeforePassivate");
	}

	@PostActivate
	public void afterActivation() {
		System.out.println("CartBean.PostActivate : afterActivation");
	}

	@Init
	public void initialize() {
		System.out.println("CartBean.Init : initialize");
	}

	@Remove
	public void stopSession() {
		System.out.println("CartBean.Remove: stopSession");
	}

	@Override
	public void addProductToCart(Product product) {
		products.add(product);

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void checkOut() {
		for (Product product : products) {
			entityManager.persist(product);
		}
		products.clear();

	}

	@Override
	public StringBuilder listOfProducts() {
		StringBuilder listOfProduct = new StringBuilder();
		for (Product product : products) {
			listOfProduct.append(product.toString() + "\n");
		}
		return listOfProduct;
	}

}