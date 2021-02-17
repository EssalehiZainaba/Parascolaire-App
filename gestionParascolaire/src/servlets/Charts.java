package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoAppartenance;
import dao.DaoAppartenanceImpl;
import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;
import entities.Activite;
import entities.Appartenance;
import entities.Club;
import entities.ResponsableClub;
import services.ChartsForm;

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
		
		HttpSession session = request.getSession();
		ResponsableClub responsableClub = (ResponsableClub) session.getAttribute("responsable");
		Club club = responsableClub.getClub();
		int idClub = club.getId();
		
		DaoActivite daoActivite = new DaoActiviteImpl(JPAUtil.getEntityManagerFactory());		
		request.setAttribute( "activites", daoActivite.liste(club.getName()));

		ChartsForm chart = new ChartsForm();
		Integer[] tabNumberAct = chart.tabAct(idClub);
		Integer[] tabYears = chart.Year();
		Integer[] tabYear = chart.Year();
		Integer[] tabNumberEtd = chart.tabEtd(idClub);


    	
		request.setAttribute( "tabNumberAct",tabNumberAct);
	    request.setAttribute( "tabYears", tabYears);
		
		request.setAttribute( "tabNumberEtd",tabNumberEtd);
	    request.setAttribute( "tabYear", tabYear);

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Responsable/charts.jsp").forward(request, response);
	}


}
