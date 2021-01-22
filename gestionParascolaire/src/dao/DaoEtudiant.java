package dao;

import entities.Etudiant;

public interface DaoEtudiant {
	Etudiant find(int id);
	void update(Etudiant etd);
}
