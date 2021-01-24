package servlets;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DaoUtilisateurImpl;
import entities.Utilisateur;


public class Te {

	public static void main(String[] args) {
		
	
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setLogin("123");
		utilisateur.setPassword("aaa");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestionParascolaire");
		DaoUtilisateurImpl d=new DaoUtilisateurImpl(factory);
		d.delete(1);
		
		
	}

}
