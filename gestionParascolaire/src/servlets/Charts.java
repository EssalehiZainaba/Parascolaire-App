package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.tools.javac.util.List;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;
import entities.Activite;

/**
 * Servlet implementation class Charts
 */


public class Charts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Charts() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoActivite daoActivite = new DaoActiviteImpl(JPAUtil.getEntityManagerFactory());		

		request.setAttribute( "activites", daoActivite.liste("social"));

		//java.util.List<Activite> ac = daoActivite.liste("social");
        //System.out.println(ac.get(1).getEtudiants().size());
       // System.out.println(ac.get(1).getId());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Responsable/charts.jsp").forward(request, response);
	}


}
