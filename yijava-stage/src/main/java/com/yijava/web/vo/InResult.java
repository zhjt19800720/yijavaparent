package com.yijava.web.vo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class InResult <T>{

	private Header head;
	
	private T body;
	
	
	
	public Header getHead() {
		return head;
	}

	public void setHead(Header head) {
		this.head = head;
	}
	
	

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String json="{\"head\":{\"resp_msg\":\"查询省份列表接口\",\"resp_code\":\"000\"},\"body\":{\"provinces\":[{\"province\":\"北京\"},{\"province\":\"天津\"},{\"province\":\"河北\"},{\"province\":\"山西\"}]}}";
		//String json = "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}";  
		InResult  result=objectMapper.readValue(json,new TypeReference<InResult<Map<String,List<Map<String,String>>>>>(){});
			
		System.out.println("dd");
	}
	
}
