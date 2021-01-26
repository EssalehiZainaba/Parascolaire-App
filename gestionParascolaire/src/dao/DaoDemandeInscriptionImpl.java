package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.AppartenanceKey;
import entities.DemandeInscription;

public class DaoDemandeInscriptionImpl implements DaoDemandeInscription{

	
	private EntityManagerFactory factory;
	
	public DaoDemandeInscriptionImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	@Override
	public void add(DemandeInscription demande) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.merge(demande);
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
	public DemandeInscription find(AppartenanceKey key) {
		DemandeInscription demande = null;
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			demande = em.find(DemandeInscription.class, key);
			em.getTransaction().commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		return demande;
	}

}
