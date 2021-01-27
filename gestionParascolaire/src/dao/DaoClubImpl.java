package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Club;

public class DaoClubImpl implements DaoClub{
	
	private EntityManagerFactory factory;
	
	public DaoClubImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public void add(Club club) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(club);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	
	
	@Override
	public Club find(int id) {
		Club club = null;
		EntityManager em = factory.createEntityManager();
		try {
			club = em.find(Club.class,id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return club;
	}
	
	
	
	@Override
	public void update() {
		
	}
	
	
	
	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Club club = em.find(Club.class,id);
			em.remove(club);
			tx.commit();
		} catch( Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}	
	}

	
	
}
