package dms.yijava.api.web.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dms.yijava.common.GenericResponseWrapper;

public class JSFilter  implements Filter {  

	private static final Logger logger = LoggerFactory.getLogger(JSFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;  
        HttpServletResponse httpResponse = (HttpServletResponse) response;  
			// TODO Auto-generated method stub
			Map<String, String[]> parms = httpRequest.getParameterMap();
			/*
			 * Check if parameter map contains a "callback" key indicating
			 * a JSONP request is being made.  If parameter map does not contain
			 * a "callback" key, then filter will proceed without wrapping
			 * JSON output with the callback method.
			 */
			if(parms.containsKey("callback")) {
				
			if(logger.isDebugEnabled())
				logger.debug("Wrapping response with JSONP callback '" + parms.get("callback")[0] + "'");
				
			OutputStream out = response.getOutputStream();
				
			GenericResponseWrapper wrapper = new GenericResponseWrapper(httpResponse);
				
			chain.doFilter(httpRequest, wrapper);
				
			out.write(new String(parms.get("callback")[0] + "(").getBytes());
			out.write(wrapper.getData());
			out.write(new String(");").getBytes());
				
			wrapper.setContentType("application/javascript;charset=UTF-8");
				
			out.close();
			} else {
				chain.doFilter(httpRequest, httpResponse);
			}
	
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	

}
