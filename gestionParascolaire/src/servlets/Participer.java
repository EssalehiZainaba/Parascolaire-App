package servlets;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoEtudiant;
import dao.DaoEtudiantImpl;
import dao.JPAUtil;
import entities.Etudiant;
import services.GestionParticipation;

/**
 * Servlet implementation class Participer
 */
@WebServlet("/Participer")
public class Participer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoEtudiant daoEtudiant;
	private DaoActivite daoActivite;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Participer() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		daoEtudiant = new DaoEtudiantImpl(factory);
		daoActivite = new DaoActiviteImpl(factory);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect(request.getContextPath() + "/Activites");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Etudiant etd = daoEtudiant.find(1);
		
		GestionParticipation gestionParticipation = new GestionParticipation(daoActivite, daoEtudiant, etd);
		gestionParticipation.gererParticipation(request);
		
		response.sendRedirect(request.getContextPath() + "/Activites");
	}

}
