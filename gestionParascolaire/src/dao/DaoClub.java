package dao;

import entities.Club;

public interface DaoClub {
	Club get(int id);
	void add(Club club);
	void update();
	void delete(int id);

}
