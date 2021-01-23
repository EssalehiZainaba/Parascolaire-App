package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.responsableClub;

public class DaoResponsableClubImpl implements DaoResponsableClub{

	private EntityManagerFactory factory;

	public DaoResponsableClubImpl(EntityManagerFactory factory) {
		super();
		factory = this.factory;
	}

	@Override
	public void add(responsableClub responsableClub) {
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
	public responsableClub get(int id) {
		EntityManager entityManager = factory.createEntityManager();
		responsableClub responsableClub = new responsableClub();
		entityManager.getTransaction().begin();
		try {
			responsableClub = entityManager.find(responsableClub.class, id );
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
			responsableClub responsableClub = entityManager.find(responsableClub.class, id );
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
