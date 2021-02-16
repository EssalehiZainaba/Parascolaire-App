package dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.AppartenanceKey;
import entities.Club;
import entities.DemandeInscription;
import entities.Etudiant;

public class DaoDemandeInscriptionImpl implements DaoDemandeInscription{

	private EntityManagerFactory factory;
	
	public DaoDemandeInscriptionImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public void add(DemandeInscription demande) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(demande);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	
	
	@Override
	public DemandeInscription find(Club club , Etudiant etudiant) {
		DemandeInscription demandeInscription=new DemandeInscription();
		EntityManager em = factory.createEntityManager();
		try {
			Query query = em.createQuery("SELECT d from DemandeInscription d WHERE d.club=:club AND d.etudiant=:etudiant");
			query.setParameter("club", club);
			query.setParameter("etudiant", etudiant);
			demandeInscription=(DemandeInscription)query.getSingleResult();
		} catch(Exception e) {
			demandeInscription=null;
		} finally {
			em.close();
		}
		return demandeInscription;
	}



	@Override
	public void delete(AppartenanceKey id) {
		EntityManager em=factory.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		try {
			tx.begin();
			DemandeInscription demandeInscription=em.find(DemandeInscription.class,id);
			System.out.println("club "+demandeInscription.getClub().getName()+"etudiant"+demandeInscription.getEtudiant().getNom());
			em.remove(demandeInscription);
			/*
			Query query=em.createQuery("DELETE from DemandeInscription d WHERE d.etudiant=:etudiant AND d.club=:club");
			query.setParameter("etudiant", etudiant);
			query.setParameter("club", club);
			*/
			System.out.println("execution of query");
			tx.commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}	
		finally {
			em.close();
		}
		
	}

	@Override
	public List<DemandeInscription> lister(Club club) {
		// TODO Auto-generated method stub
		EntityManager em=factory.createEntityManager();
		Query query=em.createQuery("SELECT d FROM DemandeInscription d WHERE d.club=:club");
		query.setParameter("club", club);
		@SuppressWarnings("unchecked")
		List<DemandeInscription> demandeInscriptions=query.getResultList();
		em.close();
		return demandeInscriptions;
	}
	

	
	
}
