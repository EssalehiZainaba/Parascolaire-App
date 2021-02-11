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
import dao.DaoEtudiant;
import dao.DaoEtudiantImpl;
import dao.JPAUtil;
import entities.Etudiant;
import services.UpdateProfilForm;

/**
 * Servlet implementation class UpdateProfil
 */
@WebServlet("/Profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoEtudiant daoEtudiant;
	private DaoAppartenance daoAppartenance;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
    	EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
    	
    	daoEtudiant = new DaoEtudiantImpl(factory);
    	daoAppartenance = new DaoAppartenanceImpl(factory);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		//ETUDIANT FROM SESSION
		HttpSession session = request.getSession();
		Etudiant etd = (Etudiant) session.getAttribute("etudiant");
		
		
		//SIDE BAR
		request.setAttribute("mesClubs", daoAppartenance.listerMesClubs(etd));
		request.setAttribute("autresClubs", daoAppartenance.listerAutresClubs(etd));
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Etudiant/profil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ETUDIANT FROM SESSION
		HttpSession session = request.getSession();
		Etudiant etd = (Etudiant) session.getAttribute("etudiant");
		
		
		//SIDE BAR
		request.setAttribute("mesClubs", daoAppartenance.listerMesClubs(etd));
		request.setAttribute("autresClubs", daoAppartenance.listerAutresClubs(etd));
		
		
		UpdateProfilForm form = new UpdateProfilForm(daoEtudiant);
		etd = form.updateProfil(session, request, etd);
	


		this.getServletContext().getRequestDispatcher("/WEB-INF/Etudiant/profil.jsp").forward(request, response);


	}

}
