package br.com.codeslingers.resources;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.api.client.ClientResponse.Status;

public abstract class AbstractResources {

	protected Response setResponseWithCacheHeaders(Status status, String ret, Request request){

	    CacheControl cc = new CacheControl();
	    cc.setMaxAge(-1); 		// forever, so browser will use his version unless ETag hash changes 
	    cc.setPrivate(true);	// this browser only
	    cc.setNoStore(true);	// this browser RAM only
	    EntityTag etag = new EntityTag(Integer.toString(ret.hashCode()));
	    ResponseBuilder builder = request.evaluatePreconditions(etag);

	    if (builder == null){
		    if (Status.OK.equals(status)){
		    	builder = Response.ok(ret);
		    } else {
		    	builder = Response.status(status);
		    }
		    builder.tag(etag);
	    } else {
	    	builder = Response.notModified(etag);
	    }
	    
	    builder.cacheControl(cc);
	    return builder.build();
	}
}