package br.com.codeslingers.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import br.com.codeslingers.beans.PeopleBean;

//@RequestScoped
//@Named
public class PeopleDAO { 
	
	private Logger logger = Logger.getLogger(PeopleDAO.class);
//	@PostConstruct
//	public void init() {
//		Logger.getLogger("CDI PeopleDAO injected for Tomcat use.");
//	}
	
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

	
	public List<PeopleBean> list() {
		return list(0, 10000);
	}

	public List<PeopleBean> list(int index, int qtd) {
    	logger.info("peopleDAO.list() checkin");
		Session s = null;
		List<PeopleBean> ret = new ArrayList<PeopleBean>();
		try {
			s = HibernateFactory.getSession();
//			tx = s.beginTransaction();
			ret.addAll(s.createCriteria(PeopleBean.class)
					.setFirstResult(index)
					.setFetchSize(qtd)
					.setMaxResults(qtd)
//					.addOrder(Order.desc("idPerson"))
					.list());
//			tx.commit();
	    } catch (Exception ex) {
	    	logger.error("Exception ", ex);		
//		    if(tx!=null){
//		        tx.rollback();
//		    }
	    }finally{
	    	s.close();
	    }
		return ret;
    }

}
