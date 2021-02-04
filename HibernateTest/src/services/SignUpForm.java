package services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.User;
import models.UserPersister;

public class SignUpForm {
	Map<String,String> errors = new HashMap<String,String>();
	String result;
	UserPersister testHiber;

	public Map<String, String> getErrors() {
		return errors;
	}


	public String getResult() {
		return result;
	}


	
	
	public SignUpForm(UserPersister testHiber) {
		this.testHiber = testHiber;
	}


	public User userSignUp(HttpServletRequest request) {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		User user = new User();
		validateEmail(email, "email");
		validatePWD(pwd, "pwd");
		
		if(errors.isEmpty()) {
			user.setEmail(email);
			user.setPassword(pwd);
			testHiber.insertUser(user);
			result = "Vous vous êtes inscrit(e) avec succès.";
		}
		else {
			user = null;
			result = "Échec d'inscription.";
		}

		
		
		return user;
	}
	

	
	
	//--------------------------------Validation Methods--------------------------------
	
	//valider le numéro d'apogée
	private void validateEmail(String str, String errKey) {
		if(!tryEmpty(str, errKey))			//validate if the field is not empty
			tryIncorrectEmail(str, errKey);	//validate if the data is an email
	}
	
	//valider le nom et le prénom
	private void validatePWD(String str, String errKey) {
		if(!tryEmpty(str, errKey))			//validate if the field is not empty
			tryShortPWD(str, errKey);		//validate if the pwd is not too short
	}
	
	
//--------------------------------Try-Catch and Checking Methods--------------------------------

	//try and catch in case of an empty field
	private boolean tryEmpty(String str, String errKey) {
		try {
			checkEmpty(str);
		}
		catch (SignUpFormException e) {
			errors.put(errKey, e.getMessage());
			return true;
		}
		return false;
	}
	
	private void checkEmpty(String str) throws SignUpFormException {
		if(str.isEmpty())
			throw new SignUpFormException("Ce champ ne doit pas être vide.");
	}
	
		
		
	//try and catch in case of a field that is not an email
	private void tryIncorrectEmail(String str, String errKey) {
		try {
			checkIncorrectEmail(str);
		}
		catch(SignUpFormException e) {
			errors.put(errKey, e.getMessage());
		}
	}
	
	private void checkIncorrectEmail(String str) throws SignUpFormException{
		if(!str.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"))
	        throw new SignUpFormException("Ce champ doit contenir une adresse email valide.");
		if(testHiber.findUser(str)!=null)
			throw new SignUpFormException("Cette adresse email est déjà utilisée.");
	}
		
		
		
	//try and catch in case of a field with less than 6 characters
	private void tryShortPWD(String str, String errKey) {
		try {
			checkShortPWD(str);
		}
		catch (SignUpFormException e) {
			errors.put(errKey, e.getMessage());
		}
	}
	
	private void checkShortPWD(String str) throws SignUpFormException {
		if(str.trim().length()<6)
			throw new SignUpFormException("Ce champ doit contenir au moins 6 caractères.");
	}

	
}
