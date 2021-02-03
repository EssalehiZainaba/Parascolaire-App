package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Administrateur;

public class DaoAdministrateurImpl implements DaoAdministrateur{
	
	private EntityManagerFactory factory;
	
	public DaoAdministrateurImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public Administrateur find(int id) {
		Administrateur admin = null;
		EntityManager em = factory.createEntityManager();
		try {
			admin = em.find(Administrateur.class, id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return admin;
	}
	
	
	
}
