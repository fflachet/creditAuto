package creditAuto.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import creditAuto.dao.UserDAO;
import creditAuto.model.User;

@Component
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(final String username) {
		User user = userDAO.findByUsername(username);
		if (user != null) {
			List<GrantedAuthority> rules = new ArrayList<>();
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), rules);
		}
		throw new UsernameNotFoundException("username.not.found");
	}
}