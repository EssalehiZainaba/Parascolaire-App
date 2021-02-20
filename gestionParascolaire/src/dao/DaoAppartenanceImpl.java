package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import entities.Appartenance;
import entities.Club;
import entities.Etudiant;

public class DaoAppartenanceImpl implements DaoAppartenance{
	
	private EntityManagerFactory factory;
	
	public DaoAppartenanceImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public Appartenance find(Club club, Etudiant etudiant) {
		Appartenance appartenance;
		EntityManager em = factory.createEntityManager();
		try {
			Query query = em.createQuery("SELECT a from Appartenance a WHERE a.club=:club AND a.etudiant=:etudiant");
			query.setParameter("club", club);
			query.setParameter("etudiant", etudiant);
			appartenance = (Appartenance)query.getSingleResult();
		} catch(NoResultException e) {
			appartenance = null;
		} finally {
			em.close();
		}
		return appartenance;
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



	@Override
	public List<Club> listerMesClubs(Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a.club FROM Appartenance AS a WHERE a.etudiant = :etd");
		query.setParameter("etd", etd);
		@SuppressWarnings("unchecked")
		List<Club> mesClubs = query.getResultList();
		em.close();
		return mesClubs;
	}
	
	
	
	@Override
	public List<Club> listerAutresClubs(Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Club c WHERE c NOT IN (SELECT a.club FROM Appartenance AS a WHERE a.etudiant = :etd)");
		query.setParameter("etd", etd);
		@SuppressWarnings("unchecked")
		List<Club> mesClubs = query.getResultList();
		em.close();
		return mesClubs;
	}



	@Override
	public List<Appartenance> listerAppartenances(String year, int idClub) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Appartenance a WHERE SUBSTRING(a.dateAppartenance, 7, 10)=:year AND a.club.id= :idClub");
		query.setParameter("year", year);
		query.setParameter("idClub", idClub);
		@SuppressWarnings("unchecked")
		List<Appartenance> appartenance = query.getResultList();
		em.close();
		return appartenance;
	}
	
	@Override
	public List<Appartenance> listerAppartenancesClub( int idClub) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Appartenance a WHERE a.club.id= :idClub");
		query.setParameter("idClub", idClub);
		@SuppressWarnings("unchecked")
		List<Appartenance> appartenance = query.getResultList();
		em.close();
		return appartenance;
	}


//not finished !

	/*public String minDateAppartenance(int idClub) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Appartenance a WHERE SUBSTRING(a.dateAppartenance, 1, 4)< AND a.club.id= :idClub");
		query.setParameter("idClub", idClub);
		@SuppressWarnings("unchecked")
		List<Appartenance> appartenance = query.getResultList();
		em.close();
		return null;
	}*/



}
