package servlets;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DaoUtilisateurImpl;
import entities.utilisateur;


public class Te {

	public static void main(String[] args) {
		
	
		utilisateur utilisateur = new utilisateur();
		utilisateur.setLogin("123");
		utilisateur.setPassword("aaa");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestionParascolaire");
		DaoUtilisateurImpl d=new DaoUtilisateurImpl(factory);
		d.delete(1);
		
		
	}

}
