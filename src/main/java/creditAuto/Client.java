package creditAuto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Gender gender;

	
	@OneToMany(mappedBy = "client")
	private List<Contract> contractList = new ArrayList<>();
	
	// Constructor
	public Client() {}

	public Client(Long id, String firstname, String lastname, String adress, LocalDate birthDate, Gender gender,
			List<Contract> contrat, String email) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.adress = adress;
		this.birthDate = birthDate;
		this.gender = gender;
		this.contractList = contrat;
		this.email = email;
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

	public List<Contract> getContrat() {
		return contractList;
	}

	public void setContrat(List<Contract> contrat) {
		this.contractList = contrat;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", adress=" + adress
				+ ", birthDate=" + birthDate + ", email=" + email + ", gender=" + gender + ", contractList="
				+ contractList + "]";
	}
	
	
	
	//Getters/Setters


	
	
	
	
	
	
	
}
