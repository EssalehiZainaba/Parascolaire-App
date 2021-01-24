package dao;

import entities.Activite;

public interface DaoActivite {
	
	void add(Activite activite);
	Activite find(int id);
	void delete(int id);
	

}
