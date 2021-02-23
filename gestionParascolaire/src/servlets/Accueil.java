package servlets;

import java.io.IOException;


import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.DaoUtilisateur;
import dao.DaoUtilisateurImpl;
import dao.JPAUtil;
import entities.Administrateur;
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
	
	@Override
	public void init() throws ServletException {
		
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		daoUtilisateur = new DaoUtilisateurImpl(factory);

 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

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
					response.sendRedirect(request.getContextPath()+"/charts");				
				}
				else  {
					session.setAttribute("administrateur", (Administrateur)utilisateur);
					response.sendRedirect(request.getContextPath()+"/CreerClub");			
				}
		}
		
	}



}
