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
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			appar = em.find(Appartenance.class, id);
			em.getTransaction().commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		return appar;
	}


	@Override
	public void add(Appartenance appar) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			/*AppartenanceKey apparKey = new AppartenanceKey();
			apparKey.setIdClub(appar.getClub().getId());
			apparKey.setIdEtudiant(appar.getEtd().getId());
			appar.setId(apparKey);*/
			entityManager.merge(appar);
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
