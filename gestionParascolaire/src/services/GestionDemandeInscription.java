package services;

import java.util.Date;

import dao.DaoAppartenance;
import dao.DaoClub;
import dao.DaoDemandeInscription;
import dao.DaoEtudiant;
import entities.Appartenance;
import entities.Club;
import entities.Etudiant;
import entities.ResponsableClub;

public class GestionDemandeInscription {
	private DaoClub daoClub;
	private DaoEtudiant daoEtudiant;
	private DaoDemandeInscription daoDemandeInscription;
	
	public GestionDemandeInscription(DaoClub daoClub , DaoEtudiant daoEtudiant,DaoDemandeInscription daoDemandeInscription) {
		super();
		this.daoClub = daoClub;
		this.daoEtudiant = daoEtudiant;
		this.daoDemandeInscription=daoDemandeInscription;
	}
	
	public void confirmerDemande(int idEtudiant , ResponsableClub responsableClub , DaoAppartenance daoAppartenance) {
		Club club =daoClub.find(responsableClub.getClub().getId());
		Etudiant etudiant=daoEtudiant.find(idEtudiant);
		Appartenance appartenance=new Appartenance(etudiant, club,new Date());
		daoAppartenance.add(appartenance);
		daoDemandeInscription.delete(etudiant, club);
	}
	
	public void supprimerDemande(int idEtudiant , ResponsableClub responsableClub ) {
		Etudiant etudiant=daoEtudiant.find(idEtudiant);
		Club club=daoClub.find(responsableClub.getClub().getId());
		daoDemandeInscription.delete(etudiant, club);
	}
}
