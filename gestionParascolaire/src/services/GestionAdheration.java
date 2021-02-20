package services;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import dao.DaoClub;
import dao.DaoDemandeInscription;
import dao.DaoEtudiant;
import entities.Club;
import entities.DemandeInscription;
import entities.Etudiant;

public class GestionAdheration {

	DaoDemandeInscription daoDemandeInscription;
	DaoClub daoClub;
	DaoEtudiant daoEtudiant;
	
	public GestionAdheration(DaoDemandeInscription daoDemandeInscription, DaoClub daoClub, DaoEtudiant daoEtudiant) {
		this.daoDemandeInscription = daoDemandeInscription;
		this.daoClub = daoClub;
		this.daoEtudiant = daoEtudiant;
	}
	
	public void Adherer(HttpSession session, String clubName) {
		
		Etudiant etudiant = (Etudiant) session.getAttribute("etudiant");
		Club club = daoClub.find(clubName);
		
		Date date = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate = formatter.format(date);
		
		
		DemandeInscription demandeInscription = new DemandeInscription(etudiant, club, strDate);
		daoDemandeInscription.add(demandeInscription);
		
		etudiant = daoEtudiant.find(etudiant.getId());
		session.setAttribute("etudiant", etudiant);
	}
}
