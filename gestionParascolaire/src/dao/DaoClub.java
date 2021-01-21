package dao;

import beans.Club;

public interface DaoClub {
	Club get(int id);
	int add(String name , String descrption , String paragraphe);
	void update();
	void delete(int id);

}
