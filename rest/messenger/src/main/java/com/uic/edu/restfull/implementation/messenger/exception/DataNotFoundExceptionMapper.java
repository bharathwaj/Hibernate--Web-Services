package com.uic.edu.restfull.implementation.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.uic.edu.restfull.implementation.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),
				"https://www.youtube.com/watch?v=9oeJc_VkZxo&index=27&list=PLqq-6Pq4lTTZh5U8RbdXq0WaYvZBz2rbn", 404);
			
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
