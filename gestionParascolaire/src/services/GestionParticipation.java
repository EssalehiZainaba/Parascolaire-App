package services;

import javax.servlet.http.HttpServletRequest;

import dao.DaoActivite;
import dao.DaoEtudiant;
import entities.Activite;
import entities.Etudiant;

public class GestionParticipation {

	DaoActivite daoActivite;
	DaoEtudiant daoEtudiant;
	Etudiant etd;
	
	public GestionParticipation(DaoActivite daoActivite, DaoEtudiant daoEtudiant, Etudiant etd) {
		this.daoActivite = daoActivite;
		this.daoEtudiant = daoEtudiant;
		this.etd = etd;
	}
	
	public void gererParticipation(HttpServletRequest request) {
		int idActivite;
		if(request.getParameter("id-activite-add")!=null) {
			idActivite = Integer.parseInt(request.getParameter("id-activite-add"));
			Activite activite = daoActivite.find(idActivite);
			daoEtudiant.participer(etd, activite);
		}
		if(request.getParameter("id-activite-remove")!=null) {
			idActivite = Integer.parseInt(request.getParameter("id-activite-remove"));
			etd.removeActivite(daoActivite.find(idActivite));
			Activite activite = daoActivite.find(idActivite);
			daoEtudiant.nePlusParticiper(etd, activite);
		}

			
	}
}
