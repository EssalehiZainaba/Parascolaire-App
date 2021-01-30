package services;

import java.util.HashMap;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;



import dao.DaoClub;
import dao.DaoResponsableClub;
import dao.DaoResponsableClubImpl;
import dao.JPAUtil;
import entities.Club;
import entities.ResponsableClub;



public class CreerClubForm {

	 public HashMap<String,String> Erreur = new HashMap<String, String>();
		
	 public String resultat;
	 
	 DaoClub daoClub;
	 
	 public HashMap<String,String> getErreur()
	   {
		   
		   return Erreur;
		   
	   }

	  public String getResultat()
	   {
		   
		   return resultat;
		   
	   }
	  
	  public CreerClubForm(DaoClub daoClub)
	  {
		  this.daoClub = daoClub;
	  }
	  
	  
	  
	  public void validationName(String name) throws Exception{
				  
			if(name.trim().length() == 0 )
			{
				throw new Exception( "Merci de saisir un nom du club." );

			}
		
			else {
				
				for(int i=0; i<daoClub.lister().size();i++)
				{
					if( daoClub.lister().get(i).getName().equals(name))
					{
						throw new Exception( "ce nom existe deja." );
					}
				
				}
				
			}
			
		    }
	  
	  public void validationEmail(String email) throws Exception{
		  
			if(email.trim().length() == 0 )
			{
				throw new Exception( "Merci de saisir un email valide." );
			}
	  }
	  
	  
	  public String Login(String club)
		{
			return club+"@uiz.ac.ma";
		}
	  
		
	 public  String password()
		{
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
		String password = RandomStringUtils.random( 15, characters );
		return password;
		}
	  
	 
	 public static void sendMail(String recepient, String login, String Password, String name) throws Exception
		{
			Properties properties = new Properties();
			
		    properties.put("mail.smtp.auth", "true");
		    properties.put("mail.smtp.starttls.enable","true");
		    properties.put("mail.smtp.host", "smtp.gmail.com");
		    properties.put("mail.smtp.port", "587");
		    
		    String myAccountEmail = "parascolaire.ensaa@gmail.com"; //put your email here for test
		    String password ="Ensaa123"; //put your email password here
		    
		    Session session = Session.getInstance(properties, new Authenticator() {
		    	@Override
		    	protected PasswordAuthentication getPasswordAuthentication() {
		    		return new PasswordAuthentication(myAccountEmail,password);
		    	}
		    	
			});
		    
		    //Message message = prepareMessage(session, myAccountEmail, recepient);
		    
		  
		    Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Compte Responsable du club "+name+" de la plateforme Parascolaire Ensaa");
			message.setText("Login : "+login+"   Mot de passe : "+Password );
				
		    
		    Transport.send(message);   	
		    
		}
		
	
	/*private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
			try {
				
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(myAccountEmail));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
				message.setSubject("Votre compte du plateforme Gestion Parascolaire Ensaa");
				message.setText("");
				return message;
			}catch(Exception e)
			{
				System.out.print("error sending mssg");
			}		
			return null;
		}*/

	 
	 
	 
 public Club creerClub(HttpServletRequest request) 
{
		 
	 Club club = new Club(); 
		 
	 String name = request.getParameter("name");
	 String email = request.getParameter("email");
		 
	  
	 try
	 {
		validationName(name); 
	 }
	 catch(Exception e)
	 {
		 Erreur.put("name",e.getMessage());
		 
	 }
	 
	 try
	 {
		validationEmail(email); 
	 }
	 catch(Exception e)
	 {
		 Erreur.put("email",e.getMessage());
		 
	 }
	 
	 
	 
	 if ( getErreur().isEmpty() ) {
		
		ResponsableClub resp = new ResponsableClub(Login(name), password());
		DaoResponsableClub daoResp = new DaoResponsableClubImpl(JPAUtil.getEntityManagerFactory());
		daoResp.add(resp);
		resp = daoResp.find(resp.getId());
		
	    //DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory()); 
		club.setName(name); 
		club.setDescription("desc");
		club.setParagraphe("parag");
		club.setResponsableClub(resp);
		
		daoClub.add(club);
		
		try {
			sendMail(email,Login(name),password(),name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	   resultat="Ajout club avec succes.";
       
     } else {
    	 club = null;
    	 
     	resultat="echec d'ajout club.";
        	        }
	 
		return club;
	 
	 }
	 
	 
	
	
}
