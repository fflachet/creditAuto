package creditAuto;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitializeDb {
	
	@Autowired
	private UserDAO udao;
	
	@PostConstruct
	public void save() {
		User user1 = new User();
		user1.setLogin("test");
		user1.setUserFirstname("steve");
		user1.setPassword("bobby");
		
		udao.persist(user1);
	}

}
