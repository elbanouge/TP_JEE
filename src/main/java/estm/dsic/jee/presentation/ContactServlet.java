package estm.dsic.jee.presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import estm.dsic.jee.business.ContactServices;
import estm.dsic.jee.dal.Contact;

/**
 * Servlet implementation class ContactServlet
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	ContactServices contactServices;
	public ContactServlet() {
		super();
		// TODO Auto-generated constructor stub
		contactServices = new ContactServices();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//String path = request.getServletPath()+"-"+id;
		//System.out.println("page : " + path);

		String nom = request.getParameter("name");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");

		System.out.println(nom + "-" + email + "-" + adresse + "-" + tel);
		Contact contact = new Contact(nom, adresse, email, tel);
		if (contactServices.add(contact)) {
			System.out.println("ajouter avec succes");
			response.sendRedirect("welcome.jsp");
		} else {
			System.out.println("Error");
			response.sendRedirect("pageError.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
