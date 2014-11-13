package com.Lns7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RightFilter implements Filter {
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
		HttpSession session = req.getSession(true);

		// 从session里取的用户名信息
		String user = (String) session.getAttribute("userid");

		if (user == null || user.equals("")) {
			// 跳转到登陆页面
			String path = ((HttpServletRequest) request).getContextPath();
			String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
			PrintWriter out = res.getWriter();
			out.print("<script type=\"text/javascript\">parent.location.href=\""+ basePath + "index.jsp\"</script>");
		} else {
			
			filterChain.doFilter(request, response);
		}
	
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

}
