package com.martini.enterprise.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.martini.enterprise.ejb.interfaces.Passivation;
import com.martini.enterprise.ejb.property.PropertyObject;
/*
 * Example of usage Made of Osvaldo Martini
 * http://localhost:8080/wservices-client/PassivationServlet?count=100
 * http://localhost:8080/wservices-client/PassivationServlet?activate=51
 * That’s it. Now to be convinced that the session beans we actually serialized to the disc you can go to
 * Glassfish_installation_folder/glassfish4/glassfish/domains/domain1/session-store
 * Depends on the server
 * 
 */
@WebServlet("/PassivationServlet")
public class PassivationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	Passivation passivation;
	

	public PassivationServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,

	HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Hello from Servlet");

		// InitialContext ic;


		String beanCountparam = request.getParameter("count");

		if (beanCountparam != null) {
			int beanCount = Integer.parseInt(beanCountparam);

			try {
				// ic = new InitialContext();

				for (int i = 0; i < beanCount; i++) {
					
					// passivation = (Passivation) ic
					// .lookup("java:global/wservices-ear/wservices-server-1/PassivationBean!"
					// + "com.martini.enterprise.ejb.Passivation");
					//

					passivation
							.setPropertyObject(new PropertyObject("bean" + i));

					request.getSession().setAttribute("bean" + i, passivation);
				}
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}

		String beanActivationIndex = request.getParameter("activate");

		if (beanActivationIndex != null) {
			try {
				//ic = new InitialContext();

				passivation = (Passivation) request.getSession().getAttribute(
						"bean" + beanActivationIndex);

				System.out.println("TestObject property value: "
						+ passivation.getPropertyObject().getProperty());

			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}