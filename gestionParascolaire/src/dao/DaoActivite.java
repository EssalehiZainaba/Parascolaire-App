package dao;

import java.util.List;

import entities.Activite;
import entities.Etudiant;

public interface DaoActivite {
	
	void add(Activite activite);
	Activite find(int id);
	void delete(int id);
	List<Activite> lister();
	List<Activite> liste(String ClubName);
	List<Activite> listerToutPublique();
	List<Activite> listerTousMesClubs(boolean privee, Etudiant etd);
	List<Activite> listerTousAutresClubs(Etudiant etd);
	List<Activite> listerPublique(String clubName);
	List<Activite> listerPrivee(String clubName, Etudiant etd);
	
	
}
