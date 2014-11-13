package com.Lns7;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class webFilter implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig filterConfig = null;
	private String encoding = null;

	public void destroy() {
		filterConfig = null;
		encoding = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		
		req.setCharacterEncoding(encoding);
		res.setCharacterEncoding(encoding);
		res.setContentType("text/html;charset="+encoding);

		res.setHeader("Cache-Control", "no-cache");
		res.setHeader("X-UA-Compatible", "IE=edge");
		res.setHeader("Pragma", "no-cache");
		res.setDateHeader("Expires", -1);
		
		
		
		filterChain.doFilter(request, response);

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

}
