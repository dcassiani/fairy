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

import br.com.codeslingers.beans.MenuLink;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.ClientResponse.Status;

@Controller
@Path("menu")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MenuResources extends AbstractResources {

	private Logger logger = Logger.getLogger(MenuResources.class);

	@GET
	@Path("main")
	public Response getMainMenu(@Context Request request) {
		logger.info("[DEV] MenuResources.getMainMenu");
		Gson gsonBuilder = new GsonBuilder().create();
		try {
			
			//TODO testar login e obter menu personalizado

			List<MenuLink> submenuCelebArr = new ArrayList<MenuLink>();
			submenuCelebArr.add(new MenuLink( "Local da Cerimônia", "#", "room"));  
			submenuCelebArr.add(new MenuLink( "Confirmar Presença", "#", "assignment turned in")); 

			List<MenuLink> submenuTalesArr = new ArrayList<MenuLink>(); 
			submenuTalesArr.add(new MenuLink( "Primeiro Beijo", "#", "favorite_border")); 
			submenuTalesArr.add(new MenuLink( "Sapatinho de Cristal", "#", "loyalty")); 
			submenuTalesArr.add(new MenuLink( "Amados Pais", "#", "account_circle"));
			submenuTalesArr.add(new MenuLink( "Padrinhos", "#", "face"));
			submenuTalesArr.add(new MenuLink( "Doces Lembranças", "#", "class")); 
			 	
			List<MenuLink> retorno = new ArrayList<MenuLink>();
			retorno.add(new MenuLink( "Era uma vez...", "#", "favorite"));
			retorno.add(new MenuLink( "Celebração", "#", "account_balance", submenuCelebArr));  
			retorno.add(new MenuLink( "Conto de Fadas", "#", "local_movies", submenuTalesArr)); 
			retorno.add(new MenuLink( "Presentes", "#", "card_giftcard"));

			return setResponseWithCacheHeaders(Status.OK,
					gsonBuilder.toJson(retorno), request);
			
		} catch (Exception e) {
			logger.error("Exception ", e);
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR,
					gsonBuilder.toJson(e.getMessage()), request);
		}
	}

}
