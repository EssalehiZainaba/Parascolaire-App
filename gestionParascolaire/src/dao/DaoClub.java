package dao;

import entities.Club;

public interface DaoClub {
	
	void add(Club club);
	Club find(int id);
	void update();
	void delete(int id);

}
