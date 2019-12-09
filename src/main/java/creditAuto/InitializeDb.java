package creditAuto;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		Client client1 = new Client();
		client1.setAdress("blabalalallalalala");
		client1.setBirthDate(LocalDate.of(1984, 7, 7));
		client1.setFirstname("georges");
		client1.setLastname("garnier");
		client1.setGender(Gender.MALE);
		
		client1.setContrat(cdao.findByClientId(client1.getId()));
		
		Contract contrat = new Contract();
		contrat.setClosureDate(LocalDate.of(2019, 12, 31));
		contrat.setPaymentStartDate(LocalDate.of(2019, 12, 9));
		contrat.setPaymentEndDate(LocalDate.of(2019, 12, 31));
		contrat.setVehicleCategory(VehicleCategory.A);
		contrat.setContractNumber(1);
			
		cdao.persist(contrat);
		cldao.persist(client1);
		
		
		
	}

}
