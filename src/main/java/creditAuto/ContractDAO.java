package creditAuto;

import java.util.List;

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

	public List<Contract> findByClientId(Long long1) {
		return this.jdbcTemplate.query("select * from contract where client_id = ?",new Object[] {long1}, new ContractMapper());
	}
}
