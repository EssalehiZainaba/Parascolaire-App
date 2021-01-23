package dao;

import entities.utilisateur;

public interface DaoUtilisateur {
	
	void add(utilisateur utilisateur);
	utilisateur get(int id);
	void delete(int id);

}
