package creditAuto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import creditAuto.config.JdbcDataSource;
import creditAuto.mapper.RateMapper;
import creditAuto.model.Rate;

@Repository
@Transactional
public class RateDAO extends JdbcDataSource {

    @PersistenceContext
    protected EntityManager em;

    protected Session getSession() {
        return em.unwrap(Session.class);
    }

    public void persist(Object entity) {
        em.persist(entity);
    }

    public List<Rate> findAll(){
        return this.jdbcTemplate.query("select * from rate", new RateMapper());
    }
}
