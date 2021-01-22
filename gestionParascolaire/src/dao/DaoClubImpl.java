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
	
	public void add(Club club)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UsersDB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(club);
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
		
		
	}
	
	public void update()
	{
		
	}
	
	public void delete(int id)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UsersDB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			Club club = entityManager.find(Club.class,id);
			entityManager.remove(club);
			entityManager.getTransaction().commit();
		}
		catch( Exception e)
		{
			
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		
		
	}

}
