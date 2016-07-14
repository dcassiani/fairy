package br.com.codeslingers.repository;

import javax.enterprise.inject.Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

@Model
@Component
public abstract class AbstractDAO {
 
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
 
//	public HibernateTemplate getHibernateTemplate() {
//		return hibernateTemplate;
//	}
//
//	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//		this.hibernateTemplate = hibernateTemplate;
//	}
//
//	protected HibernateTemplate hibernateTemplate;
//
//	
//    public void persist(Object entity) {
//    	hibernateTemplate.persist(entity);
//    }
// 
//    public void delete(Object entity) {
//    	hibernateTemplate.delete(entity);
//    }
}