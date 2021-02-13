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

import entities.Club;


/**
 * Servlet implementation class PresentationServlet
 */
@WebServlet("/presentation")
public class PresentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PresentationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("clubId"));
		DaoClub dc = new DaoClubImpl(JPAUtil.getEntityManagerFactory());
		Club club = dc.find(id);
		request.setAttribute("club",club);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Public/presentation.jsp").forward(request, response);

	}
	

}
