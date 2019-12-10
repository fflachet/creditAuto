package creditAuto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ClientDAO extends JdbcRepository {
	
	@PersistenceContext
    protected EntityManager em;
	
	protected Session getSession() {
        return em.unwrap(Session.class);
    }

    public void persist(Object entity) {
        em.persist(entity);
    }

    public List<Client> findAll(){
        return this.jdbcTemplate.query("select * from client", new ClientMapper());
    }

	public Client findById(long id) {
		 return this.jdbcTemplate.queryForObject("select client.lastname from client where client.id = ?", new Object[] {id}, new ClientMapper());
		// return id;
		 
	}

}
