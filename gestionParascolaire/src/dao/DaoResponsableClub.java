package dao;

import entities.responsableClub;

public interface DaoResponsableClub {

	void add(responsableClub responsableClub);
	responsableClub get(int id);
	void delete(int id);
	
}
