package br.com.codeslingers.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.codeslingers.beans.ContentBean;

public class ContentFactoryDAO { 
	
	private Logger logger = Logger.getLogger(ContentFactoryDAO.class);

	@Transactional
	public void save(ContentBean p) {
		logger.info("ContentFactoryDAO.save() checkin");
		Session s = null;
		try {
			s = HibernateFactory.getSession();
			s.beginTransaction();
			s.save(p);
			s.getTransaction().commit();
	    } catch (Exception ex) {
	    	logger.error("Exception ", ex);
	    	s.flush();
	    }finally{
	    	s.close();
	    }
	}

	
	public List<ContentBean> list() {
		return list(0, 10000);
	}

	public List<ContentBean> list(int index, int qtd) {
    	logger.info("ContentFactoryDAO.list() checkin");
		Session s = null;
		List<ContentBean> ret = new ArrayList<ContentBean>();
		try {
			s = HibernateFactory.getSession();
			ret = s.createCriteria(ContentBean.class)
					.setFirstResult(index)
					.setFetchSize(qtd)
					.setMaxResults(qtd)
//					.addOrder(Order.desc("idPerson"))
					.list();
	    } catch (Exception ex) {
	    	logger.error("Exception ", ex);		
	    }finally{
	    	s.close();
	    }
		return ret;
    }

}
