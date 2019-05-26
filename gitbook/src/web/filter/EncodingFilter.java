package web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;


public class EncodingFilter implements Filter {
	@Override
	public void init(FilterConfig config) { }
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
	
		request.setCharacterEncoding("utf-8");
		
		HttpServletRequest myReqest = new MyRequest(request);
	
		response.setContentType("text/html;charset=utf-8");
		chain.doFilter(myReqest, response);
	}
	
	@Override
	public void destroy() {	}
}


class MyRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	private boolean hasEncode;
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	
	public Map getParamterMap() {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("get")) {
			Map<String, String[]> paramterMap = request.getParameterMap();
			if (!hasEncode) { 
				for (String paramterName : paramterMap.keySet()) {
					String[] values = paramterMap.get(paramterName);
					if (values != null) {
						for (int i = 0; i < values.length; i++) {
							try {
								values[i] = new String(values[i].getBytes("ISO-8859-1"), "utf-8");
							}
							catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						}
					}
				}
				hasEncode = true;
			}
			return paramterMap;
		}
		else if (method.equalsIgnoreCase("post")) {
			try {
				request.setCharacterEncoding("utf-8");
				return request.getParameterMap();
			}
			catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		return super.getParameterMap();
	}
	
	public String getParamter(String name) {
		Map<String, String[]> paramterMap = getParameterMap();
		String[] values = paramterMap.get(name);
		if (values != null) {
			return values[0];
		}
		
		return null;
	}
	
	public String[] getParamterValues(String name) {
		Map<String, String[]> paramterMap = getParameterMap();
		String[] values = paramterMap.get(name);
		return values;
	}
}
