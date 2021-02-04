package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import beans.User;
import models.HibernateUtil;
import models.UserPersisterImplementation;
import models.UserPersister;
import services.AccountsList;
import services.SignUpForm;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private UserPersister userPersister;
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	this.userPersister = new UserPersisterImplementation(sessionFactory);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountsList accountsList = new AccountsList(userPersister);
		request.setAttribute("list", accountsList);
		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SignUpForm form = new SignUpForm(userPersister);
		User user = form.userSignUp(request);
		
		AccountsList accountsList = new AccountsList(userPersister);

		HttpSession session = request.getSession();
		if(user!=null) {
			session.setAttribute("user", user);
			request.setAttribute("list", accountsList);
			response.sendRedirect(request.getContextPath()+"/SignUp");
		}
		else {
			request.setAttribute("user", user);
			request.setAttribute("form", form);
			request.setAttribute("list", accountsList);
			this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
		}
	}

}
