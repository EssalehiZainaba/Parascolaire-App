package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import entities.utilisateur;

public class DaoUtilisateurImpl implements DaoUtilisateur {

    private EntityManagerFactory factory;

    public DaoUtilisateurImpl(EntityManagerFactory factory) {
	
	   this.factory = factory;
    }
    
    @Override
    public void add(utilisateur utilisateur) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(utilisateur);
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
	public utilisateur get(int id) {
		EntityManager entityManager = factory.createEntityManager();
		utilisateur utilisateur = new utilisateur();
		entityManager.getTransaction().begin();
		try {
			utilisateur = entityManager.find(utilisateur.class, id );
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
		
		return utilisateur;
	}

	@Override
	public void delete(int id) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			utilisateur utilisateur = entityManager.find(utilisateur.class, id );
			entityManager.remove(utilisateur);
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
