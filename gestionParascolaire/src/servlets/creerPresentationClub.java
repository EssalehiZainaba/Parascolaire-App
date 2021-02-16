package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoClub;
import dao.DaoClubImpl;
import dao.DaoDemandeInscription;
import dao.DaoDemandeInscriptionImpl;
import dao.DaoEtudiant;
import dao.DaoEtudiantImpl;
import dao.JPAUtil;
import entities.Activite;
import entities.Club;
import entities.DemandeInscription;
import entities.Etudiant;

/**
 * Servlet implementation class creerPresentationClub
 */
@WebServlet("/creerPresentationClub")
public class creerPresentationClub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creerPresentationClub() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoDemandeInscription daoDemandeInscription = new DaoDemandeInscriptionImpl(JPAUtil.getEntityManagerFactory());
		
		DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());
		DaoEtudiant daoEtudiant = new DaoEtudiantImpl(JPAUtil.getEntityManagerFactory());
		
		Club club = daoClub.find(3);
		Etudiant etudiant = daoEtudiant.find(10);
		
		DemandeInscription demandeInscription = daoDemandeInscription.find(club,etudiant);
		System.out.println(demandeInscription.getDateDemande());
		
	/*	Date date = new Date();
		DemandeInscription demandeInscription = new DemandeInscription(etudiant,club,date);*/
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
