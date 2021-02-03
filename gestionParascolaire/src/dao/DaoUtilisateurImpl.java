package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Utilisateur;

public class DaoUtilisateurImpl implements DaoUtilisateur {

    private EntityManagerFactory factory;

    public DaoUtilisateurImpl(EntityManagerFactory factory) {
    	this.factory = factory;
    }
    
    
    
    @Override
    public void add(Utilisateur utilisateur) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(utilisateur);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

    
    
	@Override
	public Utilisateur find(int id) {
		Utilisateur utilisateur = null;
		EntityManager em = factory.createEntityManager();
		try {
			utilisateur = em.find(Utilisateur.class, id );
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return utilisateur;
	}

	
	
	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			Utilisateur utilisateur = em.find(Utilisateur.class, id);
			em.remove(utilisateur);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	
	
}
