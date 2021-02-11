package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoAppartenance;
import dao.DaoAppartenanceImpl;
import dao.JPAUtil;
import entities.Activite;
import entities.Etudiant;
import services.ShowActivites;

/**
 * Servlet implementation class Activites
 */
@WebServlet("/Activites")
public class Activites extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoActivite daoActivite;
	private DaoAppartenance daoAppartenance;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Activites() {
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
        EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        daoActivite = new DaoActiviteImpl(factory);
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

		String clubName = request.getParameter("clubName");
		String strPrivee = request.getParameter("privee");
		boolean privee = Boolean.parseBoolean(strPrivee);
		
		ShowActivites showActivites = new ShowActivites(daoActivite, etd);
		List<Activite> activites = showActivites.listActivites(clubName, privee);
		List<Boolean> listParticipe = showActivites.listParticipe(etd, activites);
		String result = showActivites.getResult();

		
		request.setAttribute("activites", activites);
		request.setAttribute("listParticipe", listParticipe);
		request.setAttribute("clubName", clubName);
		request.setAttribute("privee", strPrivee);
		if(result != null)
			request.setAttribute("result", result);

		this.getServletContext().getRequestDispatcher("/WEB-INF/Etudiant/activites.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
