package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.ResponsableClub;

public class DaoResponsableClubImpl implements DaoResponsableClub{

	private EntityManagerFactory factory;

	public DaoResponsableClubImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public void add(ResponsableClub responsableClub) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(responsableClub);
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
	public ResponsableClub find(int id) {
		EntityManager entityManager = factory.createEntityManager();
		ResponsableClub responsableClub = new ResponsableClub();
		entityManager.getTransaction().begin();
		try {
			responsableClub = entityManager.find(ResponsableClub.class, id );
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
		
		return responsableClub;
	}

	@Override
	public void delete(int id) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			ResponsableClub responsableClub = entityManager.find(ResponsableClub.class, id );
			entityManager.remove(responsableClub);
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
