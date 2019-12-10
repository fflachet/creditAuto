package creditAuto;

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



	
	@RestController
	@CrossOrigin(origins="http://localhost:4200")
	//@CrossOrigin(origins="*")
	public class ClientController {
		
		@Autowired
		private ClientService clientService;

		@RequestMapping(value = "/nouveauClient", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public Client getClient(@RequestBody Client client) {
			
//			System.out.println("getClient");
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//			LocalDate birthClient = LocalDate.parse(client.getBirthDate().toString(), formatter);
			
			clientService.createClient(client.getFirstName(), client.getLastName(), client.getAdress(), client.getBirthDate() , client.getGender());
			System.out.println(client);
			return client;
		}
		
	
}
