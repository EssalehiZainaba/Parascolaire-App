package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Appartenance;
import entities.AppartenanceKey;

public class DaoAppartenanceImpl implements DaoAppartenance{
	
	private EntityManagerFactory factory;
	
	public DaoAppartenanceImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public Appartenance find(AppartenanceKey id) {
		Appartenance appar = null;
		EntityManager em = factory.createEntityManager();
		try {
			appar = em.find(Appartenance.class, id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return appar;
	}

	

	@Override
	public void add(Appartenance appar) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(appar);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}


}
