package fr.eni.annuaire.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.annuaire.bll.UserManager;
import fr.eni.annuaire.bo.User;

/**
 * Servlet implementation class ServletModif
 */
@WebServlet("/ServletModif")
public class ServletModif extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user;
		UserManager mgt = UserManager.getInstance();
		user = mgt.findById(id);
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/saisie.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = new User(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"), request.getParameter("mdp"), Integer.parseInt(request.getParameter("id")));
		UserManager mgt = UserManager.getInstance();
		mgt.update(user);
		response.sendRedirect("ServletIndex");
	}

}
