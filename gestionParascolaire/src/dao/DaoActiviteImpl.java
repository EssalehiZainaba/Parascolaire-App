package dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Activite;
import entities.Etudiant;

public class DaoActiviteImpl implements DaoActivite{
	
	private EntityManagerFactory factory;
	private SimpleDateFormat sdf;
	
	public DaoActiviteImpl(EntityManagerFactory factory) {
		this.factory = factory;
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
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
			activite.clearEtudiants();
			em.remove(activite);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	@Override
	public void update(Activite activite) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(activite);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}



	@Override
	public List<Activite> lister() {
		EntityManager em = factory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Activite> activites = em.createQuery("SELECT a FROM Activite a").getResultList();
		em.close();
		return activites;
	}
	
	@Override
	public List<Activite> liste(String ClubName) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Activite a WHERE a.club.name=:clubName ORDER BY STR_TO_DATE(a.date, '%d/%m/%Y') DESC");
		query.setParameter("clubName", ClubName);
		@SuppressWarnings("unchecked")
		List<Activite> activites = query.getResultList();
		em.close();
		return activites;
	}
	
	
	@Override
	public List<Activite> listerToutPublique() {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Activite a WHERE a.privee=false AND STR_TO_DATE(a.date, '%d/%m/%Y') >= STR_TO_DATE(:todayDate, '%d/%m/%Y') ORDER BY STR_TO_DATE(a.date, '%d/%m/%Y')");
		query.setParameter("todayDate", sdf.format(Calendar.getInstance().getTime()));
		@SuppressWarnings("unchecked")
		List<Activite> activites = query.getResultList();
		em.close();
		return activites;
	}
	
	
	
	@Override
	public List<Activite> listerTousMesClubs(boolean privee, Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Activite a WHERE a.privee=:privee AND a.club IN (SELECT a.club FROM Appartenance AS a WHERE a.etudiant = :etd) AND STR_TO_DATE(a.date, '%d/%m/%Y') >= STR_TO_DATE(:todayDate, '%d/%m/%Y') ORDER BY STR_TO_DATE(a.date, '%d/%m/%Y')");
		query.setParameter("privee", privee);
		query.setParameter("etd", etd);
		query.setParameter("todayDate", sdf.format(Calendar.getInstance().getTime()));
		@SuppressWarnings("unchecked")
		List<Activite> activites = query.getResultList();
		em.close();
		return activites;
	}



	@Override
	public List<Activite> listerTousAutresClubs(Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Activite a WHERE a.privee=false AND a.club IN (SELECT c FROM Club c WHERE c NOT IN (SELECT a.club FROM Appartenance AS a WHERE a.etudiant = :etd)) AND STR_TO_DATE(a.date, '%d/%m/%Y') >= STR_TO_DATE(:todayDate, '%d/%m/%Y') ORDER BY STR_TO_DATE(a.date, '%d/%m/%Y')");
		query.setParameter("etd", etd);
		query.setParameter("todayDate", sdf.format(Calendar.getInstance().getTime()));
		@SuppressWarnings("unchecked")
		List<Activite> activites = query.getResultList();
		em.close();
		return activites;
	}



	@Override
	public List<Activite> listerPublique(String clubName) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Activite a WHERE a.club.name=:clubName AND a.privee=false AND STR_TO_DATE(a.date, '%d/%m/%Y') >= STR_TO_DATE(:todayDate, '%d/%m/%Y') ORDER BY STR_TO_DATE(a.date, '%d/%m/%Y')");
		query.setParameter("clubName", clubName);
		query.setParameter("todayDate", sdf.format(Calendar.getInstance().getTime()));
		@SuppressWarnings("unchecked")
		List<Activite> activites = query.getResultList();
		em.close();
		return activites;
	}



	@Override
	public List<Activite> listerPrivee(String clubName, Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		Query quer = em.createQuery("SELECT a.club FROM Appartenance AS a WHERE a.etudiant=:etd AND a.club.name=:clubName");
		quer.setParameter("etd", etd);
		quer.setParameter("clubName", clubName);
		@SuppressWarnings("unchecked")
		List<Activite> club = quer.getResultList();
		
		if (!club.isEmpty()) {
			Query query = em.createQuery("SELECT a FROM Activite a WHERE a.club.name=:clubName AND a.privee=true AND STR_TO_DATE(a.date, '%d/%m/%Y') >= STR_TO_DATE(:todayDate, '%d/%m/%Y') ORDER BY STR_TO_DATE(a.date, '%d/%m/%Y')");
			query.setParameter("clubName", clubName);
			query.setParameter("todayDate", sdf.format(Calendar.getInstance().getTime()));
			@SuppressWarnings("unchecked")
			List<Activite> activites = query.getResultList();
			em.close();
			return activites;
		}
		em.close();
		return null;
	}



	@Override
	public List<Activite> listerActivite(int idClub, String year) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Activite a WHERE SUBSTRING(a.date, 7, 10)=:year AND a.club.id= :idClub");
		query.setParameter("year", year);
		query.setParameter("idClub", idClub);
		@SuppressWarnings("unchecked")
		List<Activite> activite = query.getResultList();
		em.close();
		return activite;
	}


	
	
}
