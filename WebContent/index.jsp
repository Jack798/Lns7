<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.Lns7.WordProcessing"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <%-- <base href="<%=basePath%>"> --%>
    
    <title>删除复制代码行号--自由者联盟</title>
    <meta name="baidu-site-verification" content="5kARAEUrwN" />
    <meta property="qh.webmaster" content="52e8d30661f87"/>
    <meta name="baidu_union_verify" content="e9eb432ca9f4292706e6fa2c05ac2130">
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<meta name="keywords" content="删除行号,自由者联盟,去除行号,如何去除行号,java行号去除,.net行号去除,粘帖行号去除,复制行号去除,代码行号去除,删除多余的行号,删除行号,删除多余行号,批量删除代码前行号,去掉代码前每行开头的行号,去除java代码行号">
	<meta name="description" content="原创开发者小工具网站，帮助开发者删除复制代码行号、生成二维码、查看网页源码。">
	<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="g.css">

	
	<script language="javascript"  src="javascript/jquery-1.10.2.min.js"/></script>
    <script type="text/javascript">
      		$(document).ready(function() {
			 $('#i_button').click(function(){
				 if( $('#i_codeText').val()==""){
					 alert("请先粘贴代码至文本框.");
					 return;
				 }else{
					 $(this).attr("disabled", "disabled"); 
					 var form = $("form");
					 form.attr("action","index.jsp");
					 form.attr("method","post");
					 form.submit();
				 }
			 });
		});
     </script>
     
     <script type="text/javascript" name="baidu-tc-cerfication" src="http://apps.bdimg.com/cloudaapi/lightapp.js#a770002c907a09f1de4629522f644c92"></script>
    
  </head>
  
  <body>
    <jsp:include page="top.jsp" flush="true"/><jsp:include page="menu.jsp" flush="true"/>
    
    
	  <form>
		  <textarea rows="20" cols="160" name="i_codeText" id="i_codeText" placeholder="请将代码粘贴至此处." style="border:solid 1px #3399FF;"><%
				if(request.getParameter("i_codeText")!=null){
					out.println(WordProcessing.delNum(request.getParameter("i_codeText")));
				}		  
		  %></textarea>
		  <br/><br/>
		  <button type="button" name="i_button" id="i_button" style="height: 50px;width: 200px;font-size:20pt;font-family:微软雅黑,Arial;">删除行号</button>
		  
		  <%-- <%@ include file="footer.jsp"%> --%>
		  
		  
	  </form>
	  <jsp:include page="footer.jsp" flush="true"/>
  </body>
  
</html>

