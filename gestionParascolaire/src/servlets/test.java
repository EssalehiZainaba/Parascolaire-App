package servlets;

import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;
import com.sun.org.slf4j.internal.Logger;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Prepared; 

public class test {

	public static void sendMail(String recepient) throws Exception
	{
		Properties properties = new Properties();
		
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable","true");
	    properties.put("mail.smtp.host", "smtp.gmail.com");
	    properties.put("mail.smtp.port", "587");
	    
	    String myAccountEmail = "KKKKKKKKKKKa@gmail.com"; //put your email here for test
	    String password ="//////////"; //put your email password here
	    
	    Session session = Session.getInstance(properties, new Authenticator() {
	    	@Override
	    	protected PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication(myAccountEmail,password);
	    	}
	    	
		});
	    
	    Message message = prepareMessage(session, myAccountEmail, recepient);
	    
	    Transport.send(message);
	    System.out.print("message sent");
	    	
	    
	}
	
	
	
	
	private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("first email from java");
			message.setText("this is my first email test java");
			return message;
		}catch(Exception e)
		{
			System.out.print("error sending mssg");
		}		
		return null;
	}


}
