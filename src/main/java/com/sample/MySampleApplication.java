package com.sample;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/*")
public class MySampleApplication extends ResourceConfig {

	public MySampleApplication() {
		register(JacksonFeature.class)
		.register(CustomContextListener.class)
		.register(NoDataFoundExceptionMapper.class)
		.register(ValidationExceptionMapper.class);
		
		packages("com.sample", "com.sample.schemas");
	}
}
