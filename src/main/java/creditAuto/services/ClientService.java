package creditAuto.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import creditAuto.dao.ClientDAO;
import creditAuto.model.Client;
import creditAuto.model.Gender;

@Service
public class ClientService {
	
	@Autowired
	private ClientDAO clientD;
	
	private Client client;
	
	public void createClient(String firstName, String lastName, String adress, String email, String birthDate, Gender gender) { 
		client= new Client(firstName, lastName, adress, email, birthDate, gender);
		//System.out.println(client + " service" );
		clientD.persist(client);
		//listSimul.add(newSimul);
		
	}
	
	public Client find(String email) {
		Client c = clientD.findByEmail(email);
		return c;
	}
	
	public Client findById(Long id) {
		return clientD.findById(id);
	}
	
	
	
	

}
