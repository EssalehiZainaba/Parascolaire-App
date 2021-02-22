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
import dao.JPAUtil;

import entities.Club;
import entities.Etudiant;
import services.ShowPresentation;


/**
 * Servlet implementation class PresentationServlet
 */
@WebServlet("/presentation")
public class PresentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoClub daoClub;
	DaoDemandeInscription daoDemandeInscription;
	DaoAppartenance daoAppartenance;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PresentationServlet() {
    	super();
    }
    
	@Override
	public void init() throws ServletException {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        daoClub = new DaoClubImpl(factory);
        daoDemandeInscription = new DaoDemandeInscriptionImpl(factory);
        daoAppartenance = new DaoAppartenanceImpl(factory);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Club club = daoClub.find(request.getParameter("clubName"));
			
			
		ShowPresentation show = new ShowPresentation(daoClub, daoDemandeInscription, daoAppartenance);
		
		
		request.setAttribute("club",club);
		Boolean testShow = false;
		request.setAttribute("showBouton", testShow);
		
		
		HttpSession session = request.getSession();
		
		 if(session.getAttribute("etudiant")!=null) {
			 request.setAttribute("showBouton", show.showBouton(club, (Etudiant) session.getAttribute("etudiant")));
			 this.getServletContext().getRequestDispatcher( "/WEB-INF/Etudiant/presentation.jsp" ).forward( request, response );
		 } 
		 else if(session.getAttribute("responsable")!=null)
			 this.getServletContext().getRequestDispatcher( "/WEB-INF/Responsable/presentation.jsp" ).forward( request, response );
		 
		 else if(session.getAttribute("administrateur")!=null)
			 this.getServletContext().getRequestDispatcher( "/WEB-INF/Administrateur/presentation.jsp" ).forward( request, response );
		 
		 else
			 request.setAttribute("connect", true);
			 this.getServletContext().getRequestDispatcher("/WEB-INF/Public/presentation.jsp").forward(request, response);


	}
	

}
