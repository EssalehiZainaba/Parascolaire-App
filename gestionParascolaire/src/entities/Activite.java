package entities;

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
	
	private boolean privee;
	private String nom;
	private String date;
	private String lieu;
	private String imagePath;
	
	@ManyToOne
	@JoinColumn(name="id_club")
	private Club club;
	
	@ManyToMany(mappedBy="activites")
	@LazyCollection(LazyCollectionOption.FALSE)
	List<Etudiant> etudiants;
	
	
	public Activite() {}
	public Activite(boolean privee, String nom, String date, String lieu) {
		this.privee = privee;
		this.nom = nom;
		this.date = date;
		this.lieu = lieu;
	}


	

	public int getId() {
		return id;
	}
	public boolean isPrivee() {
		return privee;
	}
	public String getNom() {
		return nom;
	}
	public String getDate() {
		return date;
	}
	public String getLieu() {
		return lieu;
	}
	public Club getClub() {
		return club;
	}
	public String getImagePath() {
		return imagePath;
	}
	public int getSize() {
		return etudiants.size();
	}



	
	public void setId(int id) {
		this.id = id;
	}
	public void setPrivee(boolean privee) {
		this.privee = privee;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void addEtudiants(Etudiant etudiant) {
		this.etudiants.add(etudiant);
	}
	public boolean participe(Etudiant etudiant) {
		if(etudiants.contains(etudiant))
			return true;
		return false;
	}


	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activite other = (Activite) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	



}
