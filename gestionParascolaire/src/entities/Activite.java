package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table
public class Activite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private boolean privatee;
	private String nom;
	private Date date;
	private String lieu;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="id_club")
	private Club club;
	
	@ManyToMany(mappedBy="activites")
	@LazyCollection(LazyCollectionOption.FALSE)
	List<Etudiant> etudiants;
	
	
	
	public Activite() {}
	public Activite(boolean privatee, String nom, Date date, String lieu, String description) {
		this.privatee = privatee;
		this.nom = nom;
		this.date = date;
		this.lieu = lieu;
		this.description = description;
	}


	
	public int getId() {
		return id;
	}
	public boolean isPrivatee() {
		return privatee;
	}
	public String getNom() {
		return nom;
	}
	public Date getDate() {
		return date;
	}
	public String getLieu() {
		return lieu;
	}
	public String getDescription() {
		return description;
	}
	public Club getClub() {
		return club;
	}


	
	public void setId(int id) {
		this.id = id;
	}
	public void setprivatee(boolean privatee) {
		this.privatee = privatee;
	}
	public void setNom_activite(String nom) {
		this.nom = nom;
	}
	public void setDate_activite(Date date) {
		this.date = date;
	}
	public void setLieu_activite(String lieu) {
		this.lieu = lieu;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	
	
	
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void addEtudiants(Etudiant etudiant) {
		this.etudiants.add(etudiant);
	}

}
