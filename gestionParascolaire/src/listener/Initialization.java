package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Application Lifecycle Listener implementation class Initialization
 *
 */
@WebListener
public class Initialization implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Initialization() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         
    	String chemin = "C:\\Users\\toshiba\\Desktop\\here\\GestionParascolaire\\gestionParascolaire\\WebContent\\images\\";
    	event.getServletContext().setAttribute("chemin",chemin);
    }
	
}
