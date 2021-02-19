package services;

import java.util.Calendar;
import java.util.List;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoAppartenance;
import dao.DaoAppartenanceImpl;
import dao.JPAUtil;
import entities.Activite;
import entities.Appartenance;

public class ChartsForm {

	

	DaoAppartenance daoappartenance = new DaoAppartenanceImpl(JPAUtil.getEntityManagerFactory());
	DaoActivite daoActivite = new DaoActiviteImpl(JPAUtil.getEntityManagerFactory());
	
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	
	int taille = currentYear-2016+1;
	
	public Integer[] Year()
    {
    	Integer tabYear[] = new Integer[taille];
    	
    	for(int i=0; i<taille; i++)
    	{   		
    	    tabYear[i] = 2016+i;
    	  
    	}
    	return tabYear;
    }
	
	
	
	public Integer[] tabEtd(int idClub)
    {
		List<Appartenance> app ;
    	Integer tabNumberEtd[] = new Integer[taille];
    	
    	for(int i=0; i<taille; i++)
    	{   		
    	    app = (List<Appartenance>) daoappartenance.listerAppartenances(String.valueOf(2016+i), idClub);
    	    tabNumberEtd[i] = app.size();

    	  
    	}
    	return tabNumberEtd;
    }
	
	
	
	
	public Integer[] tabAct(int idClub)
    {
	
		List<Activite> act ;
    	
		Integer tabNumberAct[] = new Integer[taille];
     	
     	for(int i=0; i<taille; i++)
     	{   		
     	    act = (List<Activite>) daoActivite.listerActivite(idClub, String.valueOf(2016+i));
     	    tabNumberAct[i] = act.size();    	  
     	}
     	return tabNumberAct;
    }
	
	
	
	
	
}
