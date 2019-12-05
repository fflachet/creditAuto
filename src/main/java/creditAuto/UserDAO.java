package creditAuto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends JdbcRepository {
	
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
	

}
