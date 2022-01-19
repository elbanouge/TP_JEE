package estm.dsic.jee.presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import estm.dsic.jee.business.UserServices;
import estm.dsic.jee.dal.User;

/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	UserServices service;
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
        service = new UserServices();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String login = request.getParameter("login");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		User user = new User();
		user.setLogin(login);
		user.setEmail(email);
		user.setPass(pass);
		
		if(service.save(user) == true) {
			response.sendRedirect("index.jsp");
		}
		else {
			
			response.sendRedirect("register.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
