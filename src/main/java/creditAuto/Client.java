package creditAuto;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Client {
	private Long id;
	private String firstname;
	private String lastname;
	private String adresse;
	private LocalDate birthday;
	private int numeroContrat;
	
	// TO DO
}
