package models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import beans.User;

public class UserPersisterImplementation implements UserPersister{

	   /**
	    * Objet Session de Hibernate
	    */
	   private SessionFactory sessionFactory;

	   /**
	    * Constructeur établissant une connexion avec Hibernate
	    */
	   public UserPersisterImplementation(SessionFactory sessionFactory) {
		   this.sessionFactory = sessionFactory;
	   }
	   
	   
	   public void insertUser(User user) {
		   Session session = sessionFactory.openSession();
		   session.beginTransaction();
		   session.save(user);
		   session.getTransaction().commit();
		   session.close();
	   }
	   
	   public void updateUser(User user) {
		   Session session = sessionFactory.openSession();
		   session.beginTransaction();
		   session.update(user);
		   session.getTransaction().commit();
		   session.close();
	   }
	   
	   public User findUser(String email) {
		   Session session = sessionFactory.openSession();
		   session.beginTransaction();
		   @SuppressWarnings("rawtypes")
		   Query query = session.createQuery("FROM User u WHERE u.email = :email");
		   query.setParameter("email", email);
		   @SuppressWarnings("unchecked")
		   List<User> users = (List<User>)query.list();
		   users.add(null);
		   User user = users.get(0);
		   session.getTransaction().commit();
		   session.close();
		   return user;
	   }
	   
	   public List<User> listUsers() {
		   Session session = sessionFactory.openSession();
		   session.beginTransaction();
		   @SuppressWarnings("unchecked")
		   List<User> users = (List<User>) session.createQuery("from User").list();
		   session.getTransaction().commit();
		   session.close();
		   return users;
	   }

	}