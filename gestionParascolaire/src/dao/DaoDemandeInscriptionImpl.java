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
	public List<DemandeInscription> find(Club club , Etudiant etudiant) {
		List<DemandeInscription> demande = new ArrayList<DemandeInscription>();
		EntityManager em = factory.createEntityManager();
		try {
			Query query = em.createQuery("SELECT d from DemandeInscription d WHERE d.club==club AND d.etudiant==etudiant");
			demande = (List<DemandeInscription>) query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return demande;
	}

	
	
}
