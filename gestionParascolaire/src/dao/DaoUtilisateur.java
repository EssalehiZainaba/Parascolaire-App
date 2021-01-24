package dao;

import entities.Utilisateur;

public interface DaoUtilisateur {
	
	void add(Utilisateur utilisateur);
	Utilisateur find(int id);
	void delete(int id);

}
