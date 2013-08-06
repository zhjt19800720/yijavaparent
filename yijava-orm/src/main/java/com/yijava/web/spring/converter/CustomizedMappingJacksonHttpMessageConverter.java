package com.yijava.web.spring.converter;

import java.io.IOException;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

public class CustomizedMappingJacksonHttpMessageConverter extends MappingJacksonHttpMessageConverter{

	@Override
	protected void writeInternal(Object result, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		// TODO Auto-generated method stub
		super.writeInternal(result, outputMessage);
	} 

	
}

