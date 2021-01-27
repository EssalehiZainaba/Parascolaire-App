package entities;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "club")
public class Club {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_club")
	private int id;
	
	private String name;
	private String description;
	private String paragraphe;
	
	@OneToOne
	@JoinColumn(name = "id_responsable_club", referencedColumnName = "id_utilisateur")
	private ResponsableClub responsableClub;
	
	@OneToMany(mappedBy="club")
	@LazyCollection(LazyCollectionOption.FALSE)
	List<Activite> activites;
	
	@OneToMany(mappedBy="club")
	Set<Appartenance> appartenances;
	


	public Club() {}
	public Club(String name , String description , String paragraphe)
	{
		this.name=name;
		this.description=description;
		this.paragraphe=paragraphe;
	}


	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getParagraphe() {
		return paragraphe;
	}
	public ResponsableClub getResponsableClub() {
		return responsableClub;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setParagraphe(String paragraphe) {
		this.paragraphe = paragraphe;
	}
	public void setResponsableClub(ResponsableClub responsableClub) {
		this.responsableClub = responsableClub;
	}

	
	
	public List<Activite> getActivites() {
		return activites;
	}
	public void addActivites(Activite activite) {
		this.activites.add(activite);
	}
	
	public Set<Appartenance> getAppartenances() {
		return appartenances;
	}
	public void addAppartenances(Appartenance appartenance) {
		this.appartenances.add(appartenance);
	}

}
