package creditAuto;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitializeDb {
	
	@Autowired
	private RateDAO rdao;
	
	/*@PostConstruct
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
        }
		
	}*/

}
