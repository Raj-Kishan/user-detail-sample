package com.sample;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.sample.schemas.Error;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

	@Override
	public Response toResponse(ValidationException exception) {
		Error error = new Error();
		error.setErrorMessage("Required Data Missing");
		error.setErrorCode(Status.BAD_REQUEST.getStatusCode());
		return Response.status(Status.BAD_REQUEST).entity(error).build();
	}

}
