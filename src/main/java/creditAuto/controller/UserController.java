package creditAuto.controller;

import java.security.Principal;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import creditAuto.model.User;
import creditAuto.services.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
    public boolean login(@RequestBody User user) {
		System.out.println(user);
		
		userService.checkLoginInformation(user);
		
        return
          user.getUsername().equals("admin") && user.getPassword().equals("adminPass");
    }
	
	  @RequestMapping("/admin")
	    public Principal user(HttpServletRequest request) {
	        String authToken = request.getHeader("Authorization")
	          .substring("Basic".length()).trim();
	        return () ->  new String(Base64.getDecoder()
	          .decode(authToken)).split(":")[0];
	    }
}
