<%@page import="com.Lns7.WeixinUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.Lns7.webHttpsRequest.*"%>
<%@ page import="com.Lns7.WeixinUtil.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <%-- <base href="<%=basePath%>"> --%>
    
    <title>Hello</title>
    <meta name="baidu-site-verification" content="5kARAEUrwN" />
    <meta name="baidu_union_verify" content="e9eb432ca9f4292706e6fa2c05ac2130">
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    

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
					 form.attr("action","tijiao.jsp");
					 form.attr("method","post");
					 form.submit();
				 }
			 });
		});
      		
      		
  

     </script>
  </head>
  
  <body>
    
	  <form>
	  	  <input type="text" name="i_urlText" id="i_urlText" style="width: 600px" value="<%=request.getParameter("i_urlText")!=null ? request.getParameter("i_urlText") : ""%>"/>
	  	  <br/>
	  	  <br/> 
		  <textarea rows="20" cols="160" name="i_codeText" id="i_codeText" placeholder="请将代码粘贴至此处." style="border:solid 1px #3399FF;"><%
				if(request.getParameter("i_codeText")!=null){
					out.println(request.getParameter("i_codeText"));
				}		  
		  %></textarea>
		  <br/><br/>
		   <button type="button" name="i_button" id="i_button">打开看看</button> 
		<%
		/*
				if(request.getParameter("i_urlText")!=null){
					try{
							HttpRequester requester = new HttpRequester();
							
					        HttpResponser responser = requester.sendPost(request.getParameter("i_urlText").trim(),request.getParameter("i_codeText").trim());

					        out.println(responser.getContent());
					        
					       // out.println("页面编码"+responser.getEncoding());
					}catch(Exception e){
							out.println("目标网站无响应，请检查输入网址\r\n"+e);
					}
			    
				}else{
					out.println("hi."); 
				}	
		*/
		
		if(request.getParameter("i_urlText")!=null){
			out.println(WeixinUtil.httpRequest(request.getParameter("i_urlText").trim(), "POST", request.getParameter("i_codeText").trim()));
		}else{
			out.println("hi."); 
		}	
		
		
		  		%>
		  
		  <%-- <%@ include file="footer.jsp"%> --%>
		  
		  
	  </form>
	
  </body>
  
</html>

