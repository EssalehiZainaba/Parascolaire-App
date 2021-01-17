package dao;

import beans.Club;

public interface DaoClub {
	Club get(String name);
	int add(String name , String descrption , String paragraphe);
	void update();
	void delete(int id);

}
