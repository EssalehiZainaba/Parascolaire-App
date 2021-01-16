package services;

import java.util.ArrayList;

import beans.User;
import models.UserPersister;

public class AccountsList {
	String result;
	ArrayList<User> users;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	
	public AccountsList(UserPersister testHiber) {
		ArrayList<User> users = null;
		users = (ArrayList<User>) testHiber.listUsers();
		result = "Utilisateurs déjà inscrits :";

		this.users = users;
	}
	
	

}
