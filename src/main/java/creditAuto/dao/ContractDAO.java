package creditAuto.dao;

import java.time.LocalDate;
import java.util.Date;
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
import creditAuto.model.Contract;

@Repository
@Transactional
public class ContractDAO extends JdbcDataSource {

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
	
	 public List<Contract> findStatisticsByDate(LocalDate beginingLocalDate, LocalDate endLocalDate ){
//		 System.out.println(this.jdbcTemplate.query("select * from contract where paymentstartdate > ? and < ?",new Object[] {beginingDate, endDate}, new ContractMapper()));
		 
		 Date beginingDate =  java.sql.Date.valueOf(beginingLocalDate);
		 System.out.println("beginingDate " + beginingDate);
		 //Date endDate = java.sql.Date.valueOf(endDate);
		 
	        return this.jdbcTemplate.query("select * from contract where paymentstartdate > ?",new Object[] {beginingDate}, new ContractMapper());
	    }
	
}
