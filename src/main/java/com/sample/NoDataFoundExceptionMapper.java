package com.sample;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.sample.exceptions.NoDataFoundException;
import com.sample.schemas.Error;

@Provider
public class NoDataFoundExceptionMapper implements ExceptionMapper<NoDataFoundException> {

	@Override
	public Response toResponse(NoDataFoundException exception) {
		Error error = new Error();
		error.setErrorMessage(exception.getMessage());
		error.setErrorCode(Status.NOT_FOUND.getStatusCode());
		return Response.status(Status.NOT_FOUND).entity(error).build();
	}

}
