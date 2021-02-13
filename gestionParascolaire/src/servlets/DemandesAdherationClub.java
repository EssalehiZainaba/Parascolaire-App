package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoDemandeInscription;
import dao.DaoDemandeInscriptionImpl;
import dao.JPAUtil;
import entities.DemandeInscription;
import entities.ResponsableClub;

/**
 * Servlet implementation class Demandes
 */
@WebServlet("/Demandes")
public class DemandesAdherationClub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoDemandeInscription daoDemandeInscription;
    /**
     * Default constructor. 
     */
    public DemandesAdherationClub() {
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		EntityManagerFactory factory=JPAUtil.getEntityManagerFactory();
		daoDemandeInscription=new DaoDemandeInscriptionImpl(factory);
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		ResponsableClub responsableClub=(ResponsableClub)session.getAttribute("responsable");
		List<DemandeInscription> demandes=daoDemandeInscription.lister(responsableClub.getClub());
		request.setAttribute("damandes", demandes);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Responsable/demandesAdherationClub.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
