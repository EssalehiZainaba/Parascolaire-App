package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NotreEcole
 */
@WebServlet("/NotreEcole")
public class NotreEcole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NotreEcole() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		 if(session.getAttribute("etudiant")!=null)
			 this.getServletContext().getRequestDispatcher( "/WEB-INF/Etudiant/NotreEcole.jsp" ).forward( request, response );
		 else if(session.getAttribute("responsable")!=null)
			 this.getServletContext().getRequestDispatcher( "/WEB-INF/Responsable/NotreEcole.jsp" ).forward( request, response );
		 else if(session.getAttribute("administrateur")!=null)
			 this.getServletContext().getRequestDispatcher( "/WEB-INF/Administrateur/NotreEcole.jsp" ).forward( request, response );
		 else
			 this.getServletContext().getRequestDispatcher( "/WEB-INF/Public/NotreEcole.jsp" ).forward( request, response );

	}


}
