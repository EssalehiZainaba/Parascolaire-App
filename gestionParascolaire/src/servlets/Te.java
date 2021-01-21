package servlets;

import beans.Club;
import dao.DaoClubImpl;

public class Te {

	public static void main(String[] args) {
		DaoClubImpl d=new DaoClubImpl();
		Club club=d.get(2);
		System.out.println(club.getName());
		System.out.println(club.getParagraphe());
	}

}
