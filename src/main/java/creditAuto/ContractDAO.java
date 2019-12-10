package creditAuto;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ContractDAO extends JdbcRepository {

	@PersistenceContext
    protected EntityManager em;

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
}
