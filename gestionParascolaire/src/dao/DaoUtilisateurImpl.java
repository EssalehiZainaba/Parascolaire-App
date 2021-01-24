package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import entities.Utilisateur;

public class DaoUtilisateurImpl implements DaoUtilisateur {

    private EntityManagerFactory factory;

    public DaoUtilisateurImpl(EntityManagerFactory factory) {
	
	   this.factory = factory;
    }
    
    @Override
    public void add(Utilisateur utilisateur) {
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
	public Utilisateur find(int id) {
		EntityManager entityManager = factory.createEntityManager();
		Utilisateur utilisateur = new Utilisateur();
		entityManager.getTransaction().begin();
		try {
			utilisateur = entityManager.find(Utilisateur.class, id );
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
			Utilisateur utilisateur = entityManager.find(Utilisateur.class, id );
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
