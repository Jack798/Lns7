<%@ page language="java" contentType="image/png"  pageEncoding="UTF-8"%>
<%@page import="com.Lns7.*"%>
<%@page import="javax.imageio.*"%>
<%@page import="java.awt.image.*"%>
<%@page import="java.io.*"%>

<%
//设置页面不缓存
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
	
String str = request.getParameter("text");
		
BufferedImage bi = ImagesProcessing.write2D(str,280,280);

//bi = utilityHelper.cut(bi, 24, 24, 150, 150);

OutputStream os = response.getOutputStream();

ImageIO.write(bi, "png",os);
os.flush();
os.close();
os=null;
response.flushBuffer();
out.clear();
out = pageContext.pushBody();
%>


