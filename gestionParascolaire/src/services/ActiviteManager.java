package services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;
import entities.Activite;

public class ActiviteManager {
	final static String CHAMP_NOM="nom";
	final static String CHAMP_DESCRIPTION="description";
	final static String CHAMP_DATE="date";
	final static String CHAMP_LIEU="lieu";
	final static String CHAMP_IMAGE="image";
	final static String CHAMP_PRIVEE="privee";
	
	
	private Map<String,String> erreurs = new HashMap<String,String>();
	private Activite activite;
	
	
	
	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}
	
	public Activite creerActivite(HttpServletRequest request , String chemin)
	{
		activite = null;
		Date date = null;
		Part image = null;
		try {
			image = request.getPart(CHAMP_IMAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String nom = request.getParameter(CHAMP_NOM);
		String description = request.getParameter(CHAMP_DESCRIPTION);
		String lieu = request.getParameter(CHAMP_LIEU);
		boolean privee = Boolean.parseBoolean(request.getParameter(CHAMP_PRIVEE));
		
		try {
			date=new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy").parse(request.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.textValidation(description);
		}
		catch(Exception e){
			erreurs.put(CHAMP_DESCRIPTION, e.getMessage());
		}
		
		try {
			this.textValidation(lieu);
		}
		catch(Exception e){
			erreurs.put(CHAMP_LIEU, e.getMessage());
		}
		
		try {
			this.textValidation(nom);
		}
		catch(Exception e){
			erreurs.put(CHAMP_NOM, e.getMessage());
		}
		
		try {
			this.imageValidation(image);
		}
		catch(Exception e){
			erreurs.put(CHAMP_IMAGE, e.getMessage());
		}
		
		try {
			this.dateValidation(date);
		}
		catch(Exception e){
			erreurs.put(CHAMP_DATE, e.getMessage());
		}
		
		try {
			this.booleanValidation(privee);
		}
		catch(Exception e){
			erreurs.put(CHAMP_PRIVEE, e.getMessage());
		}
		
		activite = new Activite();
		activite.setNom_activite(nom);
		activite.setDescription(description);
		activite.setLieu_activite(lieu);
		activite.setDate_activite(date);
		activite.setPrivee(privee);
		
		if(erreurs.isEmpty())
		{
			
			FilesManager filesManager = new FilesManagerImpl();
			DaoActivite daoActivite = new DaoActiviteImpl(JPAUtil.getEntityManagerFactory());
			
			activite.setImagePath(filesManager.ecrireFichier(image, chemin));
			
			daoActivite.add(activite);
			return activite;
			
			
		}
		
		
		
		
		
		return null;
		
		
		
	}	
	
	
	private void textValidation(String text) throws Exception
	{
		if(text.trim().length()==0 || text == null)
			throw new Exception("Merci de Remplir ce champ");
	}
	
	private void imageValidation(Part part) throws Exception
	{
		String type = part.getContentType();
		if(!type.contains("image"))
			throw new Exception("image required");
	}
	private void dateValidation(Date date) throws Exception
	{
		
		if(date == null)
			throw new Exception("merci de saisir la date");
	}
	
	private void booleanValidation(Boolean privee) throws Exception
	{
		
		if(privee == null)
			throw new Exception("merci de selectionner une option");
	}

}
