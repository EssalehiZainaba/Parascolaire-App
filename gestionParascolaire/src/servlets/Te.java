package servlets;

import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import beans.Activite;
import beans.Club;
import dao.DaoActiviteImpl;
import dao.DaoClubImpl;

public class Te {

	public static void main(String[] args) {
		DaoActiviteImpl d=new DaoActiviteImpl();
		d.delete(3);
	}

}
