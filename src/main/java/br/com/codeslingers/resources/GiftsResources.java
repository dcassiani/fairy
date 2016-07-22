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

import br.com.codeslingers.beans.PeopleBean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.ClientResponse.Status;

@Path("presente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GiftsResources extends AbstractResources {

	private Logger logger = Logger.getLogger(GiftsResources.class);

	@GET
	@Path("lista")
	public Response getGiftList(@Context Request request) {
		logger.info("[DEV] GiftsResources.getGiftList");
		Gson gsonBuilder = new GsonBuilder().create();
		try {

			List<PeopleBean> retorno = new ArrayList<PeopleBean>();

			PeopleBean b1 = new PeopleBean();
			b1.setIdPessoa(1);
			b1.setNome("Fernanda");
			retorno.add(b1);

			return setResponseWithCacheHeaders(Status.OK,
					gsonBuilder.toJson(retorno), request);
		} catch (Exception e) {
			logger.error("Exception ", e);
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR,
					gsonBuilder.toJson(e.getMessage()), request);
		}
	}

	@GET
	@Path("{id}")
	public Response getProduct(@PathParam(value = "id") Integer idProduct,
			@Context Request request) {
		logger.info("[DEV] GiftsResources.getProduct " + idProduct);
		Gson gsonBuilder = new GsonBuilder().create();
		try {

			List<PeopleBean> retorno = new ArrayList<PeopleBean>();

			PeopleBean b1 = new PeopleBean();
			b1.setIdPessoa(1);
			b1.setNome("Fernanda");
			retorno.add(b1);

			return setResponseWithCacheHeaders(Status.OK,
					gsonBuilder.toJson(retorno), request);
		} catch (Exception e) {
			logger.error("Exception ", e);
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR,
					gsonBuilder.toJson(e.getMessage()), request);
		}
	}

	@GET
	@Path("desejos/{id}")
	public Response getBestWish(@PathParam(value = "id") Integer idBestWish, 
			@Context Request request) {
		logger.info("[DEV] GiftsResources.getBestWish " + idBestWish);
		Gson gsonBuilder = new GsonBuilder().create();
		try {

			List<PeopleBean> retorno = new ArrayList<PeopleBean>();

			PeopleBean b1 = new PeopleBean();
			b1.setIdPessoa(1);
			b1.setNome("Fernanda");
			retorno.add(b1);

			return setResponseWithCacheHeaders(Status.OK,
					gsonBuilder.toJson(retorno), request);
		} catch (Exception e) {
			logger.error("Exception ", e);
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR,
					gsonBuilder.toJson(e.getMessage()), request);
		}
	}

	@GET
	@Path("desejos/lista")
	public Response getBestWishesList(@Context Request request) {
		logger.info("[DEV] GiftsResources.getBestWishesList");
		Gson gsonBuilder = new GsonBuilder().create();
		try {

			List<PeopleBean> retorno = new ArrayList<PeopleBean>();

			PeopleBean b1 = new PeopleBean();
			b1.setIdPessoa(1);
			b1.setNome("Fernanda");
			retorno.add(b1);

			return setResponseWithCacheHeaders(Status.OK,
					gsonBuilder.toJson(retorno), request);
		} catch (Exception e) {
			logger.error("Exception ", e);
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR,
					gsonBuilder.toJson(e.getMessage()), request);
		}
	}
}
