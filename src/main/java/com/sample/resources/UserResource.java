package com.sample.resources;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.schemas.User;
import com.sample.services.UserService;
import com.sample.services.UserServiceImpl;

@Path("/user")
public class UserResource {

	private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);

	@Path("/{name}")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getUser(@PathParam("name") String username) {
		LOG.info("Get User By Username is requested");
		UserService userService = new UserServiceImpl();
		return Response.ok(userService.getUser(username)).build();
	}

	@Path("/all")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public com.sample.schemas.Users getAllUsers() {
		LOG.info("Get All Users requested");
		UserService userService = new UserServiceImpl();
		return userService.getAllUsers();
	}

	@Path("/create")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response createUser(@Valid User user) {
		LOG.info("Create user requested");
		UserService userService = new UserServiceImpl();
		return Response.ok(userService.createUser(user)).build();
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public User deleteUser(@PathParam("id") String id) {
		LOG.info("Delete user requested");
		UserService userService = new UserServiceImpl();
		return userService.deleteUser(id);
	}

	@Path("/update")
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public User updateUser(User user) {
		LOG.info("Update user requested");
		if(user.getUserId() == null) {
			throw new ValidationException();
		}
		UserService userService = new UserServiceImpl();
		return userService.updateUser(user);
	}
}
