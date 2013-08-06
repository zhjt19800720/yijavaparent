package com.yijava.web.vo;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Test {

	public static void main(String[] args) throws JsonGenerationException,
			JsonMappingException, IOException {
		// TODO Auto-generated method stub

		UpHeader header = new UpHeader("", "", "");

		UpBody body = new UpBody("天津", "10", "1");
		UpMessage message = new UpMessage(header, body);
		ObjectMapper maper = new ObjectMapper();
		System.out.println(maper.writeValueAsString(message));
	}

}
