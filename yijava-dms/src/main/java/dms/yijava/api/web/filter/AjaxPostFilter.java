package dms.yijava.api.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxPostFilter implements Filter {

	private static final String IE_CONTENT_TYPE = "application/x-www-form-urlencoded";
	private static final String FF_AJAX_CONTENT_TYPE = "application/x-www-form-urlencoded; charset=UTF-8";
	private static final String XMLHTTP_REQUEST = "XMLHttpRequest";
	private static final String AJAX_CHARACTER_ENCODING_UTF8 = "UTF-8";

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;  
       String aaa=httpRequest.getParameter("name");
       System.out.println(new String (aaa.getBytes("ISO8859-1"),"UTF-8"));
		System.out.println(httpRequest.getParameter("name"));
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String requestedWith = request.getHeader("x-requested-with");
		String type = request.getContentType();
		if (XMLHTTP_REQUEST.equals(requestedWith)
				&& (FF_AJAX_CONTENT_TYPE.equals(type) || IE_CONTENT_TYPE
						.equals(type))) {
			request.setCharacterEncoding(AJAX_CHARACTER_ENCODING_UTF8);
			response.setCharacterEncoding(AJAX_CHARACTER_ENCODING_UTF8);
			// request.getParameterMap();
		}
		filterChain.doFilter(request, response);

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
