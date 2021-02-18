package dao;

import java.util.List;

import entities.Club;

public interface DaoClub {
	
	void add(Club club);
	Club find(int id);
	Club find(String name);
	void update(Club club);
	void delete(int id);
	List<Club> lister();

}
