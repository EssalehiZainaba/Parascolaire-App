package entities;

import javax.persistence.*;


@Entity
@Table(name = "club")
public class Club {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "paragraphe")
	private String paragraphe;
	@OneToOne
	@JoinColumn(name = "id_responsable_club", referencedColumnName = "id_utilisateur")
	private ResponsableClub responsableClub;

	
	
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
