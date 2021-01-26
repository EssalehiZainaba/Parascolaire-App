package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.Activite;
import entities.Etudiant;

public class DaoParticipationImpl implements DaoParticipation{
	
	private EntityManagerFactory factory;
	
	public DaoParticipationImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public void participer(Etudiant etudiant, Activite activite) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			etudiant.addActivites(activite);
			entityManager.merge(etudiant);
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
