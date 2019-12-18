package creditAuto.config;

import java.math.BigDecimal;

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
import creditAuto.model.VehicleCategory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import creditAuto.model.Rate;


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


////		Ajout des user
//		User romain = new User("Romain", "Boijoux", "romain", "chargeDeClientele", Role.CUSTOMERADVISER);
//		udao.persist(romain);
//		User aimen = new User("Aimen", "Masmoudi", "aimen", "manager", Role.MANAGER);
//		udao.persist(aimen);
//		User francois = new User("Francois", "Flachet", "francois", "admin", Role.ADMIN);
//		udao.persist(francois);
//	
////		Ajout des clients
//		Client rick = new Client("Rick", "Sanchez", "12 rue", "aaaaa@aaaaaaa.com", "12/12/1962", Gender.MALE);
//		cdao.persist(rick);
//		Client morty = new Client("Morty", "Sanchez", "12 rue", "morty@sanchez.com", "12/12/1995", Gender.MALE);
//		cdao.persist(morty);
//		Client karim = new Client("Karim", "Smith", "Lunel", "karim@smith.com", "12/12/1987", Gender.MALE);
//		cdao.persist(karim);
//		
////		Ajout de taux
//		Rate T1 = new Rate("T1", new BigDecimal(2));
//		rdao.persist(T1);
//		Rate T2 = new Rate("T2", new BigDecimal(3));
//		rdao.persist(T2);
//		Rate T3 = new Rate("T3", new BigDecimal(4.5));
//		rdao.persist(T3);
//		Rate T4 = new Rate("T4", new BigDecimal(1.5));
//		rdao.persist(T4);
//		
////		Ajout de contrats
//		Contract contrat1 = new Contract(1, LocalDate.of(2019, Month.DECEMBER, 17), LocalDate.of(2020, Month.DECEMBER, 17), null, null, null, 12, VehicleCategory.A, null);
//		cdao.persist(contrat1);
//		Contract contrat2 = new Contract(2, LocalDate.of(2019, Month.DECEMBER, 19), LocalDate.of(2020, Month.NOVEMBER, 19), null, null, null, 11, VehicleCategory.A, null);
//		cdao.persist(contrat2);
//		


		/*User user1 = new User();
		user1.setLogin("test");
		user1.setUserFirstname("steve");
		user1.setUserLastname("Rogers");
		user1.setPassword("admin");
		user1.setRole(Role.ADMIN);
		udao.persist(user1);

        List<BigDecimal> listBigD = new ArrayList<>();
        BigDecimal bd1 = new BigDecimal(0.2);
        BigDecimal bd2 = new BigDecimal(0.2);
        BigDecimal bd3 = new BigDecimal(0.2);
        BigDecimal bd4 = new BigDecimal(0.2);
        BigDecimal bd5 = new BigDecimal(0.2);
        BigDecimal bd6 = new BigDecimal(0.2);

        listBigD.add(bd1);
        listBigD.add(bd2);
        listBigD.add(bd3);
        listBigD.add(bd4);
        listBigD.add(bd5);
        listBigD.add(bd6);

        for(BigDecimal b : listBigD) {
            Rate rate = new Rate();
            rate.setRateValue(b);
            rdao.persist(rate);
        }*/
//		Client client1 = new Client();
//		client1.setAdress("blabalalallalalala");
//		client1.setBirthDate("12-12-1212");
//		client1.setFirstName("georges");
//		client1.setLastName("garnier");
//		client1.setGender(Gender.MALE);
//		client1.setEmail("gegege@gmailcom");
//		cldao.persist(client1);
		
//		Rate r1 = new Rate();
//		Rate r2 = new Rate();
//		Rate r3 = new Rate();
//		r1.setRateName("T1");
//		r2.setRateName("T2");
//		r3.setRateName("T3");
//		r1.setRateValue(BigDecimal.valueOf(0.5));
//		r2.setRateValue(BigDecimal.valueOf(0.7));
//		r3.setRateValue(BigDecimal.valueOf(0.9));
//		
//		rdao.persist(r1);
//		rdao.persist(r2);
//		rdao.persist(r3);	
	}

	@PostConstruct
	public void show() {

	}

}
