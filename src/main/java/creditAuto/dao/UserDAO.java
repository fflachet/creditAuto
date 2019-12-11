package creditAuto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import creditAuto.config.JdbcDataSource;
import creditAuto.mapper.ClientMapper;
import creditAuto.mapper.UserMapper;
import creditAuto.model.User;

@Repository
@Transactional
public class UserDAO extends JdbcDataSource {
	
	@PersistenceContext
	protected EntityManager em;
	
	protected Session getSession() {
		return em.unwrap(Session.class);
	}
	
	public void persist(Object entity) {
		em.persist(entity);
	}
	
	public List<User> findAll(){
		return this.jdbcTemplate.query("select * from user_", new UserMapper());
	}
	
	public User findByUsername (String username) {
		 return this.jdbcTemplate.queryForObject("select * from user_ where user_.username = ?", new Object[] {username}, new UserMapper());
	}
	
	public boolean comparePassword (User user) {
		//prepared statement n'est pas remplacé par le password 
		//User userInDB = findByUsername(user.getUsername());
		//User userInDB = (User) this.jdbcTemplate.query("select * from user_ where user_.password = ?", new UserMapper());
//		User userInDB = (User) this.jdbcTemplate.query("select * from user_ where user_.password = ? and user_.username = ?", new Object[] {user.getPassword()},new UserMapper());
	
		TypedQuery<User> query = em.createQuery("from user_ where user_.password = :password and user_.username = :username", User.class);
		query.setParameter("password", user.getPassword());
		query.setParameter("username", user.getUsername());
		
		User userInDB = query.getSingleResult();
		System.out.println(userInDB);
		
		
		if(userInDB != null) {
			System.out.println("true mon gars");
			return true;
		} else {
			System.out.println("true mon gars");
			return false;
		}
		
		
//		
//		if (user.getPassword().equals(userInDB.getPassword())) {
//			System.out.println("true mon gars");
//			return true;
//		} else {
//			System.out.println("false mon gars");
//			return false;
//		}
	}
	
	// TO DO findById / findByName?/ Remove/ Update
	

}
