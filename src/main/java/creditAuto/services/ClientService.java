package creditAuto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import creditAuto.dao.ClientDAO;
import creditAuto.model.Client;
import creditAuto.model.Gender;

@Service
public class ClientService {
	
	@Autowired
	private ClientDAO clientDAO;
	
	private Client client;
 
	public Client findClientbyEmail(String email) {
		return clientDAO.findClientbyEmail(email);
	}
	
	public Client createClient(String firstName, String lastName, String adress, String email, String birthDate, Gender gender) {
		client= new Client(firstName, lastName, adress, email, birthDate, gender);
		clientDAO.saveClient(client);
		return client;
	}
	
}
