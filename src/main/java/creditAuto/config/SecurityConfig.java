package creditAuto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				// .antMatchers("/admin/**").hasRole("ADMIN")
				// .antMatchers("/anonymous*").anonymous()
//				.antMatchers("/login").permitAll()
				.anyRequest().authenticated().and()
//				.formLogin()09
				// .loginPage("/login.html")
				// .loginProcessingUrl("/perform_login")
				// .defaultSuccessUrl("/homepage.html", true)
				// .failureUrl("/login.html?error=true")
				// .failureHandler(authenticationFailureHandler())
				.httpBasic();
		// .logout();
		// .logoutUrl("/perform_logout")
		// .deleteCookies("JSESSIONID");
		// .logoutSuccessHandler(logoutSuccessHandler());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}