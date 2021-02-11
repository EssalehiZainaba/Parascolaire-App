package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import entities.Activite;
import entities.Club;
import entities.Etudiant;

public class DaoEtudiantImpl implements DaoEtudiant{
	
	private EntityManagerFactory factory;
	
	public DaoEtudiantImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public void add(Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(etd);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	
	
	@Override
	public Etudiant find(int id) {
		Etudiant etd = null;
		EntityManager em = factory.createEntityManager();
		try {
			etd = em.find(Etudiant.class, id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return etd;
	}
	
	
	
	@Override
	public Etudiant update(Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			etd = em.merge(etd);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		return etd;
	}



	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			Etudiant etudiant = em.find(Etudiant.class, id);
			em.remove(etudiant);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	
	
	@Override
	public Etudiant participer(Etudiant etudiant, Activite activite) {
		EntityManager em = factory.createEntityManager();
		
		//CHECK IF THE ETUDIANT CAN PARTICIPATE IN THE ACTIVITY
		if(activite.isPrivee()) {
			Club club = activite.getClub();
			Query query = em.createQuery("SELECT a FROM Appartenance a WHERE a.etudiant=:etd AND a.club=:club");
			query.setParameter("etd", etudiant);
			query.setParameter("club", club);
			try {
			query.getSingleResult();
			} catch(NoResultException e) {
				return etudiant;
			}
		}

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			etudiant.addActivite(activite);
			etudiant = em.merge(etudiant);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		
		return etudiant;
	}



	@Override
	public Etudiant nePlusParticiper(Etudiant etudiant, Activite activite) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			etudiant.removeActivite(activite);
			etudiant = em.merge(etudiant);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return etudiant;
	}
	

	
	

}
