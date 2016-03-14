package br.com.codeslingers.repository;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractDAO {
 
//	@Autowired
//    private SessionFactory sessionFactory;

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
// 
//    protected Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }
 
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	protected HibernateTemplate hibernateTemplate;

	
    public void persist(Object entity) {
    	hibernateTemplate.persist(entity);
    }
 
    public void delete(Object entity) {
    	hibernateTemplate.delete(entity);
    }
}