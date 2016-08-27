package br.com.codeslingers.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import org.apache.log4j.Logger;

import br.com.codeslingers.beans.ContentBean;
import br.com.codeslingers.beans.content.TemplateBean;
import br.com.codeslingers.repository.ContentFactoryDAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.ClientResponse.Status;

@Path("adm")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminResources extends AbstractResources {
	
	private Logger logger = Logger.getLogger(AdminResources.class);
	
	private ContentFactoryDAO contentFactoryDAO = new ContentFactoryDAO();
	
    @PUT
    @Path("inserir/{numero}")
    public Response setContent(@PathParam(value = "numero") Integer n, @Context Request request) {
    	logger.info("[DEV] AdminResources.setContent");

		try {

			ContentBean p = new ContentBean();
			
			p.setTitle("title");
			p.setIdContent(n);
			p.setOwner("owner");
			p.setIsPublished('Y');
			
			TemplateBean t = new TemplateBean();
			t.setIsPublished('Y');
			t.setLayoutInclude("layoutInclude");
			t.setQtImg(n);
			t.setQtText(n);
			t.setTemplateType("templateTyp");
			
			p.setTemplate(t );
			
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



}
