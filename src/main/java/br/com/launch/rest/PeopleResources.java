package br.com.launch.rest;

import java.util.ArrayList;
import java.util.List;

//import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import br.com.launch.bean.AbstractSelectOption;
import br.com.launch.bean.PeopleBean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Controller;
//
//import br.com.codeslingers.beans.PeopleBean;
//import br.com.codeslingers.repository.PeopleDAO;
import com.sun.jersey.api.client.ClientResponse.Status;

//@Controller
@Path("convidado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResources extends AbstractResources {
	
//	private Logger logger = Logger.getLogger(PeopleResources.class);
	
//	@Inject
//	PeopleDAO peopleDAO;

	
    @GET
    @Path("/{id}")
    public Response getPerson ( @PathParam(value = "id") String name, @Context Request request) {
//    	logger.info("[DEV] InvitationResources.setGuestConfirmation");
    	Gson gsonBuilder = new GsonBuilder().create();
		try {
			
	    	PeopleBean b1 = new PeopleBean();
	    	b1.setAge(32);
	    	b1.setName(name);
	    	b1.setCountry("Brasil");
	    	b1.setPicturePath("/img/pi1.jpg");

	    	
			return setResponseWithCacheHeaders(Status.OK, gsonBuilder.toJson(b1), request);
		} catch (Exception e) {
//			logger.error("Exception ", e);			
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR, gsonBuilder.toJson(e.getMessage()), request);
		}
    }

    
    @GET
    @Path("lista")
    public Response getListarConvidados(@Context Request request) {
//    	logger.info("[DEV] getListarConvidados");
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
			
	    	List<AbstractSelectOption> retorno = new ArrayList<AbstractSelectOption>();
	    	retorno.add(new AbstractSelectOption("Fernanda"));
	    	retorno.add(new AbstractSelectOption("Daniel"));
	    	retorno.add(new AbstractSelectOption("Raquel"));
	    	retorno.add(new AbstractSelectOption("Thiago"));
//	    	PeopleBean b1 = new PeopleBean();
//	    	b1.setIdPessoa(1);
//	    	b1.setNome("Fernanda");
//	    	retorno.add(b1);
//	    	
//	    	retorno.addAll(peopleDAO.list());
	    			
			return setResponseWithCacheHeaders(Status.OK, gsonBuilder.toJson(retorno), request);
		} catch (Exception e) {
//			logger.error("Exception ", e);			
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR, gsonBuilder.toJson(e.getMessage()), request);
		}
    }
    
}
