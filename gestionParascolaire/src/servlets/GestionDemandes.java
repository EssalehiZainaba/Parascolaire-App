package servlets;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.DaoAppartenance;
import dao.DaoAppartenanceImpl;
import dao.DaoClub;
import dao.DaoClubImpl;
import dao.DaoDemandeInscription;
import dao.DaoDemandeInscriptionImpl;
import dao.DaoEtudiant;
import dao.DaoEtudiantImpl;
import dao.JPAUtil;
import entities.ResponsableClub;
import services.GestionDemandeInscription;

/**
 * Servlet implementation class ConfirmerDemandeInscription
 */
@WebServlet("/GestionDemandes")
public class GestionDemandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DaoAppartenance daoAppartenance;
    DaoDemandeInscription daoDemandeInscription;
    DaoEtudiant daoEtudiant;
    DaoClub daoClub;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionDemandes() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		EntityManagerFactory factory=JPAUtil.getEntityManagerFactory();
		daoAppartenance=new DaoAppartenanceImpl(factory);
		daoDemandeInscription=new DaoDemandeInscriptionImpl(factory);
		daoEtudiant=new DaoEtudiantImpl(factory);
		daoClub=new DaoClubImpl(factory);
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		ResponsableClub responsableClub=(ResponsableClub)session.getAttribute("responsable");
		
		int idEtudiant=Integer.parseInt(request.getParameter("id_etudiant"));
		
		GestionDemandeInscription gestionDemandes=new GestionDemandeInscription(daoClub ,daoEtudiant, daoDemandeInscription);
		
		gestionDemandes.confirmerDemande(idEtudiant, responsableClub, daoAppartenance);
		
		response.sendRedirect(request.getContextPath() + "/Demandes");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String confirmerButton=request.getParameter("confirmer");
		String supprimerButton=request.getParameter("supprimer");
		HttpSession session=request.getSession();
		
		ResponsableClub responsableClub=(ResponsableClub)session.getAttribute("responsable");
		
		int idEtudiant=Integer.parseInt(request.getParameter("id_etudiant"));
		
		GestionDemandeInscription gestionDemandes=new GestionDemandeInscription(daoClub ,daoEtudiant, daoDemandeInscription);
		
		if (confirmerButton!=null)
			gestionDemandes.confirmerDemande(idEtudiant, responsableClub, daoAppartenance);
		
		if(supprimerButton!=null) 
			gestionDemandes.supprimerDemande(idEtudiant, responsableClub);
		

		response.sendRedirect(request.getContextPath() + "/Demandes");
		
	}

}
