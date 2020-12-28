package fr.eni.annuaire.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.annuaire.bll.UserManager;

/**
 * Servlet implementation class ServletEffacer
 */
@WebServlet("/ServletEffacer")
public class ServletEffacer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
//		int id = Integer.parseInt(request.getParameter("id"));
		UserManager mgt = UserManager.getInstance();
		mgt.deleteByEmail(email);
//		mgt.deleteById(id);
//		RequestDispatcher rd = request.getRequestDispatcher("/ServletIndex");
//		rd.forward(request, response);
		response.sendRedirect("ServletIndex");
		
	}

}
