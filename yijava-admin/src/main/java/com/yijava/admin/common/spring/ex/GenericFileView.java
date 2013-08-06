package com.yijava.admin.common.spring.ex;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractUrlBasedView;

public class GenericFileView extends AbstractUrlBasedView {

	// default content type  
    private final static String CONTENT_TYPE = "text/plain";  
    
    //content of http response  
    private String responseContent;
    
    
    
	@Override
	public void setContentType(String contentType) {
		// TODO Auto-generated method stub
		super.setContentType(contentType);
	}


	public void setResponseContent(String responseContent) {  
        this.responseContent = responseContent;  
    }  



	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		response.setContentType(getContentType());  
        response.getWriter().write(this.responseContent);  
        response.getWriter().close();  
	}
	
	
	

	
}
