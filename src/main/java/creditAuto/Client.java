package creditAuto;

import java.util.Date;

public class Client {
	private Long id;
	private String firstname;
	private String lastname;
	private String adresse;
	private Date birthday;
	private Genre genre;
	private int numeroContrat;
	private Contrat contrat;
	
	// Constructor
	public Client() {}
	
	public Client(Long id, String firstname, String lastname, String adresse, Date birthday, Genre genre,
			int numeroContrat, Contrat contrat) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.adresse = adresse;
		this.birthday = birthday;
		this.genre = genre;
		this.numeroContrat = numeroContrat;
		this.contrat = contrat;
	}

	
	//Getters/Setters
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(int numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	
	
	
	
	
	
	
	
}
