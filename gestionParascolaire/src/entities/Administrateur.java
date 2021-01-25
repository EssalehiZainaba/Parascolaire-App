package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="administrateur")
@DiscriminatorValue("admin")
public class Administrateur extends Utilisateur{

	public Administrateur(int id, String login, String pwd) {
		this.id = id;
		this.login = login;
		this.password = pwd;
	}
	
}
