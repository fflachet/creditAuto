package creditAuto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class ClientService {
	
	private Client client;
	
	public void createClient(String firstname, String lastname, String adress, String birthDate, Gender gender) { 
		client= new Client(firstname, lastname, adress, birthDate, gender);
		System.out.println(client);
		//listSimul.add(newSimul);
		
	}
	
	

}
