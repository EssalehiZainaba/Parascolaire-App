package services;

import dao.DaoAppartenance;
import dao.DaoClub;
import dao.DaoDemandeInscription;
import entities.Club;
import entities.Etudiant;

public class ShowPresentation {
	
	DaoClub daoClub;
	DaoDemandeInscription daoDemandeInscription;
	DaoAppartenance daoAppartenance;
	
	public ShowPresentation(DaoClub daoClub, DaoDemandeInscription daoDemandeInscription, DaoAppartenance daoAppartenance) {
		this.daoClub = daoClub;
		this.daoDemandeInscription = daoDemandeInscription;
		this.daoAppartenance = daoAppartenance;
	}
	
	public Boolean showBouton(Club club, Etudiant etudiant) {
		if(daoAppartenance.find(club, etudiant) == null)
			if(daoDemandeInscription.find(club, etudiant) == null)
				return true;
		return false;
	}

}
