package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Administrateur;

public class DaoAdministrateurImpl implements DaoAdministrateur{
	
	private EntityManagerFactory factory;
	
	public DaoAdministrateurImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	@Override
	public Administrateur find(int id) {
		Administrateur admin = null;
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			admin = em.find(Administrateur.class, id);
			em.getTransaction().commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		return admin;
	}
}
