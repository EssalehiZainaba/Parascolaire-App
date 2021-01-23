package entities;

import javax.persistence.*;

@Entity
@Table(name="responsable_club")
public class responsableClub {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_responsable")
	private int id;

	
	public responsableClub() {}
	
	
	public responsableClub(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	

}
