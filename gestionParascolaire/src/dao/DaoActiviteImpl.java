package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Activite;

public class DaoActiviteImpl implements DaoActivite{
	
	private EntityManagerFactory factory;
	
	public DaoActiviteImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	
	
	@Override
	public void add(Activite activite) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(activite);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}	
	}
	
	
	
	@Override
	public Activite find(int id) {
		Activite activite = null;
		EntityManager em = factory.createEntityManager();
		try {
			activite = em.find(Activite.class, id );
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return activite;
	}

	
	
	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Activite activite = em.find(Activite.class, id );
			em.remove(activite);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	
	
}
