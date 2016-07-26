package br.com.codeslingers.resources;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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

@Path("convidado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResources extends AbstractResources {
	
	private Logger logger = Logger.getLogger(PeopleResources.class);
	
//	@Inject
//	PeopleDAO peopleDAO;



    
    @GET
    @Path("lista")
    public Response getListarConvidados(@Context Request request) {
    	logger.info("[DEV] br.com.codeslingers.resources getListarConvidados");
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
			
//	    	List<PeopleBean> retorno = new ArrayList<PeopleBean>();
//	    	
//	    	PeopleBean b1 = new PeopleBean();
//	    	b1.setIdPessoa(1);
//	    	b1.setNome("Fernanda");
//	    	retorno.add(b1);
	    	
//	    	retorno.addAll(peopleDAO.list());
	    	
	    	javax.naming.Context ctx = null;
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
//			try{
				ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/fairydb");
				
				con = ds.getConnection();
				stmt = con.createStatement();
				
				rs = stmt.executeQuery("select idPerson, nome from tb_pessoa");
				
				List<PeopleBean> retorno = new ArrayList<PeopleBean>();
	            while(rs.next()) {
	            	PeopleBean b1 = new PeopleBean();
	    	    	b1.setIdPessoa(rs.getInt("idPerson"));
	    	    	b1.setNome(rs.getString("nome"));
	    	    	retorno.add(b1);
	            }
	    			
			return setResponseWithCacheHeaders(Status.OK, gsonBuilder.toJson(retorno), request);
		} catch (Exception e) {
			logger.error("Exception ", e);			
			return setResponseWithCacheHeaders(Status.INTERNAL_SERVER_ERROR, gsonBuilder.toJson(e.getMessage()), request);
		}
    }
    
}
