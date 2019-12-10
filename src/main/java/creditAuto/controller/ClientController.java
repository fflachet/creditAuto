package creditAuto.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import creditAuto.dao.ClientDAO;
import creditAuto.model.Client;
import creditAuto.services.ClientService;



	
	@RestController
	@CrossOrigin(origins="http://localhost:4200")
	//@CrossOrigin(origins="*")
	public class ClientController {
		
		@Autowired
		private ClientService clientService;

		@RequestMapping(value = "/searchclient", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
		public Client getClient(String email) {
			Client foundClient = clientService.findClientbyEmail(email);
			System.out.println(foundClient);
			return foundClient;
		}
		
		@RequestMapping(value = "/nouveauClient", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public Client getClient(@RequestBody Client client) {
			System.out.println(client +" controller ");
			clientService.createClient(client.getFirstName(), client.getLastName(), client.getAdress(), client.getEmail(), client.getBirthDate() , client.getGender());	
			return client;
		}
		
	
}
