package creditAuto.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import creditAuto.dao.ClientDAO;
import creditAuto.dao.ContractDAO;
import creditAuto.dao.RateDAO;
import creditAuto.model.Client;
import creditAuto.model.Contract;
import creditAuto.model.Gender;

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
	
	@PostConstruct
	public void save() {
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
//		
//		
//		Contract contrat = new Contract();
//		contrat.setClosureDate(LocalDate.of(2019, 12, 31));
//		contrat.setPaymentStartDate(LocalDate.of(2019, 12, 9));
//		contrat.setPaymentEndDate(LocalDate.of(2019, 12, 31));
//		contrat.setVehicleCategory(VehicleCategory.A);
//		contrat.setContractNumber(1);
//		
//		cldao.persist(client1);
//		contrat.setClient(client1);
//		cdao.persist(contrat);
		
		
		
	}
	
	@PostConstruct
	public void show() {
//		List<Client> client = cldao.findAll();
//		List<Contract> contrat = cdao.findAll();
//		
//		for(Client c : client) {
//			System.out.println(c.getId());
//			System.out.println(c.getLastname());
//		}
//		
//		for(Contract con : contrat) {
//			System.out.println(con);
//		}
//		Client client1 = new Client();
//		client1.setId(18l);
//		
//		Contract ctest = new Contract();
//		ctest.setClient(client1);
//		System.out.println(ctest);
		Map<Integer, Contract> contrat = cdao.findByClientId(1l);
		System.out.println(contrat);
		
		Client c1 = cldao.findByEmail("gegege@gmailcom");
		System.out.println(c1);
	}

}
