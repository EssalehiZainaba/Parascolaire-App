package dao;

import java.util.List;

import entities.AppartenanceKey;
import entities.Club;
import entities.DemandeInscription;
import entities.Etudiant;

public interface DaoDemandeInscription {

	void add(DemandeInscription demande);
	void delete(Etudiant etudiant,Club club);
	List<DemandeInscription> lister(Club club);
	DemandeInscription find(Club club ,Etudiant etudiant);

	
}
