package servlets;

import java.io.IOException;
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
import dao.DaoDemandeInscription;
import dao.DaoDemandeInscriptionImpl;
import dao.DaoEtudiant;
import dao.DaoEtudiantImpl;
import dao.DaoResponsableClub;
import dao.DaoResponsableClubImpl;
import dao.JPAUtil;
import entities.Activite;
import entities.Appartenance;
import entities.Club;
import entities.DemandeInscription;
import entities.Etudiant;
import entities.ResponsableClub;

/**
 * Servlet implementation class PresentationServlet
 */
@WebServlet("/PresentationServlet")
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
		this.getServletContext().getRequestDispatcher("/presentation.jsp").forward(request, response);
		
		/*
		 * TEST FOR ONETOONE AND MANYTOONE AND MANYTOMANY
		 */
		
		
		ResponsableClub resp = new ResponsableClub("resp@club.test", "resppwd");
		DaoResponsableClub daoResp = new DaoResponsableClubImpl(JPAUtil.getEntityManagerFactory());
		daoResp.add(resp);
		resp = daoResp.find(1);
		
		
		Club club = new Club();
		club.setName("MyClub");
		club.setDescription("The best club");
		club.setParagraphe("jk");
		club.setResponsableClub(resp);
		
		DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());
		daoClub.add(club);
		club = daoClub.find(1);
		
		Activite activite = new Activite();
		activite.setClub(club);
		activite.setNom_activite("réunion project JEE");
		DaoActivite daoAct = new DaoActiviteImpl(JPAUtil.getEntityManagerFactory());
		daoAct.add(activite);
		
		club = daoClub.find(1);
		System.out.println("Activité's name = "+club.getActivites().get(0).getNom_activite());
		 
		 
		Etudiant etd = new Etudiant("test@test.test", "pwd");
		DaoEtudiant daoEtd = new DaoEtudiantImpl(JPAUtil.getEntityManagerFactory());
		daoEtd.add(etd);
		
		etd = daoEtd.find(2);
		
		Appartenance appar = new Appartenance();
		appar.setEtd(daoEtd.find(2));
		appar.setClub(daoClub.find(1));
		appar.setDateAppartenance(null);
		DaoAppartenance daoAppar = new DaoAppartenanceImpl(JPAUtil.getEntityManagerFactory());
		daoAppar.add(appar);
		
		DemandeInscription demande = new DemandeInscription();
		demande.setEtudiant(daoEtd.find(2));
		demande.setClub(daoClub.find(1));
		demande.setDateDemande(null);
		DaoDemandeInscription daoDemande = new DaoDemandeInscriptionImpl(JPAUtil.getEntityManagerFactory());
		daoDemande.add(demande);
		
		
		
		
		
		/*
		 * TEST FOR INHERITENCE AND ONETOONE
		 */
		
		
		/*
		Etudiant etd = new Etudiant("etd@login.test", "etdpwd");
		DaoEtudiant daoEtd = new DaoEtudiantImpl(JPAUtil.getEntityManagerFactory());
		daoEtd.add(etd);;

		ResponsableClub resp = new ResponsableClub();
		resp.setLogin("resp@club.test");
		resp.setPassword("password");
		DaoResponsableClub daoResp= new DaoResponsableClubImpl(JPAUtil.getEntityManagerFactory());
		daoResp.add(resp);
		ResponsableClub respFind = daoResp.find(2);
		System.out.println("id_resp = "+respFind.getId()+" / login = "+respFind.getLogin()+" / pwd = "+respFind.getPassword());
		
		
		Club club = new Club();
		club.setName("social");
		club.setDescription("amine harka's favourite");
		club.setParagraphe("randomrandomrandom");
		club.setResponsableClub(respFind);  //the second time you test this it will give an error unless you clear the database or change the code (because it will try to map the same responsable for two clubs)
		DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());
		daoClub.add(club);
		
		Club clubFind = daoClub.find(1);
		System.out.println("id_club = "+clubFind.getId()+" / id_resp = "+clubFind.getResponsableClub().getId());
		
		ResponsableClub respFind2 = daoResp.find(2);
		System.out.println("id_resp = "+respFind2.getId()+" / club_name = "+respFind2.getClub().getName());
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
