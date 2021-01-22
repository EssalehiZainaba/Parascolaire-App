package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.Activite;

public class DaoActiviteImpl implements DaoActivite{
	
	private EntityManagerFactory factory;
	
	public DaoActiviteImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public void add(Activite activite) {
		EntityManager entityManager = factory.createEntityManager();
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
		}
		
		
	}

	@Override
	public Activite get(int id) {
		EntityManager entityManager = factory.createEntityManager();
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
		}
		
		return activite;
	}

	@Override
	public void delete(int id) {
		EntityManager entityManager = factory.createEntityManager();
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
		}
		
	}

}
