package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import beans.Club;

public class DaoClubImpl implements DaoClub{
	
	public Club get(int id)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("UsersDB");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Club club=new Club();
		try {
			club = entityManager.find(Club.class,id);
			entityManager.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return club;
	}
	
	public int add(String name , String description , String paragraphe)
	{
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
	    Transaction tx = null;
	    Integer clubID = null;
	      
	    try {
	    	
	         tx = session.beginTransaction();
	         Club club = new Club(name, description, paragraphe);
	         clubID = (Integer) session.save(club); 
	         tx.commit();
	    } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	    } finally {
	         session.close(); 
	    }
	      return clubID;
	}
	
	public void update()
	{
		
	}
	
	public void delete(int id)
	{
		
	}

}
