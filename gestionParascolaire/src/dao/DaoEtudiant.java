package dao;

import entities.Activite;
import entities.Etudiant;

public interface DaoEtudiant {
	
	void add(Etudiant etd);
	Etudiant find(int id);
	Etudiant update(Etudiant etd);
	void delete(int id);
	Etudiant participer(Etudiant etudiant, Activite activite);
	Etudiant nePlusParticiper(Etudiant etudiant, Activite activite);
	
}
