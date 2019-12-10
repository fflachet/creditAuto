package creditAuto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import creditAuto.config.JdbcDataSource;
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
	
	// TO DO findById / findByName?/ Remove/ Update
	

}
