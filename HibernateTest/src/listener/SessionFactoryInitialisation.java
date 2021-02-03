package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import models.HibernateUtil;


/**
 * Application Lifecycle Listener implementation class DAOFactoryInitialisation
 *
 */
@WebListener
public class SessionFactoryInitialisation implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SessionFactoryInitialisation() {
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
    	HibernateUtil.getSessionFactory();
         
    }
	
}
