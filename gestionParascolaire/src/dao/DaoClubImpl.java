package dao;

import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import beans.Club;

public class DaoClubImpl implements DaoClub{
	
	private SessionFactory factory;
	
	public DaoClubImpl (SessionFactory factory)
	{
		this.factory = factory;
	}
	
	public Club get(String name)
	{
		
		Session session = factory.openSession();
	    Transaction tx = null;
	    Club club=null;
	      
	      try {
	         tx = session.beginTransaction();
	         @SuppressWarnings("unchecked")
			 List<Club> clubs =(List<Club>) session.createQuery("FROM Club WHERE name='"+name+"'").list(); 
	         club=(Club)clubs.get(0);
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      
	      return club;
	}
	
	public int add(String name , String description , String paragraphe)
	{
		
		
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
