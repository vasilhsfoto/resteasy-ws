package com.vassilis.restresources;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.vassilis.model.User;

/**
 * stand alone deployment: 
 * 1. Using JAX-RS's Jboss RestEasy
 * 2. jackson marshal/unmarshal Json
 * No DI used in correlation with JAX-RS
 * @author delk
 */
	
@Path("/users")
public class UserResource {
	
	@GET
	@Produces("application/json")
	public Response getUser(@QueryParam("username") String username, @QueryParam("age") int age) {
		User user = new User(username, "fixed", age);
		
		return Response.status(200).entity(user).build();
	}
	
	@POST
	@Path("/add")
	@Produces("application/json")
	public Response addUser(@FormParam("username") String username, @FormParam("age") int age) {
		User newUser = new User("fixed address", username, age);
		
		return Response.status(200).entity(newUser).build();
	}
}
