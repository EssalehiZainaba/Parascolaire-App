package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import entities.Club;

public class DaoClubImpl implements DaoClub{
	
	private EntityManagerFactory factory;
	
	public DaoClubImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	public Club find(int id)
	{
		EntityManager entityManager = factory.createEntityManager();
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
		}
		return club;
	}
	
	public void add(Club club)
	{
		EntityManager entityManager = factory.createEntityManager();
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
		}
		
		
	}
	
	public void update()
	{
		
	}
	
	public void delete(int id)
	{
		EntityManager entityManager = factory.createEntityManager();
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
		}
		
		
		
	}

}
