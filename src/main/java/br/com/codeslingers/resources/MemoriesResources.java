package br.com.codeslingers.resources;

import java.util.ArrayList;
import java.util.List;

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

import br.com.codeslingers.beans.MemoryBean;
import br.com.codeslingers.beans.PeopleBean;
import br.com.codeslingers.beans.enums.MemoryTypeEnum;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.ClientResponse.Status;

@Path("memorias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MemoriesResources extends AbstractResources {
	
	private Logger logger = Logger.getLogger(MemoriesResources.class);
	
    @GET
    @Path("tinder")
    public Response getHowItAllBegan(@Context Request request) {
    	logger.info("[DEV] MemoriesResources.getHowItAllBegan");
    	Gson gsonBuilder = new GsonBuilder().create();
		try {

			MemoryBean b1 = new MemoryBean();
			b1.setMemoryType(MemoryTypeEnum.howItAllBegan);
			b1.setDescription("Era uma vez");
			b1.setTitle("Tinder");
			b1.setIdMemory(1);
	    	
			return setResponseWithCacheHeaders(Status.OK, gsonBuilder.toJson(b1), request);
		} catch (Exception e) {
			logger.error("Exception ", e);			
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR, gsonBuilder.toJson(e.getMessage()), request);
		}
    }
    
    @GET
    @Path("pe/de/manga")
    public Response getFirstLoveMeeting(@Context Request request) {
    	logger.info("[DEV] MemoriesResources.getFirstLoveMeeting");
    	Gson gsonBuilder = new GsonBuilder().create();
		try {

			MemoryBean b1 = new MemoryBean();
			b1.setMemoryType(MemoryTypeEnum.firstLoveMeeting);
			b1.setDescription("Era uma vez");
			b1.setTitle("Pé de Manga");
			b1.setIdMemory(2);
	    	
			return setResponseWithCacheHeaders(Status.OK, gsonBuilder.toJson(b1), request);
		} catch (Exception e) {
			logger.error("Exception ", e);			
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR, gsonBuilder.toJson(e.getMessage()), request);
		}
    }
    
    @GET
    @Path("lista")
    public Response getHistoryMoments(@Context Request request) {
    	logger.info("[DEV] MemoriesResources.getHistoryMoments");
    	Gson gsonBuilder = new GsonBuilder().create();
		try {
			MemoryBean b1 = new MemoryBean();
			b1.setMemoryType(MemoryTypeEnum.moment);
			b1.setDescription("Era uma vez");
			b1.setTitle("trocar para lista");
			b1.setIdMemory(1);
	    	
			return setResponseWithCacheHeaders(Status.OK, gsonBuilder.toJson(b1), request);
		} catch (Exception e) {
			logger.error("Exception ", e);			
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR, gsonBuilder.toJson(e.getMessage()), request);
		}
    }

    @GET
    @Path("{id}")
    public Response getHistoryMoment(@PathParam(value = "id") Integer idMemory, 
    		@Context Request request) {
    	logger.info("[DEV] MemoriesResources.getHistoryMoments: " + idMemory);
    	Gson gsonBuilder = new GsonBuilder().create();
		try {

			MemoryBean b1 = new MemoryBean();
			b1.setMemoryType(MemoryTypeEnum.moment);
			b1.setDescription("Era uma vez");
			b1.setTitle("Campos");
			b1.setIdMemory(idMemory);
	    	
			return setResponseWithCacheHeaders(Status.OK, gsonBuilder.toJson(b1), request);
		} catch (Exception e) {
			logger.error("Exception ", e);			
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR, gsonBuilder.toJson(e.getMessage()), request);
		}
    }

    
    @GET
    @Path("janelinha")
    public Response getEngagementDay(@Context Request request) {
    	logger.info("[DEV] MemoriesResources.getEngagementDay");
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
