package br.com.codeslingers.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import br.com.codeslingers.beans.PeopleBean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.ClientResponse.Status;

@Controller
@Path("convidado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InvitationResources extends AbstractResources {
	
	private Logger logger = Logger.getLogger(InvitationResources.class);
	
    @GET
    @Path("lista")
    public Response getListarConvidados(@Context Request request) {
    	logger.info("[DEV] getListarConvidados");
    	Gson gsonBuilder = new GsonBuilder().create();
		try {

			
	    	List<PeopleBean> retorno = new ArrayList<PeopleBean>();
	    	
	    	PeopleBean b1 = new PeopleBean();
	    	b1.setIdPessoa(1);
	    	b1.setNome("Fernanda");
	    	retorno.add(b1);
	    	
			return setResponseWithCacheHeaders(Status.OK, gsonBuilder.toJson(retorno), request);
		} catch (Exception e) {
			logger.error("Exception ", e);			
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR, gsonBuilder.toJson(e.getMessage()), request);
		}
    }
    
}
