package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name="etudiant")
public class Etudiant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_etudiant")
	private int id;
	private String nom;
	private String prenom;
	private String filiere;
	private String cne;
	private String pays;
	private String ville;
	
	public int getId() {
		return id;
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
	
	
	public void setId(int id) {
		this.id = id;
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
}
