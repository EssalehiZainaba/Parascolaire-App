package dao;

import entities.Activite;
import entities.Etudiant;

public interface DaoEtudiant {
	
	void add(Etudiant etd);
	Etudiant find(int id);
	void update(Etudiant etd);
	void delete(int id);
	void participer(Etudiant etudiant, Activite activite);
	void nePlusParticiper(Etudiant etudiant, Activite activite);
	
}
