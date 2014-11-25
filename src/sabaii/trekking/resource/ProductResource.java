package sabaii.trekking.resource;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import memory.BusMemoryCache;

import org.eclipse.jetty.http.HttpHeader;

import sabaii.trekking.entity.Bus;

@Path("/products")
public class ProductResource {
	private BusMemoryCache cache = BusMemoryCache.getInstance(null);
	
	@Context
	UriInfo uriInfo;

//	@GET
//	@Path("{id}")
//	public Response getProductByID(@PathParam("id") String id, @HeaderParam ("If-None-Match") String none_match, @HeaderParam ("If-Match") String match)
//	{
//		Bus p = dao.find(Long.parseLong(id));
//		if (p==null)
//			return Response.status(Status.NOT_FOUND).build();
//		if (none_match != null && none_match.equals("\""+p.hashCode()+"\"") || match != null && !match.equals("\""+p.hashCode()+"\""))
//			return Response.status(Status.NOT_MODIFIED).build();
//		
//		return Response.ok(p).tag(new EntityTag(p.hashCode()+"")).build();
//	}

	@GET
	@Produces (MediaType.APPLICATION_XML)
	public Response getProducts()
	{
		GenericEntity<List<Bus>> entity;
		entity = new GenericEntity<List<Bus>>(cache.findAll()) {};
		System.out.println(entity.toString());
		return Response.ok(entity).build();
	}

}