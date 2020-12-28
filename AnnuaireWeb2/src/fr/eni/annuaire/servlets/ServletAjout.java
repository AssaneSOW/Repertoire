package fr.eni.annuaire.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.annuaire.bll.UserManager;
import fr.eni.annuaire.bo.User;

/**
 * Servlet implementation class ServletAjout
 */
@WebServlet("/ServletAjout")
public class ServletAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = new User(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"), request.getParameter("mdp"), 99);
		UserManager mgt = UserManager.getInstance();
		mgt.save(user);
		response.sendRedirect("ServletIndex");
	}

}
