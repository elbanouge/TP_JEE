package estm.dsic.jee.presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import estm.dsic.jee.business.UserServices;
import estm.dsic.jee.dal.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	UserServices service;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
		service = new UserServices();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String login = request.getParameter("login");
		String pass = request.getParameter("password");

		User user = new User();
		user.setLogin(login);
		user.setPass(pass);

		User usr = service.auth(user);
			
		if (usr != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", usr.getLogin());
			response.sendRedirect("welcome.jsp");

		} else {
			response.sendRedirect("register.jsp");
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
