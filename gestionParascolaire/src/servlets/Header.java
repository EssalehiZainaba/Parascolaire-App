package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;

/**
 * Servlet implementation class Header
 */
@WebServlet("/Header")
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());
		 request.setAttribute("clubs", daoClub.lister());
	
		//this.getServletContext().getRequestDispatcher("/WEB-INF/header.jsp").forward(request, response);
		// response.sendRedirect( request.getContextPath() + "/Accueil" );
	}



}
