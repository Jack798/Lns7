package com.Lns7;

import com.alibaba.appengine.api.fetchurl.FetchUrlService;
import com.alibaba.appengine.api.fetchurl.FetchUrlServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FetchUrlServiceDemo extends HttpServlet{
    private static final long serialVersionUID = -2359366324351384788L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Begin fetchurl service test.");
        FetchUrlService fetchUrlService = FetchUrlServiceFactory.getFetchUrlService();

        final String url = "http://www.taobao.com";
        String body = fetchUrlService.get(url);
        resp.getWriter().printf("Fetch text from url %s: %s...\n", url, body.substring(0, 256));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FetchUrlService fetchUrlService = FetchUrlServiceFactory.getFetchUrlService();
		String url = "http://www.taobao.com";
		String body = fetchUrlService.get(url);
		System.out.println(body);

	}

}
