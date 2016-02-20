package com.martini.enterprise.servlet;

import java.io.IOException;
import java.util.Hashtable;

import javax.ejb.EJB;
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
import com.martini.overhead.ejb.RealRemoteSingletonEJB;
import com.martini.overhead.ejb.RealRemoteStatefulEJB;
import com.martini.overhead.ejb.RealRemoteStatelessEJB;
import com.tutorialspoint.model.Product;

/**
 * Servlet implementation class ShoppingCartServlet
 */
// @WebServlet("/ShoppingCartServlet")
@WebServlet(name = "ShoppingCartServlet", urlPatterns = { "/ShoppingCartServlet" })
public class ShoppingCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CART_SESSION_KEY = "shoppingCart";

	@EJB
	CartRemote cartBean1;

	
	@EJB
	CartRemote cartBean2;

	@EJB
	RealRemoteStatelessEJB realRemoteStateless;

	@EJB
	RealRemoteStatefulEJB realRemoteStateful;

	@EJB
	RealRemoteSingletonEJB realRemoteSingleton;

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

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		
		try {
			
			System.out.println("List of products A1: \n"
					+ cartBean1.listOfProducts());
			//response.getWriter().write("\nCartBean1 List of productsc A1\n" + cartBean1.listOfProducts());

			
			System.out.println("List of products A2: \n"
					+ cartBean2.listOfProducts());
			
			//response.getWriter().write("\nCartBean2 List of productsc A2\n" + cartBean1.listOfProducts());
			
			System.out
					.println("Hello from servlet \n Real Remote Stateless by @EJB : "
							+ realRemoteStateless.someOutPut());
			//response.getWriter().write("\n\nHello from servlet \n Real Remote Stateless by @EJB : "
			//		+ realRemoteStateless.someOutPut());

			System.out
			.println("Hello from servlet \n Real Remote Stateful by @EJB : "
					+ realRemoteStateful.someOutPut());
			
			//response.getWriter().write("\nHello from servlet \n Real Remote Stateful by @EJB : "
			//		+ realRemoteStateful.someOutPut());

			
			System.out
			.println("Hello from servlet \n Real Remote Singleton by @EJB : "
					+ realRemoteSingleton.someOutPut());

			//response.getWriter().write("\nHello from servlet \n Real Remote Singleton by @EJB : "
			//		+ realRemoteSingleton.someOutPut());

			
		} catch (Exception e) {
			System.out
					.println("Exception in Capturing EJB Remote from servlet \n RealRemoteStateless by @EJB ");

			//response.getWriter().write("\nException in Capturing EJB Remote from servlet \n RealRemoteStateless by @EJB ");

		}

		CartRemote cartBeanSession = (CartRemote) request.getSession().getAttribute(
				CART_SESSION_KEY);
		

		if (cartBeanSession == null) {
			// EJB is not yet in the HTTP session
			// This means that the client just sent his first request
			// We obtain a CartBean instance and add it to the session object.
			//try {

				// String jndi_Name =
				// "java:global/EJB-Statefull-SessionBeanEAR/EJB-Statefull-SessionBeanEJB/CartBean!"
				// + "com.martini.enterprise.ejb.Cart";
				// String jndi_Name =
				// "java:global/wservices-sysmartek.rhcloud.com/wservices/CartBeanImpl!com.martini.enterprise.ejb.CartRemote";

				//String jndi_Name = "java:jboss/exported/wservices-ear/wservices-server-1/CartRemoteNamed!com.martini.enterprise.ejb.CartRemote";
				//InitialContext ic = new InitialContext();
				//cartBean1 = (CartRemote) ic.lookup(jndi_Name);

				// cartBean1 = lookupRemoteEJB()

				//ic = new InitialContext();
				//cartBean2 = (CartRemote) ic.lookup(jndi_Name);

				Product productA1 = new Product();
				productA1.setType("Livros");
				productA1.setClassif("Books");
				
				cartBean2.addProductToCart(productA1);
				productA1.setType("Corola");
				productA1.setClassif("Carros");
				
				cartBean2.addProductToCart(productA1);
				Product productA2 = new Product();
				productA2.setType("Onibus");
				productA2.setClassif("Transporte");
				cartBean2.addProductToCart(productA2);

				// cartBean = lookupRemoteEJB(jndi_Name);

				request.getSession().setAttribute(CART_SESSION_KEY, cartBean1);
				
				response.getWriter().write("\nSession shoppingCart created - of CartBean1");
				
				System.out.println("Session shoppingCart created");

			//} catch (NamingException e) {
			//	throw new ServletException(e);
			//}
		}else{
			cartBean1 = cartBeanSession;
			response.getWriter().write("\nCartBean1 Session shoppingCart - recovered from Session created ! ");
			response.getWriter().write("\nproduct A1 \n" + cartBean1.listOfProducts());
			response.getWriter().write("\nproduct A2 \n" + cartBean2.listOfProducts());
		}
		
		String productName = request.getParameter("product");
		String classif = request.getParameter("classif");

		if (productName != null && productName.length() > 0) {

			try {

				Product product1 = new Product();
				product1.setType(productName);
				product1.setClassif(classif);
				
				cartBean1.addProductToCart(product1);
				response.getWriter().write("\nProduct add into CartBean1 shoppingCart : " + productName);
				

			} catch (Exception ex) {
				request.getSession().setAttribute(CART_SESSION_KEY, null);
				response.getWriter().write("\nSet Session into null !");

				throw new ServletException(ex);

			}

			System.out.println("product " + productName + " added");
			System.out.println("List of productsA1: \n"
					+ cartBean1.listOfProducts());
			
			response.getWriter().write("\nproduct A1 \n" + cartBean1.listOfProducts());

			System.out.println("\nproduct A2 ");
			System.out.println("List of productsA2: \n"
					+ cartBean2.listOfProducts());
			
			response.getWriter().write("\nproduct A2 \n" + cartBean2.listOfProducts());

		}

		
		
		String checkout = request.getParameter("checkout");
		if (checkout != null && checkout.equalsIgnoreCase("yes")) {
			// Request instructs to complete the purchase
			cartBean1.checkOut();
			cartBean2.checkOut();
			System.out.println("Shopping cart checked out ");
			
			response.getWriter().write("\nShopping cart checked out in \n CartBean1 and CartBean2");
		}
		
		

	}

//	private static CartRemote lookupRemoteEJB(String jndi_name)
//			throws NamingException {
//		final Hashtable jndiProperties = new Hashtable();
//
//		jndiProperties.put("jboss.naming.client.ejb.context", true);
//		jndiProperties.put(Context.URL_PKG_PREFIXES,
//				"org.jboss.ejb.client.naming");
//
//		final Context context = new InitialContext(jndiProperties);
//
//		final String appName = "";
//		// final String moduleName = "as7project";
//		// final String moduleName = "as7project";
//		final String moduleName = "EJB-Statefull-SessionBeanEAR";
//		final String distinctName = "";
//		final String beanName = CartBeanImpl.class.getSimpleName();
//
//		final String viewClassName = CartRemote.class.getName();
//		System.out.println("Looking EJB via JNDI ");
//		System.out.println("ejb:" + appName + "/" + moduleName + "/"
//				+ distinctName + "/" + beanName + "!" + viewClassName);
//
//		// return (Cart) context.lookup("ejb:" + appName + "/"
//		// + moduleName + "/" + distinctName + "/" + beanName + "!"
//		// + viewClassName);
//
//		return (CartRemote) context.lookup(jndi_name);
//
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
