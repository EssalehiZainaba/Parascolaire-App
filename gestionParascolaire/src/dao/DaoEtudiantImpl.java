package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Etudiant;

public class DaoEtudiantImpl implements DaoEtudiant{
	
	private EntityManagerFactory factory;
	
	public DaoEtudiantImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public Etudiant find(int id) {
		Etudiant etd = null;
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			etd = em.find(Etudiant.class, id);
			em.getTransaction().commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		return etd;
	}
	
	@Override
	public void update(Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(etd);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	@Override
	public void add(Etudiant etd) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(etd);
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
