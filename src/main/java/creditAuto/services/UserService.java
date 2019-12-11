package creditAuto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import creditAuto.dao.UserDAO;
import creditAuto.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public boolean  checkLoginInformation(User user) {
		if (userDAO.findByUsername(user.getUsername()) != null) {
			if(userDAO.comparePassword(user)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
		//return rateValue;
	}
}
