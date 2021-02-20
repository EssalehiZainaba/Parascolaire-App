package servlets;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoClub;
import dao.DaoClubImpl;
import dao.DaoDemandeInscription;
import dao.DaoDemandeInscriptionImpl;
import dao.DaoEtudiant;
import dao.DaoEtudiantImpl;
import dao.JPAUtil;
import services.GestionAdheration;

/**
 * Servlet implementation class Adheration
 */
@WebServlet("/Adheration")
public class Adheration extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	DaoDemandeInscription daoDemandeInscription;
	DaoClub daoClub;
	DaoEtudiant daoEtudiant;
       
	
	
	@Override
	public void init() throws ServletException {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		daoDemandeInscription = new DaoDemandeInscriptionImpl(factory);
		daoClub = new DaoClubImpl(factory);
		daoEtudiant = new DaoEtudiantImpl(factory);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect(request.getContextPath() + "/Activites");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String clubName = request.getParameter("clubName");
		HttpSession session = request.getSession();
		
		GestionAdheration manager = new GestionAdheration(daoDemandeInscription, daoClub, daoEtudiant);
		manager.Adherer(session, clubName);
		
		
		response.sendRedirect(request.getContextPath()+"/presentation?clubName=" + clubName);	
	}



}
