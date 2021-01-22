package servlets;


import dao.DaoActiviteImpl;


public class Te {

	public static void main(String[] args) {
		DaoActiviteImpl d=new DaoActiviteImpl();
		d.delete(3);
	}

}
