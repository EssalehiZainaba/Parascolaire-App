package servlets;

import java.io.File
;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;
import entities.Club;
import services.FilesManager;
import services.FilesManagerImpl;
import services.PresentationManager;

/**
 * Servlet implementation class GestionPresentationServlet
 */
@MultipartConfig(location="C:\\Users\\toshiba\\Desktop\\test\\", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class GestionPresentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CHEMIN ="C:\\Users\\toshiba\\Desktop\\test\\" ;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionPresentationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/Responsable/presentationClub.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PresentationManager presentationManager = new PresentationManager();
		String chemin = this.getServletContext().getRealPath("images");
		Club club = presentationManager.managePresentation(request,chemin);
		if(club==null)
		{
			System.out.println("you have a probleme");
			request.setAttribute("pm",presentationManager);
			request.getRequestDispatcher("WEB-INF/Responsable/presentationClub.jsp").forward(request, response);
		}
			
		else
			System.out.println("Congratulations");
		
	}
	
}