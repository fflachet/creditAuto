package creditAuto;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String adress;
	@Column
	private LocalDate birthDate;
	@Column
	private Gender gender;

	
	@OneToMany
	private Contract contrat;
	
	// Constructor
	public Client() {}

	public Client(Long id, String firstname, String lastname, String adress, LocalDate birthDate, Gender gender,
			Contract contrat) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.adress = adress;
		this.birthDate = birthDate;
		this.gender = gender;
		this.contrat = contrat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Contract getContrat() {
		return contrat;
	}

	public void setContrat(Contract contrat) {
		this.contrat = contrat;
	}
	
	
	
	//Getters/Setters


	
	
	
	
	
	
	
}
