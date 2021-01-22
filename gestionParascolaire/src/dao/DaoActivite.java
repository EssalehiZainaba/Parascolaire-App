package dao;

import beans.Activite;

public interface DaoActivite {
	
	void add(Activite activite);
	Activite get(int id);
	void delete(int id);
	

}
