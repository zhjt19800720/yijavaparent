package com.yijava.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class JacksonObjectMapperFactory implements FactoryBean<ObjectMapper> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private ObjectMapper objectMapper;

	@Override
	public ObjectMapper getObject() throws Exception {
		if (objectMapper != null) {

			return objectMapper;
		}

		objectMapper = new ObjectMapper();
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,false);
		objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER,true);
		objectMapper.configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT,false);
		 
		
		objectMapper.disable(SerializationFeature.WRITE_NULL_MAP_VALUES);
		
		
		
	    objectMapper.setSerializationInclusion(Include.NON_NULL);
	        //objectMapper.sets
        
		objectMapper.registerModule(new Hibernate4Module());

		return objectMapper;
	}

	@Override
	public Class<?> getObjectType() {
		return ObjectMapper.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
