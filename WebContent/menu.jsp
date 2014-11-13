<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

 <span style="font-size: 20pt;font-family:微软雅黑,Arial;">
 	  <a href="<%=basePath%>/index.jsp" style="text-decoration:none">&lt;删除复制代码行号&gt;</a> 
	  <a href="<%=basePath%>/2code.jsp" style="text-decoration:none">&lt;生成二维码&gt;</a>
	  <a href="<%=basePath%>/lookWeb.jsp" style="text-decoration:none">&lt;查看网页源码&gt;</a>
 </span>
 <div style="margin-bottom: 20px"></div>
  

  
 