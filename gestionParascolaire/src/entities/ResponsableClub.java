package entities;

import javax.persistence.*;

@Entity
@Table(name="responsable_club")
public class ResponsableClub {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_responsable")
	private int id;

	
	public ResponsableClub() {}
	
	
	public ResponsableClub(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	

}
