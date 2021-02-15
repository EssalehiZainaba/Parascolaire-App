package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ContactUs
 */
@WebServlet("/ContactUs")
public class ContactUs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		 if(session.getAttribute("etudiant")!=null)
			 this.getServletContext().getRequestDispatcher( "/WEB-INF/Etudiant/ContactUs.jsp" ).forward( request, response );
		 else if(session.getAttribute("responsable")!=null)
			 this.getServletContext().getRequestDispatcher( "/WEB-INF/Responsable/ContactUs.jsp" ).forward( request, response );
		 else if(session.getAttribute("administrateur")!=null)
			 this.getServletContext().getRequestDispatcher( "/WEB-INF/Administrateur/ContactUs.jsp" ).forward( request, response );
		 else
			 this.getServletContext().getRequestDispatcher( "/WEB-INF/Public/ContactUs.jsp" ).forward( request, response );

	}



}
