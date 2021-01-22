package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import beans.Activite;

public class DaoActiviteImpl implements DaoActivite{

	@Override
	public void add(Activite activite) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UsersDB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(activite);
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

	@Override
	public Activite get(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UsersDB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Activite activite = new Activite();
		entityManager.getTransaction().begin();
		try {
			activite = entityManager.find(Activite.class, id );
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
		
		return activite;
	}

	@Override
	public void delete(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UsersDB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			Activite activite = entityManager.find(Activite.class, id );
			entityManager.remove(activite);
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

}
