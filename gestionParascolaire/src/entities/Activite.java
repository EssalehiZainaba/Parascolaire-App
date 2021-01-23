package entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Activite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean is_private;
	private String nom_activite;
	private Date date_activite;
	private String lieu_activite;
	private String description;
	
	
	public Activite() {}
	

	public Activite(boolean is_private, String nom_activite, Date date_activite, String lieu_activite,
			String description) {
		this.is_private = is_private;
		this.nom_activite = nom_activite;
		this.date_activite = date_activite;
		this.lieu_activite = lieu_activite;
		this.description = description;
	}






	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isIs_private() {
		return is_private;
	}
	public void setIs_private(boolean is_private) {
		this.is_private = is_private;
	}
	public String getNom_activite() {
		return nom_activite;
	}
	public void setNom_activite(String nom_activite) {
		this.nom_activite = nom_activite;
	}
	public Date getDate_activite() {
		return date_activite;
	}
	public void setDate_activite(Date date_activite) {
		this.date_activite = date_activite;
	}
	public String getLieu_activite() {
		return lieu_activite;
	}
	public void setLieu_activite(String lieu_activite) {
		this.lieu_activite = lieu_activite;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
