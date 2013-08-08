package com.yijava.dao.http;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yijava.common.HttpConstants;
import com.yijava.common.Model;
import com.yijava.web.vo.Channel;
import com.yijava.web.vo.CncNew;
import com.yijava.web.vo.DownBody;
import com.yijava.web.vo.DownBodyNew;
import com.yijava.web.vo.InResult;
import com.yijava.web.vo.UpCloumnMessage;
import com.yijava.web.vo.UpMessage;

@Component
public class BaseHttpUtil {

	private Integer requestTimeout=30000;

	private String baseUri="";

	private static final Logger logger = LoggerFactory.getLogger(BaseHttpUtil.class);
	
	@Autowired
	private ObjectMapper jacksonObjectMapper;

	
	
	public ObjectMapper getObjectMapper() {
		return jacksonObjectMapper;
	}

	public void setObjectMapper(ObjectMapper jacksonObjectMapper) {
		this.jacksonObjectMapper = jacksonObjectMapper;
	}

	
	
	/**
	 * 根据栏目得到新闻
	 * @return
	 */
	public List<CncNew> getAllNewsByChannel(UpCloumnMessage message)
	{
		logger.debug("getAllNewsByChannel");
		try {			
			InResult<DownBodyNew> res = post(HttpConstants.GET_NEW_BYCOLUMN_URI,message, new TypeReference<InResult<DownBodyNew>>() {});
			if(null!=res && res.getHead().getResp_code().equals("000"))
			{						
				return res.getBody().getNews_set();	
			}			
		} catch (IOException e) {
			logger.error("getAllNewsByChannel"+e.toString());
			
		}
		return null;
	}
	/**
	 * 得到所有栏目
	 * @return
	 */
	public List<Channel> getAllChannel()
	{
		try {			
			InResult<DownBody> res = post(HttpConstants.GET_ALLCOLUMN,null, new TypeReference<InResult<DownBody>>() {});
			if(null!=res && res.getHead().getResp_code().equals("000"))
			{						
				return res.getBody().getChannels();	
			}			
		} catch (IOException e) {
			
			logger.error("getAllChannel"+e.toString());
		}
		return null;
	}
	
	/**
	 * 根据省份得到新闻
	 * @return
	 */
	public List<CncNew> getNewsByProvince(UpMessage message){		
		try {			
			InResult<Map<String, List<CncNew>>> res = post(HttpConstants.GET_NEW_BYPROVINCE_URI,message, new TypeReference<InResult<Map<String,List<CncNew>>>>() {});
			if(null!=res && res.getHead().getResp_code().equals("000"))
			{						
				return res.getBody().get("news_set");	
			}			
		} catch (IOException e) {
			
			logger.error("getNewsByProvince"+e.toString());
		}
		return null;
	}
	
	/**
	 * 得到所有省份
	 * @return
	 */
	public List<String> getAllProvince(){
		logger.debug("getAllProvince");
		List<String> provinces=null;
		try {			
			InResult<Map<String, List<Map<String, String>>>> res = post(HttpConstants.GET_PROVINCE_URI,null, new TypeReference<InResult<Map<String,List<Map<String,String>>>>>() {});
			if(null!=res && res.getHead().getResp_code().equals("000"))
			{
				provinces=new ArrayList<String>();
				List<Map<String,String>> list=res.getBody().get("provinces");				
				for(Map<String,String> map:list)
				{
					provinces.add(map.get("province"));					
				}
			}			
		} catch (IOException e) {			
			logger.error("getAllProvince" + e.toString());
		}
		return provinces;
	}
	
	
	protected <T> InResult<T> post(String uri, Object message, TypeReference<InResult<T>> type)
			throws IOException {
		String targetUri = baseUri + uri;
		StringBuilder params = new StringBuilder();
		//Form form = Form.form();
		if (message != null) {
			params.append(jacksonObjectMapper.writeValueAsString(message));				
		}		
		InResult<T> res=null;
		try {
			Content con = Request.Post(targetUri).bodyString(params.toString(), ContentType.create("text/plain", "UTF-8"))
					//.bodyForm(form.build(), Charset.forName("UTF-8"))
					.addHeader("SESSION-ID", "").socketTimeout(requestTimeout)
					.connectTimeout(requestTimeout).execute().returnContent();
			String content = con.asString();
			content=content.trim();
			logger.debug(String.format("url=%s bodystr=%s result=%s ", targetUri,params.toString(),content));
			res = jacksonObjectMapper.readValue(content, type);
			
		} catch (Exception e) {
			logger.error(String.format("url=%s error=%s", targetUri,e.toString()));
		}
		return res;
	}
	
	protected <T> InResult<T> get(String uri, Model model, TypeReference<InResult<T>> type)
			throws IOException {
		String targetUri = baseUri + uri;
		StringBuilder params = new StringBuilder();
		Form form = Form.form();
		if (model != null) {
			for (Map.Entry<String, Object> entry : model.getData().entrySet()) {
				if (entry.getValue() != null) {
					form.add(entry.getKey(), entry.getValue().toString());
					params.append(entry.getKey()).append('=')
							.append(entry.getValue().toString()).append('&');
				}
			}
		}

		Content con = Request.Get(targetUri)
				.bodyForm(form.build(), Charset.forName("UTF-8"))
				.addHeader("SESSION-ID", "").socketTimeout(requestTimeout)
				.connectTimeout(requestTimeout).execute().returnContent();

		String content = con.asString();
		InResult<T> res = jacksonObjectMapper.readValue(content, type);
		return res;
	}
}
