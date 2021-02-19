package servlets;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;
import services.DeleteClubManager;

/**
 * Servlet implementation class SupprimerClub
 */
@WebServlet("/SupprimerClub")
public class SupprimerClub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoClub daoClub;
	DaoActivite daoActivite;
       

    public SupprimerClub() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init() throws ServletException {
		
    	EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		daoClub = new DaoClubImpl(factory);
		daoActivite= new DaoActiviteImpl(factory);

 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String clubName = request.getParameter("clubName");
		String chemin = (String) request.getServletContext().getAttribute("chemin");
		
		DeleteClubManager manager = new DeleteClubManager(daoClub, daoActivite);
		manager.deleteClub(clubName, chemin);
		
		
		this.getServletContext().setAttribute("club", daoClub.lister());
		response.sendRedirect( request.getContextPath() + "/CreerClub" );
		
	}



}
