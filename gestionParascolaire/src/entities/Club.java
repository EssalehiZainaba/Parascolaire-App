package entities;

import java.util.List;
import java.util.Set;

import javax.persistence.*;


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
	
	@OneToMany(mappedBy="club", fetch = FetchType.EAGER)
	List<Activite> activites;
	
	@OneToMany(mappedBy="club")
	Set<Appartenance> appartenances;
	
	public List<Activite> getActivites() {
		return activites;
	}
	
	public Set<Appartenance> getAppartenances() {
		return appartenances;
	}

	public void addAppartenances(Appartenance appartenance) {
		this.appartenances.add(appartenance);
	}

	
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


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getParagraphe() {
		return paragraphe;
	}


	public void setParagraphe(String paragraphe) {
		this.paragraphe = paragraphe;
	}

	public ResponsableClub getResponsableClub() {
		return responsableClub;
	}

	public void setResponsableClub(ResponsableClub responsableClub) {
		this.responsableClub = responsableClub;
	}
	
	

}
