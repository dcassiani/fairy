package br.com.codeslingers.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.codeslingers.beans.AbstractSelectOption;
import br.com.codeslingers.beans.ContentBean;
import br.com.codeslingers.beans.content.TemplateBean;

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

	@Transactional
	public Integer save(TemplateBean tp) {
		logger.info("ContentFactoryDAO.save() checkin");
		Session s = null;
		try {
			s = HibernateFactory.getSession();
			s.beginTransaction();
			s.save(tp);
			s.getTransaction().commit();
	    } catch (Exception ex) {
	    	logger.error("Exception ", ex);
	    	s.flush();
	    }finally{
	    	s.close();
	    }
		return tp.getIdTemplate();
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

	public List<AbstractSelectOption> getOptionListTemplates() {
	   	logger.info("ContentFactoryDAO.getOptionListTemplates() checkin");
			Session s = null;
			List<TemplateBean> ret = new ArrayList<TemplateBean>();
			try {
				s = HibernateFactory.getSession();
				ret.addAll(s.createCriteria(TemplateBean.class)
//						.setFirstResult(0)
//						.setFetchSize(qtd)
//						.setMaxResults(qtd)
						.addOrder(Order.asc("templateType"))
						.list());
		    } catch (Exception ex) {
		    	logger.error("Exception ", ex);		
		    }finally{
		    	s.close();
		    }
			return mapFromTemplates(ret);
	}
	
	private List<AbstractSelectOption> mapFromTemplates( List<TemplateBean> list) {
		List<AbstractSelectOption> retorno = new ArrayList<AbstractSelectOption>();
		for (TemplateBean vo: list){
			retorno.add(new AbstractSelectOption(vo.getTemplateType(), 
					vo.getIdTemplate().toString()));
		}
		return retorno;
	}

}
