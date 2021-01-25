package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoClub;
import dao.DaoClubImpl;
import dao.DaoEtudiant;
import dao.DaoEtudiantImpl;
import dao.DaoResponsableClub;
import dao.DaoResponsableClubImpl;
import dao.JPAUtil;
import entities.Club;
import entities.Etudiant;
import entities.ResponsableClub;

/**
 * Servlet implementation class PresentationServlet
 */
@WebServlet("/PresentationServlet")
public class PresentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PresentationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/presentation.jsp").forward(request, response);
		
		Etudiant etd = new Etudiant("etd@login.test", "etdpwd");
		DaoEtudiant daoEtd = new DaoEtudiantImpl(JPAUtil.getEntityManagerFactory());
		daoEtd.add(etd);;

		ResponsableClub resp = new ResponsableClub();
		resp.setLogin("resp@club.test");
		resp.setPassword("password");
		DaoResponsableClub daoResp= new DaoResponsableClubImpl(JPAUtil.getEntityManagerFactory());
		daoResp.add(resp);
		ResponsableClub respFind = daoResp.find(2);
		System.out.println("id_resp = "+respFind.getId()+" / login = "+respFind.getLogin()+" / pwd = "+respFind.getPassword());
		
		
		Club club = new Club();
		club.setName("social");
		club.setDescription("amine harka's favourite");
		club.setParagraphe("randomrandomrandom");
		club.setResponsableClub(respFind);  //the second time you test this it will give an error unless you clear the database or change the code (because it will try to map the same responsable for two clubs)
		DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());
		daoClub.add(club);
		
		Club clubFind = daoClub.find(1);
		System.out.println("id_club = "+clubFind.getId()+" / id_resp = "+clubFind.getResponsableClub().getId());
		
		ResponsableClub respFind2 = daoResp.find(2);
		System.out.println("id_resp = "+respFind2.getId()+" / club_name = "+respFind2.getClub().getName());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
