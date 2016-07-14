package br.com.codeslingers.repository;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import br.com.codeslingers.beans.PeopleBean;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;

@Model
public class PeopleDAOImpl 
	extends AbstractDAO 
	implements PeopleDAO { 
	
	private Logger logger = Logger.getLogger(PeopleDAOImpl.class);

//    private SessionFactory sessionFactory;
//    
//    public PeopleDAOImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
	
//	@Override
//	@Transactional 
//	public void save(PeopleBean p) {
//		logger.info("peopleDAO.save() checkin");
//		Session session = this.sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		session.persist(p);
//		tx.commit();
//		session.close();
//		persist(p);
//	}

	@Transactional 
    public List<PeopleBean> list() {
    	logger.info("peopleDAO.list() checkin");
    	try{
    		return  getSession()
    				.createCriteria(PeopleBean.class)
//    				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
    				.list();
    	}catch(Exception ex){ 
    		ex.printStackTrace();    
    		return null;
    	}
    }

//	public Page<PeopleBean> findAll(Pageable pageable) {
//
//		logger.info("peopleDAO.findAll() checkin");
//		return null;
//	}

}
