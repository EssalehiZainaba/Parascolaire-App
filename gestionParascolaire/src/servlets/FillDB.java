package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoAdministrateur;
import dao.DaoAdministrateurImpl;
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
import entities.Administrateur;
import entities.Appartenance;
import entities.Club;
import entities.DemandeInscription;
import entities.Etudiant;
import entities.ResponsableClub;

/**
 * Servlet implementation class FillDB
 */
@WebServlet("/FillDB")
public class FillDB extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoEtudiant daoEtudiant;
	private DaoResponsableClub daoRespo;
	private DaoAdministrateur daoAdministrateur;
	private DaoClub daoClub;
	private DaoActivite daoActivite;
	private DaoAppartenance daoAppartenance;
	private DaoDemandeInscription DaoDemandeInscription;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		
		Date date = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate= formatter.format(date);
		
		daoEtudiant = new DaoEtudiantImpl(factory);
        daoRespo = new DaoResponsableClubImpl(factory);
        daoAdministrateur = new DaoAdministrateurImpl(factory);
        daoClub = new DaoClubImpl(factory);
        daoActivite = new DaoActiviteImpl(factory);
        daoAppartenance = new DaoAppartenanceImpl(factory);
        DaoDemandeInscription=new DaoDemandeInscriptionImpl(factory);
        
        
        
		Administrateur administrateur=new Administrateur("admin12@gmail.com","215487poil");		
		daoAdministrateur.add(administrateur);
        
        
		


        Etudiant etd1 = new Etudiant("test1@login.etd", "testpwd");
        etd1.setNom("Nom");
        etd1.setPrenom("Prenom");
        etd1.setCne("D139872516");
        etd1.setFiliere("Génie Informatique");
        etd1.setPays("Maroc");
        etd1.setVille("Agadir");
        daoEtudiant.add(etd1);

        
        Etudiant etd2 = new Etudiant("test2@login.etd", "testpwd");
        etd2.setNom("Nom");
        etd2.setPrenom("Prenom");
        etd2.setCne("D225487965");
        etd2.setFiliere("Génie Industriel");
        etd2.setPays("Maroc");
        etd2.setVille("Agadir");
        daoEtudiant.add(etd2);
        
		
        Etudiant etd3 = new Etudiant("test3@login.etd", "testpwd");
        etd3.setNom("Nom");
        etd3.setPrenom("Prenom");
        etd3.setCne("D885478965");
        etd3.setFiliere("Génie Finance");
        etd3.setPays("Maroc");
        etd3.setVille("Casa");
        daoEtudiant.add(etd3);
        
		
        Etudiant etd4 = new Etudiant("test4@login.etd", "testpwd");
        etd4.setNom("Nom");
        etd4.setPrenom("Prenom");
        etd4.setCne("D542189654");
        etd4.setFiliere("Génie Electrique");
        etd4.setPays("Maroc");
        etd4.setVille("Marrakesh");
        daoEtudiant.add(etd4);
        
		
        Etudiant etd5 = new Etudiant("test5@login.etd", "testpwd");
        etd5.setNom("Nom");
        etd5.setPrenom("Prenom");
        etd5.setCne("D236547896");
        etd5.setFiliere("Génie Mecanique");
        etd5.setPays("Maroc");
        etd5.setVille("Asfi");
        daoEtudiant.add(etd5);
        
		
        Etudiant etd6 = new Etudiant("test6@login.etd", "testpwd");
        etd6.setNom("Nom");
        etd6.setPrenom("Prenom");
        etd6.setCne("D542365896");
        etd6.setFiliere("Génie Informatique");
        etd6.setPays("Maroc");
        etd6.setVille("Taroudant");
        daoEtudiant.add(etd6);
        
		
        Etudiant etd7 = new Etudiant("test7@login.etd", "testpwd");
        etd7.setNom("Nom");
        etd7.setPrenom("Prenom");
        etd7.setCne("D210589601");
        etd7.setFiliere("Génie Informatique");
        etd7.setPays("Maroc");
        etd7.setVille("Tiznit");
        daoEtudiant.add(etd7);
        

        ResponsableClub respo1 = new ResponsableClub("respo1@club.test", "pwd");
        ResponsableClub respo2 = new ResponsableClub("respo2@club.test", "pwd");
        ResponsableClub respo3 = new ResponsableClub("respo3@club.test", "pwd");
        ResponsableClub respo4 = new ResponsableClub("respo4@club.test", "pwd");
        ResponsableClub respo5 = new ResponsableClub("respo5@club.test", "pwd");
        daoRespo.add(respo1);
        daoRespo.add(respo2);
        daoRespo.add(respo3);
        daoRespo.add(respo4);
        daoRespo.add(respo5);
        
        
        
        Club club1 = new Club();
        club1.setName("Among Us");
        club1.setResponsableClub(daoRespo.find(9));
        daoClub.add(club1);
        
        Club club2 = new Club();
        club2.setName("Social");
        club2.setResponsableClub(daoRespo.find(10));
        daoClub.add(club2);
        
        Club club3 = new Club();
        club3.setName("Apps");
        club3.setResponsableClub(daoRespo.find(11));
        daoClub.add(club3);
        
        Club club4 = new Club();
        club4.setName("Langues");
        club4.setResponsableClub(daoRespo.find(12));
        daoClub.add(club4);
        
        Club club5 = new Club();
        club5.setName("Theatre");
        club5.setResponsableClub(daoRespo.find(13));
        daoClub.add(club5);
        
        
        
        this.getServletContext().setAttribute("club", daoClub.lister());
        
        
        
        Activite activite1 = new Activite();
        activite1.setNom("Jester Mod");
        activite1.setClub(daoClub.find(1));
        activite1.setLieu("Salle K2");
        activite1.setPrivee(false);
        activite1.setDate("12/02/2021");
        daoActivite.add(activite1);
        
        Activite activite2 = new Activite();
        activite2.setNom("Mafia Mod");
        activite2.setClub(daoClub.find(1));
        activite2.setLieu("Salle K3");
        activite2.setPrivee(true);
        activite2.setDate("21/02/2021");
        daoActivite.add(activite2);
        
        Activite activite3 = new Activite();

        activite3.setNom("Conférence Harka");
        activite3.setClub(daoClub.find(2));
        activite3.setLieu("Amphi Younes Kellouch");
        activite3.setPrivee(false);
        activite3.setDate("12/02/2021");
        daoActivite.add(activite3);
        
        Activite activite4 = new Activite();

        activite4.setNom("Introduction à Spring");
        activite4.setClub(daoClub.find(3));
        activite4.setLieu("Salle H10");
        activite4.setPrivee(false);
        activite4.setDate("12/02/2021");
        daoActivite.add(activite4);
        
        Activite activite5 = new Activite();

        activite5.setNom("Introduction au Koréan");
        activite5.setClub(daoClub.find(4));
        activite5.setLieu("Salle H11");
        activite5.setPrivee(false);
        activite5.setDate("12/02/2021");
        daoActivite.add(activite5);
        
        Activite activite6 = new Activite();

        activite6.setNom("Introduction à l'Allemand");
        activite6.setClub(daoClub.find(4));
        activite6.setLieu("Salle H10");
        activite6.setPrivee(false);
        activite6.setDate("21/02/2021");
        daoActivite.add(activite6);
        
        Activite activite7 = new Activite();
        activite7.setNom("Entrainement");
        activite7.setClub(daoClub.find(5));
        activite7.setLieu("Amphi Hiba Asri");
        activite7.setPrivee(true);
        activite7.setDate("12/02/2021");
        daoActivite.add(activite7);
        
      
        Appartenance appartenance1 = new Appartenance(daoEtudiant.find(2), daoClub.find(1),strDate);
        daoAppartenance.add(appartenance1);
        
        Appartenance appartenance2 = new Appartenance(daoEtudiant.find(2), daoClub.find(3),strDate);
        daoAppartenance.add(appartenance2);
        
        Appartenance appartenance3 = new Appartenance(daoEtudiant.find(2), daoClub.find(4),strDate);

        daoAppartenance.add(appartenance3);
        

        DemandeInscription demande1=new DemandeInscription();
        demande1.setClub(daoClub.find(1));
        demande1.setEtudiant(daoEtudiant.find(3));
        demande1.setDateDemande(strDate);
        
        DemandeInscription demande2=new DemandeInscription();
        demande2.setClub(daoClub.find(1));
        demande2.setEtudiant(daoEtudiant.find(4));
        demande2.setDateDemande(strDate);
        
        DemandeInscription demande3=new DemandeInscription();
        demande3.setClub(daoClub.find(1));
        demande3.setEtudiant(daoEtudiant.find(5));
        demande3.setDateDemande(strDate);
        
        DemandeInscription demande4=new DemandeInscription();
        demande4.setClub(daoClub.find(1));
        demande4.setEtudiant(daoEtudiant.find(6));
        demande4.setDateDemande(strDate);
        
        DemandeInscription demande5=new DemandeInscription();
        demande5.setClub(daoClub.find(1));
        demande5.setEtudiant(daoEtudiant.find(7));
        demande5.setDateDemande(strDate);
	
        DaoDemandeInscription.add(demande1);
        DaoDemandeInscription.add(demande2);
        DaoDemandeInscription.add(demande3);
        DaoDemandeInscription.add(demande4);
        DaoDemandeInscription.add(demande5);
        
        
        response.sendRedirect(request.getContextPath()+"/Accueil");
	}


}