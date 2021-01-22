package dao;

import beans.Etudiant;

public interface DaoEtudiant {
	Etudiant find(int id);
	void update(Etudiant etd);
}
