package services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DaoEtudiant;
import entities.Etudiant;


public class UpdateProfilForm {

	Map<String,String> errors = new HashMap<String,String>();
	String result;
	DaoEtudiant daoEtudiant;
	
	
	public UpdateProfilForm(DaoEtudiant daoEtudiant) {
		this.daoEtudiant = daoEtudiant;
	}
	
	
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public String getResult() {
		return result;
	}

	

	public Etudiant updateProfil(HttpSession session, HttpServletRequest request, Etudiant etd) {
		
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String cne = request.getParameter("cne");
		String filiere = request.getParameter("filiere");
		String pays = request.getParameter("pays");
		String ville = request.getParameter("ville");
				
		validateNotEmpty(prenom, "prenom");
		validateNotEmpty(nom, "nom");
		validateNotEmpty(cne, "cne");
		validateNotEmpty(filiere, "filiere");
		validateNotEmpty(pays, "pays");
		validateNotEmpty(ville, "ville");

		
		if(errors.isEmpty()) {
			etd.setPrenom(prenom);
			etd.setNom(nom);
			etd.setCne(cne);
			etd.setFiliere(filiere);
			etd.setPays(pays);
			etd.setVille(ville);
			
			etd = daoEtudiant.update(etd);
			session.setAttribute("etudiant", etd);
			
		} 
		else {
			result = "Veuiller remplir tous les champs.";
			request.setAttribute("form", this);
		}
		
		
		return etd;
	}
	
	
	
	//----------------------Méthodes de Validation :----------------------
	//Validation de non-vide :
	private void validateNotEmpty(String str, String errKey) {
		tryEmpty(str, errKey);
	}
	
	
	//----------------------Méthodes de Try and Catch :----------------------
	//Try and Catching de non-vide :
	private void tryEmpty(String str, String errKey) {
		try {
			checkEmpty(str);
		} catch(UpdateProfilFormException e) {
			errors.put(errKey, e.getMessage());
		}
	}
	
	
	//----------------------Méthodes de Checking :----------------------
	//Checking de non-vide:
	private void checkEmpty(String str) throws UpdateProfilFormException{
		if(str.isEmpty())
			throw new UpdateProfilFormException("Ce champ ne doit pas être vide.");
	}
}
