package servlets;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoAdministrateur;
import dao.DaoAdministrateurImpl;
import dao.DaoAppartenance;
import dao.DaoAppartenanceImpl;
import dao.DaoClub;
import dao.DaoClubImpl;
import dao.DaoEtudiant;
import dao.DaoEtudiantImpl;
import dao.DaoResponsableClub;
import dao.DaoResponsableClubImpl;
import dao.DaoUtilisateur;
import dao.DaoUtilisateurImpl;
import dao.JPAUtil;
import entities.Activite;
import entities.Administrateur;
import entities.Appartenance;
import entities.Club;
import entities.Etudiant;
import entities.ResponsableClub;
import entities.Utilisateur;
import services.ConnexionForm;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil" )
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoUtilisateur daoUtilisateur;
	private DaoEtudiant daoEtudiant;
	private DaoResponsableClub daoRespo;
	private DaoAdministrateur daoAdministrateur;
	private DaoClub daoClub;
	private DaoActivite daoActivite;
	private DaoAppartenance daoAppartenance;

	@Override
	public void init() throws ServletException {
		
	/*	EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		
		daoUtilisateur = new DaoUtilisateurImpl(factory);
        daoEtudiant = new DaoEtudiantImpl(factory);
        daoRespo = new DaoResponsableClubImpl(factory);
        daoAdministrateur = new DaoAdministrateurImpl(factory);
        daoClub = new DaoClubImpl(factory);
        daoActivite = new DaoActiviteImpl(factory);
        daoAppartenance = new DaoAppartenanceImpl(factory);
        
        
        
		Administrateur administrateur=new Administrateur("admin12@gmail.com","215487poil");		
		daoAdministrateur.add(administrateur);
        
        
		
        Etudiant etd = new Etudiant("test@login.etd", "testpwd");
        etd.setNom("Nom");
        etd.setPrenom("Prenom");
        etd.setCne("D139872516");
        etd.setFiliere("G�nie Informatique");
        etd.setPays("Maroc");
        etd.setVille("Agadir");
        daoEtudiant.add(etd);
        

        
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
        club1.setResponsableClub(daoRespo.find(3));
        daoClub.add(club1);
        
        Club club2 = new Club();
        club2.setName("Social");
        club2.setResponsableClub(daoRespo.find(4));
        daoClub.add(club2);
        
        Club club3 = new Club();
        club3.setName("Apps");
        club3.setResponsableClub(daoRespo.find(5));
        daoClub.add(club3);
        
        Club club4 = new Club();
        club4.setName("Langues");
        club4.setResponsableClub(daoRespo.find(6));
        daoClub.add(club4);
        
        Club club5 = new Club();
        club5.setName("Theatre");
        club5.setResponsableClub(daoRespo.find(7));
        daoClub.add(club5);
        
        
        
        this.getServletContext().setAttribute("club", daoClub.lister());
        
        
        
        Activite activite1 = new Activite();
        activite1.setNom_activite("Jester Mod");
        activite1.setClub(club1);
        activite1.setLieu_activite("Salle K2");
        activite1.setPrivee(false);
        daoActivite.add(activite1);
        
        Activite activite2 = new Activite();
        activite2.setNom_activite("Mafia Mod");
        activite2.setClub(club1);
        activite2.setLieu_activite("Salle K3");
        activite2.setPrivee(true);
        daoActivite.add(activite2);
        
        Activite activite3 = new Activite();
        activite3.setNom_activite("Conf�rence Harka");
        activite3.setClub(club2);
        activite3.setLieu_activite("Amphi Younes Kellouch");
        activite3.setPrivee(false);
        daoActivite.add(activite3);
        
        Activite activite4 = new Activite();
        activite4.setNom_activite("Introduction � Spring");
        activite4.setClub(club3);
        activite4.setLieu_activite("Salle H10");
        activite4.setPrivee(false);
        daoActivite.add(activite4);
        
        Activite activite5 = new Activite();
        activite5.setNom_activite("Introduction au Kor�an");
        activite5.setClub(club4);
        activite5.setLieu_activite("Salle H11");
        activite5.setPrivee(false);
        daoActivite.add(activite5);
        
        Activite activite6 = new Activite();
        activite6.setNom_activite("Introduction � l'Allemand");
        activite6.setClub(club4);
        activite6.setLieu_activite("Salle H10");
        activite6.setPrivee(false);
        daoActivite.add(activite6);
        
        Activite activite7 = new Activite();
        activite7.setNom_activite("Entrainement");
        activite7.setClub(club5);
        activite7.setLieu_activite("Amphi Hiba Asri");
        activite7.setPrivee(true);
        daoActivite.add(activite7);
        
        
        
        Appartenance appartenance1 = new Appartenance(daoEtudiant.find(2), daoClub.find(1));
        daoAppartenance.add(appartenance1);
        
        Appartenance appartenance2 = new Appartenance(daoEtudiant.find(2), daoClub.find(3));
        daoAppartenance.add(appartenance2);
        
        Appartenance appartenance3 = new Appartenance(daoEtudiant.find(2), daoClub.find(4));
        daoAppartenance.add(appartenance3);*/
		
	
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println(daoUtilisateur.getIdByEmail("admin12@gmail.com"));
		/*System.out.println(daoUtilisateur.getUserType(1));
		System.out.println(daoUtilisateur.getUserType(2));
		System.out.println(daoUtilisateur.getUserType(7));*/
		HttpSession session = request.getSession();
		DaoEtudiant daoEtudiant = new DaoEtudiantImpl(JPAUtil.getEntityManagerFactory());
		Etudiant etudiant = daoEtudiant.find(1);
		session.setAttribute("etudiant", etudiant);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Public/accueil.jsp").forward(request, response);
	
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		ConnexionForm form=new ConnexionForm(daoUtilisateur);
		Utilisateur utilisateur=form.creerUtilisateur(request);
		if(form.getErreur().size()!=0) {
			request.setAttribute("erreurs",form.getErreur());
			this.getServletContext().getRequestDispatcher("/WEB-INF/Public/accueil.jsp").forward(request, response);
		}
		
		else {
				HttpSession session=request.getSession();
				if(form.getUserType().equals("Etudiant")) {
					session.setAttribute("etudiant", (Etudiant)utilisateur);
					response.sendRedirect(request.getContextPath()+"/Activites");
				}
				else if (form.getUserType().equals("ResponsableClub")) {
					session.setAttribute("responsable", (ResponsableClub)utilisateur);
					response.sendRedirect(request.getContextPath()+"/ajouterActivite");				
				}
				else  {
					session.setAttribute("administrateur", (Administrateur)utilisateur);
					response.sendRedirect(request.getContextPath()+"/CreerClub");			
				}
		}
		
	}



}
