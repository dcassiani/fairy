package br.com.codeslingers.resources;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import br.com.codeslingers.beans.AbstractSelectOption;
import br.com.codeslingers.beans.PeopleBean;
import br.com.codeslingers.hibernate.HibernateUtil;
import br.com.codeslingers.repository.PeopleDAOImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.ClientResponse.Status;

@Path("person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResources extends AbstractResources {
	
	private Logger logger = Logger.getLogger(PersonResources.class);
	
	@Inject @Any
	@Named("peopleDAO")	
	private PeopleDAOImpl peopleDAO;

	
    @GET
    @Path("/{id}")
    public Response getPerson ( @PathParam(value = "id") String name, @Context Request request) {
//    	logger.info("[DEV] InvitationResources.setGuestConfirmation");
    	Gson gsonBuilder = new GsonBuilder().create();
		try {
			
	    	PeopleBean b1 = new PeopleBean();
	    	b1.setNome(name);
	    	b1.setIdPessoa(2);

	    	
			return setResponseWithCacheHeaders(Status.OK, gsonBuilder.toJson(b1), request);
		} catch (Exception e) {
//			logger.error("Exception ", e);			
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR, gsonBuilder.toJson(e.getMessage()), request);
		}
    }

    
    @GET
    @Path("lista")
    public Response getListarConvidados(@Context Request request) {
    	logger.info("[DEV] br.com.launch.rest getListarConvidados");
    	Gson gsonBuilder = new GsonBuilder().create();
		try {

//			UserDTO user = recentPurchaseBusiness.getUser(username);
//			if (user == null) {
//				logger.info(" GET /recent_purchases/"+ username +" ENDED - NOT SUCH USER");
//				return setResponseWithCacheHeaders(Status.OK, gsonBuilder
//						.toJson(USER_NOT_FOUND.replace("{username}", username)), request);
//			}
//
//			List<RecentPurchaseDTO> ret = recentPurchaseBusiness
//					.getRecentPurchaseList(user);

//			int page = 1;
//		    int pageSize = 10;
//		    Pageable pageable = new PageRequest(page, pageSize);
//		    
//			peopleDAO.findAll(pageable);
			
//	    	List<AbstractSelectOption> retorno = new ArrayList<AbstractSelectOption>();
//	    	retorno.add(new AbstractSelectOption("Fernanda"));
//	    	retorno.add(new AbstractSelectOption("Daniel"));
//	    	retorno.add(new AbstractSelectOption("Raquel"));
//	    	retorno.add(new AbstractSelectOption("Thiago"));

//	    	
			Session session = null;
			if (HibernateUtil.getSessionFactory().isClosed()){
				session = HibernateUtil.getSessionFactory().openSession();
			} else {
				session = HibernateUtil.getSessionFactory().getCurrentSession();
			}
			
			session.beginTransaction();
//			
	    	List<AbstractSelectOption> retorno = mapFromPeople(session.createCriteria(PeopleBean.class).list());
//	    	tx.commit();
			return setResponseWithCacheHeaders(Status.OK, gsonBuilder.toJson(retorno), request);
		} catch (Exception e) {
			logger.error("Exception ", e);			
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR, gsonBuilder.toJson(e.getMessage()), request);
		}
    }


	private List<AbstractSelectOption> mapFromPeople(
			List<PeopleBean> list) {

		List<AbstractSelectOption> retorno = new ArrayList<AbstractSelectOption>();
		
		for (PeopleBean vo: list){
			retorno.add(new AbstractSelectOption(vo.getNome()));
		}

		return retorno;
	}
    
}
