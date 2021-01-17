package models;

import java.util.List;

import beans.User;

public interface UserPersister {

	   public void insertUser(User user);
	   public void updateUser(User user);
	   public User findUser(String email);
	   public List<User> listUsers();
}
