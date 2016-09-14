package br.com.codeslingers.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.ClientResponse.Status;

import br.com.codeslingers.beans.AbstractSelectOption;
import br.com.codeslingers.beans.ContentBean;
import br.com.codeslingers.beans.content.TemplateBean;
import br.com.codeslingers.repository.ContentFactoryDAO;
import br.com.codeslingers.resources.AbstractResources;

@Path("adm")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminResources extends AbstractResources {
	
	private Logger logger = Logger.getLogger(AdminResources.class);
	
	private ContentFactoryDAO contentFactoryDAO = new ContentFactoryDAO();
	
    @PUT
    @Path("inserir/{idTemplate}")
    public Response setContent(@PathParam(value = "idTemplate") Integer idTemplate, @Context Request request) {
    	logger.info("[DEV] AdminResources.setContent");

		try {

			ContentBean p = new ContentBean();
			
			p.setTitle("title");
			p.setIdContent(null);
			p.setOwner("owner");
			p.setIsPublished('Y');
			p.setIdTemplate(idTemplate);
			
			contentFactoryDAO.save(p);
	    	
			return setResponse(Status.OK, request) ;
		} catch (Exception e) {
			logger.error("Exception ", e);
			return setResponse(Status.INTERNAL_SERVER_ERROR, request);
		}
    }
    
    @GET
    @Path("lista")
    public Response getListarContent(@Context Request request) {
    	logger.info("[DEV] AdminResources getListarContent");
    	Gson gsonBuilder = new GsonBuilder().create();
    	List<ContentBean> retorno = new ArrayList<ContentBean>();
    	
		try {
			retorno = contentFactoryDAO.list();
			return setResponseWithCacheHeaders(Status.OK, gsonBuilder.toJson(retorno), request);
		} catch (Exception e) {
			logger.error("Exception ", e);			
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR, gsonBuilder.toJson(e.getMessage()), request);
		}
    }



    
    @POST
    @Path("template/new")
    public Response createTemplate(String data, @Context Request request) {
    	logger.info("[DEV] AdminResources.createTemplate");

		try {
			Gson gson = new Gson();
			TemplateBean t = gson.fromJson(data, TemplateBean.class);
			t.setIsPublished('Y');
			
			Integer result = contentFactoryDAO.save(t);
	    	
			logger.info("[DEV] AdminResources.createTemplate with id: " + result);
			return Response.status(Status.OK).entity(gson.toJson(result)).build();
		} catch (Exception e) {
			logger.error("Exception ", e);
			return setResponse(Status.INTERNAL_SERVER_ERROR, request);
		}
    }
    
    @GET
    @Path("template/options")
    public Response getOptionListTemplates(@Context Request request) {
    	logger.info("[DEV] AdminResources getListarContent");
    	Gson gsonBuilder = new GsonBuilder().create();
    	List<AbstractSelectOption> retorno = new ArrayList<AbstractSelectOption>();
    	
		try {
			retorno = contentFactoryDAO.getOptionListTemplates();
			return setResponseWithCacheHeaders(Status.OK, gsonBuilder.toJson(retorno), request);
		} catch (Exception e) {
			logger.error("Exception ", e);			
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR, gsonBuilder.toJson(e.getMessage()), request);
		}
    }
    
}
