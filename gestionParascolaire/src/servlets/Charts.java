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


import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoAppartenance;
import dao.DaoAppartenanceImpl;
import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;
import entities.Activite;
import entities.Appartenance;

/**
 * Servlet implementation class Charts
 */


public class Charts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Charts() {
        super();
        // TODO Auto-generated constructor stub
    }
    
     @SuppressWarnings("null")
	public void chartYears(String year, int idClub)
    {
    	int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    	List<Appartenance> app ;
    	int tabNumberEtd[] = null;
    	int tabYear[] = null;
    	
    	for(int i=0; i<currentYear-Integer.parseInt(year) ;i++)
    	{
    		DaoAppartenance daoappartenance = new DaoAppartenanceImpl(JPAUtil.getEntityManagerFactory());		
    		app = (List<Appartenance>) daoappartenance.listerAppartenances(String.valueOf(2020+i), idClub);
    	    tabNumberEtd[i] = app.size();
    	    tabYear[i] = 2020+i;
    	}
    }

	
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoActivite daoActivite = new DaoActiviteImpl(JPAUtil.getEntityManagerFactory());		
		request.setAttribute( "activites", daoActivite.liste("social"));

	
		
		DaoAppartenance daoappartenance = new DaoAppartenanceImpl(JPAUtil.getEntityManagerFactory());		
		
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    	List<Appartenance> app ;
    	int taille = currentYear-2016+1;
    	Integer tabNumberEtd[] = new Integer[taille];
    	Integer tabYear[] = new Integer[taille];
    	
    	for(int i=0; i<taille; i++)
    	{   		
    	    app = (List<Appartenance>) daoappartenance.listerAppartenances(String.valueOf(2016+i), 1);
    	    tabNumberEtd[i] = app.size();
    	    tabYear[i] = 2016+i;
    	  
    	}
    	
    	
    	
    	List<Activite> act ;
     	int taillee = currentYear-2016+1;
     	Integer tabNumberAct[] = new Integer[taillee];
     	Integer tabYears[] = new Integer[taillee];
     	
     	for(int i=0; i<taillee; i++)
     	{   		
     	    act = (List<Activite>) daoActivite.listerActivite(1, String.valueOf(2016+i));
     	    tabNumberAct[i] = act.size();
     	    tabYears[i] = 2016+i;
     	  
     	}
    	
		request.setAttribute( "tabNumberAct",tabNumberAct);
	    request.setAttribute( "tabYears", tabYears);
		
		request.setAttribute( "tabNumberEtd",tabNumberEtd);
	    request.setAttribute( "tabYear", tabYear);

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Responsable/charts.jsp").forward(request, response);
	}


}
