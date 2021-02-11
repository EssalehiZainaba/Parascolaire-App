package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	public void gererParticipation(HttpSession session, HttpServletRequest request) {
		int idActivite;
		if(request.getParameter("id-activite-add")!=null) {
			idActivite = Integer.parseInt(request.getParameter("id-activite-add"));
			Activite activite = daoActivite.find(idActivite);
			etd = daoEtudiant.participer(etd, activite);
			session.setAttribute("etudiant", etd);
		}
		if(request.getParameter("id-activite-remove")!=null) {
			idActivite = Integer.parseInt(request.getParameter("id-activite-remove"));
			Activite activite = daoActivite.find(idActivite);
			etd = daoEtudiant.nePlusParticiper(etd, activite);
			session.setAttribute("etudiant", etd);
		}

			
	}
}
