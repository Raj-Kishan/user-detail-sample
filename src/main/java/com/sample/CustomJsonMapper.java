//package com.sample;
//
//import javax.ws.rs.ext.ContextResolver;
//import javax.ws.rs.ext.Provider;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.databind.type.TypeFactory;
//import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
//
//@Provider
//public class CustomJsonMapper implements ContextResolver<ObjectMapper> {
//
//	final ObjectMapper defaultObjectMapper;
//
//	public CustomJsonMapper() {
//		defaultObjectMapper = createDefaultMapper();
//	}
//
//	@Override
//	public ObjectMapper getContext(Class<?> type) {
//		return defaultObjectMapper;
//	}
//
//	private static ObjectMapper createDefaultMapper() {
//		final ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
//		mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, true);
//		mapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector(TypeFactory.defaultInstance()));
//		return mapper;
//	}
//}
