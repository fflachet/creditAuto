package creditAuto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_")
public class User {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column
	private String userFirstname;
	
	@Column
	private String userLastname;
	
	@Column
	private String login;
	
	@Column
	private String password;
	
	private Role roleObject;
	
	@Column
	private int role;

	
	public User() {}
	
	public User(Long id, String userFirstname, String userLastname, String login, String password, int role) {
		Id = id;
		this.userFirstname = userFirstname;
		this.userLastname = userLastname;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUserFirstname() {
		return userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(Role roleObject) {
		this.role = roleObject.getRole();
	}
	

}
