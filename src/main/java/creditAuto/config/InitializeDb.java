package creditAuto.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import creditAuto.dao.ClientDAO;
import creditAuto.dao.ContractDAO;
import creditAuto.dao.RateDAO;
import creditAuto.dao.UserDAO;
import creditAuto.model.Client;
import creditAuto.model.Contract;
import creditAuto.model.Gender;
import creditAuto.model.Role;
import creditAuto.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class InitializeDb {

	@Autowired
	private RateDAO rdao;

	@Autowired
	private ClientDAO cldao;

	@Autowired
	private ContractDAO cdao;

	@Autowired
	private UserDAO udao;

	@PostConstruct
	public void save() {


//		Ajout des user
		User romain = new User("Romain", "Boijoux", "romain", "chargeDeClientele", Role.CUSTOMERADVISER);
		udao.persist(romain);
		User aimen = new User("Aimen", "Masmoudi", "aimen", "manager", Role.MANAGER);
		udao.persist(aimen);
		User francois = new User("Francois", "Flachet", "francois", "admin", Role.ADMIN);
		udao.persist(francois);
	
//		Ajout des clients
		Client rick = new Client("Rick", "Sanchez", "12 rue", "aaaaa@aaaaaaa.com", "12/12/1962", Gender.MALE);
		cdao.persist(rick);
		Client morty = new Client("Morty", "Sanchez", "12 rue", "morty@sanchez.com", "12/12/1995", Gender.MALE);
		cdao.persist(morty);
		Client karim = new Client("Karim", "Smith", "Lunel", "karim@smith.com", "12/12/1987", Gender.MALE);
		cdao.persist(karim);
		
//		Ajout d'un taux
				

	}

	@PostConstruct
	public void show() {

	}

}
