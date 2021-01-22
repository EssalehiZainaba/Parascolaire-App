package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import beans.Club;
import dao.DaoClub;
import dao.DaoClubImpl;
import dao.HibernateUtil;

/**
 * Servlet implementation class PresentationServlet
 */
@WebServlet("/PresentationServlet")
public class PresentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private DaoClub daoClub;
    public PresentationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	public void init() throws ServletException{
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		this.daoClub = new DaoClubImpl(factory);
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
<<<<<<< HEAD
=======
		
		String name=request.getParameter("name");
		Club club = daoClub.get(name);
		
		System.out.println(club.getId());
		System.out.println(club.getName());
		System.out.println(club.getDescription());
		System.out.println(club.getParagraphe());
		
>>>>>>> ffd4dc4d9f00ed13a0863bf0c76ebfeea08cd1ab
	}

}
