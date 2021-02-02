package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;
import entities.Activite;
import services.ActiviteManager;

/**
 * Servlet implementation class CreationActivite
 */
@WebServlet("/ajouterActivite")
@MultipartConfig(location="C:\\Users\\toshiba\\Desktop\\test\\", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class CreationActivite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationActivite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());
		 request.setAttribute("clubs", daoClub.lister());
		
		request.getRequestDispatcher("WEB-INF/Responsable/creationActivite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*String chemin = request.getServletContext().getRealPath("images");
		ActiviteManager activiteManager = new ActiviteManager();
		Activite activite = activiteManager.creerActivite(request, chemin);
		if(activite == null)
		{
			request.setAttribute("am",activiteManager);
			request.getRequestDispatcher("WEB-INF/Responsable/creationActivite.jsp").forward(request, response);
		}
			
		else
			System.out.println("good brother");*/
		
		String testNom = request.getParameter("nom");
		System.out.println(testNom);
		
		Boolean test = Boolean.parseBoolean(request.getParameter("privee"));
		System.out.println(test);
		
		}
		
		

}
