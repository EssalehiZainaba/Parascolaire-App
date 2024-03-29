package services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.HashMap;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import dao.DaoUtilisateur;
import entities.Utilisateur;

public class ConnexionForm {
	
	public HashMap<String,String> erreur = new HashMap<String, String>();
	 
	DaoUtilisateur daoUtilisateur;
	String userType;
	

	public HashMap<String, String> getErreur() {
	
		return erreur;
	
	}
	
	
	public String getUserType() {
		
		return userType;
	
	}



	public ConnexionForm(DaoUtilisateur daoUtilisateur) {
	
		this.daoUtilisateur = daoUtilisateur;
	
	}
	
	public Utilisateur validationEmail(String email) throws Exception{
	  Utilisateur utilisateur=null;
		
	  if(email.trim().length() == 0 ){
				
			throw new Exception( "Merci de saisir votre Email." );
	  }
	  else {
		 
		  try {
			  utilisateur=daoUtilisateur.find(daoUtilisateur.getIdByEmail(email));
		  } 
		  catch (NoResultException e) {
			  erreur.put("email", "Merci de saisir votre email correctement");
		  }
		
	  }
	  
	  return utilisateur;
	}
	
	 public String Hashing(String password)
	 {
		 String saltString = "thisIsSaltString";
		 byte[] salt = new byte[16];
		 salt = saltString.getBytes();	
		 String HashedPassword;
		 
		 KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
		 try {
		 SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		 byte[] hash = factory.generateSecret(spec).getEncoded();
		 HashedPassword = Base64.getEncoder().encodeToString(hash);
		 return HashedPassword;	
		 }
		 catch(NoSuchAlgorithmException e)
		 {
			 e.printStackTrace();
		 }
		 catch(InvalidKeySpecException e)
		 {
			 e.printStackTrace();
		 }
		 
		 return null; 
	 }
	
	public void validationPassword(String password,Utilisateur utilisateur) throws Exception{
		if(password.trim().length() == 0 ){
		
			throw new Exception( "Merci de saisir un mot de passe." );
		}
		else {
			if(!(Hashing(password).equals(utilisateur.getPassword()))){
				throw new Exception("Votre mot de passe n'est pas correcte");
			}
		}
	}
	
	
	public Utilisateur validationConnexion(String email,String password){
		Utilisateur utilisateur = null;
		try {
			utilisateur=validationEmail(email);
		} catch (Exception e) {
			erreur.put("email", e.getMessage());
		}
		
		if(utilisateur != null) {
			try {
				validationPassword(password, utilisateur);
			} catch (Exception e) {
				erreur.put("password", e.getMessage());
			}
			userType=daoUtilisateur.getUserType(utilisateur.getId());
		}
		
		return utilisateur;
	}
	
	public Utilisateur creerUtilisateur(HttpServletRequest request) {
		Utilisateur utilisateur=new Utilisateur();
		String login=request.getParameter("email");
		String password=request.getParameter("password");
		utilisateur=validationConnexion(login, password);
		return utilisateur;	
	}


}
