package dao;

import entities.AppartenanceKey;
import entities.Club;
import entities.DemandeInscription;
import entities.Etudiant;

public interface DaoDemandeInscription {

	void add(DemandeInscription demande);
	void delete(Etudiant etudiant,Club club);
	DemandeInscription find(AppartenanceKey key);
	
}
