package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoEtudiant;
import dao.DaoEtudiantImpl;
import dao.JPAUtil;
import entities.Etudiant;
import services.UpdateProfilForm;

/**
 * Servlet implementation class UpdateProfil
 */
@WebServlet("/UpdateProfil")
public class UpdateProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoEtudiant daoEtudiant;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfil() {
    	daoEtudiant = new DaoEtudiantImpl(JPAUtil.getEntityManagerFactory());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//NORMALLY THERE IS ALWAYS AN ETUDIANT IN SESSION
		//THIS CODE IS JUST FOR TESTING PURPOSES
		Etudiant etd = new Etudiant("login@etd.test", "etdpwd");
		etd.setCne("D876245414");
		etd.setNom("Essalhi");
		etd.setPrenom("Zendaya");
		etd.setFiliere("Génie Acting");
		etd.setAdresse("Somewhere");
		etd.setPays("Ait Iyaza");
		etd.setVille("Morocco");
		
		daoEtudiant.add(etd);
		etd = daoEtudiant.find(1);		
		HttpSession session = request.getSession();
		
		session.setAttribute("etd", etd);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Etudiant/profil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id = ((Etudiant)session.getAttribute("etd")).getId();
		
		UpdateProfilForm form = new UpdateProfilForm(daoEtudiant);
		Etudiant etd = form.updateProfil(request, id);
		
		if(etd!=null)
			session.setAttribute("etd", etd);
		else
			request.setAttribute("form", form);

		this.getServletContext().getRequestDispatcher("/WEB-INF/Etudiant/profil.jsp").forward(request, response);


	}

}
