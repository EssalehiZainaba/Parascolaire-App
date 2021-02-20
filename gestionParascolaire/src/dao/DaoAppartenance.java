package dao;

import java.util.List;

import entities.Appartenance;
import entities.Club;
import entities.Etudiant;

public interface DaoAppartenance {
	
	void add(Appartenance appar);
	Appartenance find(Club club, Etudiant etudiant);
	List<Club> listerMesClubs(Etudiant etd);
	List<Club> listerAutresClubs(Etudiant etd);
	List<Appartenance> listerAppartenances(String year, int idClub);
	List<Appartenance> listerAppartenancesClub( int idClub);
	//String minDateAppartenance( int idClub);
	
}
