package creditAuto.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import creditAuto.config.JdbcDataSource;
import creditAuto.mapper.ContractAndClientMapExtractor;
import creditAuto.mapper.ContractMapper;
import creditAuto.model.Client;
import creditAuto.model.Contract;
import creditAuto.model.Gender;

@Repository
@Transactional
public class ContractDAO extends JdbcDataSource {

	@PersistenceContext
    protected EntityManager em;
	
	private Client client;

    protected Session getSession() {
        return em.unwrap(Session.class);
    }

    public void persist(Object entity) {
        em.persist(entity);
    }

    public List<Contract> findAll(){
        return this.jdbcTemplate.query("select * from contract", new ContractMapper());
    }

	public Map<Integer, Contract> findByClientId(Long long1) {
		return this.jdbcTemplate.query("select * from contract join client on contract.client_id = client.id where contract.client_id = ?",new Object[] {long1}, new ContractAndClientMapExtractor());
	}
	
	public void createClient(String firstName, String lastName, String adress, String email, String birthDate, Gender gender) { 
		client= new Client(firstName, lastName, adress, email, birthDate, gender);
		em.persist(client);
	}
}
