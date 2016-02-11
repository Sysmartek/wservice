package com.martini.enterprise.servlet;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.martini.enterprise.ejb.CartBeanImpl;
import com.martini.enterprise.ejb.CartRemote;
import com.tutorialspoint.model.Product;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CART_SESSION_KEY = "shoppingCart";

	CartRemote cartBean2 = null;

	public ShoppingCartServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Hello from servlet");

		CartRemote cartBean1 = (CartRemote) request.getSession().getAttribute(
				CART_SESSION_KEY);

		if (cartBean1 == null) {
			// EJB is not yet in the HTTP session
			// This means that the client just sent his first request
			// We obtain a CartBean instance and add it to the session object.
			try {

				// String jndi_Name =
				// "java:global/EJB-Statefull-SessionBeanEAR/EJB-Statefull-SessionBeanEJB/CartBean!"
				// + "com.martini.enterprise.ejb.Cart";

				String jndi_Name = "java:global///CartBeanImpl!com.martini.enterprise.ejb.CartRemote";
				InitialContext ic = new InitialContext();
				cartBean1 = (CartRemote) ic.lookup(jndi_Name);

				//cartBean1 = lookupRemoteEJB()
				
				ic = new InitialContext();
				cartBean2 = (CartRemote) ic.lookup(jndi_Name);

				Product productA1 = new Product();
				productA1.setType("Livros");
				cartBean2.addProductToCart(productA1);
				productA1.setType("Carros");
				cartBean2.addProductToCart(productA1);
				Product productA2 = new Product();
				productA2.setType("Onibus");
				cartBean2.addProductToCart(productA2);

				// cartBean = lookupRemoteEJB(jndi_Name);

				request.getSession().setAttribute(CART_SESSION_KEY, cartBean1);

				System.out.println("Session shoppingCart created");

			} catch (NamingException e) {
				throw new ServletException(e);
			}
		}

		String productName = request.getParameter("product");
		if (productName != null && productName.length() > 0) {

			try {

				Product product1 = new Product();
				product1.setType(productName);
				cartBean1.addProductToCart(product1);

			} catch (Exception ex) {
				request.getSession().setAttribute(CART_SESSION_KEY, null);
				throw new ServletException(ex);

			}

			System.out.println("product " + productName + " added");
			System.out.println("List of productsA1: \n"
					+ cartBean1.listOfProducts());

			System.out.println("\nproduct A2 ");
			System.out.println("List of productsA2: \n"
					+ cartBean2.listOfProducts());

		}

		String checkout = request.getParameter("checkout");
		if (checkout != null && checkout.equalsIgnoreCase("yes")) {
			// Request instructs to complete the purchase
			cartBean1.checkOut();
			cartBean2.checkOut();
			System.out.println("Shopping cart checked out ");
		}

	}

	private static CartRemote lookupRemoteEJB(String jndi_name)
			throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");

		final Context context = new InitialContext(jndiProperties);

		final String appName = "";
		// final String moduleName = "as7project";
		// final String moduleName = "as7project";
		final String moduleName = "EJB-Statefull-SessionBeanEAR";
		final String distinctName = "";
		final String beanName = CartBeanImpl.class.getSimpleName();

		final String viewClassName = CartRemote.class.getName();
		System.out.println("Looking EJB via JNDI ");
		System.out.println("ejb:" + appName + "/" + moduleName + "/"
				+ distinctName + "/" + beanName + "!" + viewClassName);

		// return (Cart) context.lookup("ejb:" + appName + "/"
		// + moduleName + "/" + distinctName + "/" + beanName + "!"
		// + viewClassName);

		return (CartRemote) context.lookup(jndi_name);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
