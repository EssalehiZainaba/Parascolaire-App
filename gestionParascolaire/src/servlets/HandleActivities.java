package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoResponsableClub;
import dao.DaoResponsableClubImpl;
import dao.JPAUtil;
import entities.Activite;
import entities.ResponsableClub;

/**
 * Servlet implementation class HandleActivities
 */
@WebServlet("/HandleActivities")
public class HandleActivities extends HttpServlet {
	private static final long serialVersionUID = 1L;
     DaoActivite daoActivite;  
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init() throws ServletException
	{
		daoActivite = new DaoActiviteImpl(JPAUtil.getEntityManagerFactory());
	}
    public HandleActivities() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		ResponsableClub responsableClub = (ResponsableClub) session.getAttribute("responsable");
		String clubName = responsableClub.getClub().getName();
		List<Activite> activites = daoActivite.liste(clubName); 
		request.setAttribute("activites",activites);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Responsable/handleActivities.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
