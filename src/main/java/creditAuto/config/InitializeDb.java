package creditAuto.config;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import creditAuto.dao.ClientDAO;
import creditAuto.dao.ContractDAO;
import creditAuto.dao.RateDAO;
import creditAuto.dao.UserDAO;
import creditAuto.model.Rate;
import creditAuto.model.Role;
import creditAuto.model.User;

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
		/*User user1 = new User();
		user1.setUsername("francois");
		user1.setUserFirstname("francois");
		user1.setUserLastname("francois");
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
//<<<<<<< HEAD
//=======
//		
//		
//		
//		
//>>>>>>> 08785604252fb3ff659586e8c994a8ce55d7255a
//		Map<Integer, Contract> contrat = cdao.findByClientId(1l);
//		System.out.println(contrat);
//		
//		Client c1 = cldao.findByEmail("gegege@gmailcom");
//		System.out.println(c1);
	}

}
