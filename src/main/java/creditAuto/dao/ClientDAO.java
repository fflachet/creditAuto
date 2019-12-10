package creditAuto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import creditAuto.config.JdbcDataSource;
import creditAuto.mapper.ClientMapper;
import creditAuto.model.Client;
import creditAuto.model.Gender;

@Repository
@Transactional
public class ClientDAO extends JdbcDataSource {
	
	@PersistenceContext
    protected EntityManager em;
	
	private Client client;
	
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
	
	public Client findClientbyEmail(String email) {
//    	return em.find(Client.class, email);
		 return this.jdbcTemplate.queryForObject("select client.lastname from client where client.email = ?", new Object[] {email}, new ClientMapper());
//		 return (Client) em.createQuery("select client.lastname from client where client.email = ?")

    }
	
	public void saveClient(Client client) { 
		em.persist(client);
	}

}
