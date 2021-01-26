package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import dao.DaoResponsableClub;
import dao.DaoResponsableClubImpl;
import dao.JPAUtil;
import entities.ResponsableClub;

/**
 * Servlet implementation class respoClub
 */
@WebServlet("/respoClub")
public class respoClub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	public String Login(String club)
	{
		return club+"@uiz.ac.ma";
	}
	
	public String password()
	{
	String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
	String password = RandomStringUtils.random( 15, characters );
	return password;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterRespo.jsp").forward(request,response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String club = request.getParameter("club");
		
	
		
		ResponsableClub resp = new ResponsableClub(Login(club),password());
		DaoResponsableClub daoResp = new DaoResponsableClubImpl(JPAUtil.getEntityManagerFactory());
		daoResp.add(resp);
		
		
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterRespo.jsp").forward(request,response);

		
	}

}



