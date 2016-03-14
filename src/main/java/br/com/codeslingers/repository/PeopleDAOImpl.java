package br.com.codeslingers.repository;

import java.util.List;

import org.apache.log4j.Logger;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.codeslingers.beans.PeopleBean;

@Component(value="peopleDAO")
public class PeopleDAOImpl extends AbstractDAO implements PeopleDAO { 
	// PagingAndSortingRepository<PeopleBean, Integer>

//	private HibernateTemplate hibernateTemplate;
	
	private Logger logger = Logger.getLogger(PeopleDAOImpl.class);

//	
//	private SessionFactory sessionFactory;
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
//	}

	@Override
	@Transactional 
	public void save(PeopleBean p) {
		logger.info("peopleDAO.save() checkin");
//		Session session = this.sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		session.persist(p);
//		tx.commit();
//		session.close();
		persist(p);
	}

	@Override
    public List<PeopleBean> list() {
    	logger.info("peopleDAO.list() checkin");
    	try{
//    		Session session = this.sessionFactory.openSession();
//	        List<PeopleBean> personList = session.createQuery("from PeopleBean").list();
//	        session.close();
//	        return personList;
//    		Criteria criteria = getSession().createCriteria(PeopleBean.class);
//            return (List<PeopleBean>) criteria.list();
    		return hibernateTemplate.loadAll(PeopleBean.class);
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
