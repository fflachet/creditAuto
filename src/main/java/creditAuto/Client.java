package creditAuto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String adress;
	@Column
	private String birthDate;
	@Column
	private Gender gender;

	
	@OneToMany(mappedBy = "client")
	private List<Contract> contractList = new ArrayList<>();
	
	// Constructor
	public Client() {}

	public Client(Long id, String firstName, String lastName, String adress, String birthDate, Gender gender,
			List<Contract> contrat) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.birthDate = birthDate;
		this.gender = gender;
		this.contractList = contrat;
	}
	
	public Client(String firstName, String lastName, String adress, String birthDate, Gender gender) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.birthDate = birthDate;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
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
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", adress=" + adress
				+ ", birthDate=" + birthDate + ", gender=" + gender + ", contractList=" + contractList + "]";
	}
	
	
	
	//Getters/Setters


	
	
	
	
	
	
	
}
