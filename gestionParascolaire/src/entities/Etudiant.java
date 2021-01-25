package entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table (name="etudiant")
@DiscriminatorValue("etd")
public class Etudiant extends Utilisateur{

	private String nom;
	private String prenom;
	private String filiere;
	private String cne;
	private String pays;
	private String ville;
	private String adresse;
	
	public Etudiant(String login, String pwd) {
		this.login = login;
		this.password = pwd;
	}
	
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getFiliere() {
		return filiere;
	}
	public String getCne() {
		return cne;
	}
	public String getPays() {
		return pays;
	}
	public String getVille() {
		return ville;
	}
	public String getAdresse() {
		return adresse;
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
