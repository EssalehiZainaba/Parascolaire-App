package dao;

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
			em.persist(demande);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	
	
	@Override
	public DemandeInscription find(AppartenanceKey key) {
		DemandeInscription demande = null;
		EntityManager em = factory.createEntityManager();
		try {
			demande = em.find(DemandeInscription.class, key);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return demande;
	}



	@Override
	public void delete(Etudiant etudiant, Club club) {
		EntityManager em=factory.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		try {
			tx.begin();
			Query query=em.createQuery("DELETE from DemandeInscription d WHERE d.etudiant=:etudiant AND d.club=:club");
			query.setParameter("etudiant", etudiant);
			query.setParameter("club", club);
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
		Query query=em.createQuery("SELECT d FROM DemandeInscription WHERE d.club=:club");
		query.setParameter("club", club);
		@SuppressWarnings("unchecked")
		List<DemandeInscription> demandeInscriptions=query.getResultList();
		em.close();
		return demandeInscriptions;
	}
	

	
	
}
