package servlets;

import java.io.IOException;
import java.util.Date;

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
import dao.JPAUtil;
import entities.Club;
import entities.DemandeInscription;
import entities.Etudiant;

/**
 * Servlet implementation class ajouterDemandeInscription
 */
@WebServlet("/ajouterDemandeInscription")
public class AjouterDemandeInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoDemandeInscription daoDemandeInscription;
	DaoClub daoClub;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterDemandeInscription() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		daoDemandeInscription = new DaoDemandeInscriptionImpl(JPAUtil.getEntityManagerFactory());
		daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idClub =Integer.parseInt(request.getParameter("id"));
		Club club = daoClub.find(idClub);
		HttpSession session = request.getSession();
		Etudiant etudiant = (Etudiant) session.getAttribute("etudiant");
		
		DemandeInscription demandeInscription = new DemandeInscription(etudiant,club,new Date());
		daoDemandeInscription.add(demandeInscription);
		response.sendRedirect(request.getContextPath()+"/Activites");
		
		
	}

}
