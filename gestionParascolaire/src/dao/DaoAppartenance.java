package dao;

import entities.Appartenance;
import entities.AppartenanceKey;

public interface DaoAppartenance {
	void add(Appartenance appar);
	Appartenance find(AppartenanceKey id);
}
