<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>生成二维码--自由者联盟</title>
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<meta name="keywords" content="生成二维码,如何生成二维码,二维码如何生成,二维码工具,生成二维码的工具,工具二维码,怎么生成二维码">
	<meta name="description" content="原创开发者小工具网站，帮助开发者删除复制代码行号、生成二维码、查看网页源码。">
	<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="g.css">
	<script language="javascript"  src="javascript/jquery-1.10.2.min.js"/></script>
    <script type="text/javascript">
      		$(document).ready(function() {
			 $('#i_button').click(function(){
				 if( $('#i_Text').val()==""){
					 alert("请将需要转换的文本粘贴至文本框.");
					 return;
				 }else{
					 $(this).attr("disabled", "disabled"); 
					 var form = $("form");
					 form.attr("action","2code.jsp");
					 form.attr("method","post");
					 form.submit();
				 }
			 });
		});
     </script>
  </head>
  
  <body>
   <jsp:include page="top.jsp" flush="true"/><jsp:include page="menu.jsp" flush="true"/>
  	<form>
	  <div style="float: left;margin-right: 50px;">
		  <textarea rows="20" cols="80" name="i_Text" id="i_Text" placeholder="请将需要转换的文本粘贴至此处."><%
				  if(request.getParameter("i_Text") != null){
		  				out.print(request.getParameter("i_Text"));
		  			}
		  %></textarea>
	  </div>
	  <div>
	  <%
  			if(request.getParameter("i_Text") != null){
  				String imgUrl = "2Dimages.jsp?text=" + request.getParameter("i_Text");
  				out.print("<img src=\"" + imgUrl + "\" style=\"margin:0 auto\"/>");
  				out.print("<br/><a href=\""+imgUrl+"\" target=\"_blank\">下载二维码</a>");
  			}
  		%>
   	  </div>
	  <div style="clear: both; ">
	  	  <br/>
		  <button type="button" name="i_button" id="i_button" style="height: 50px;width: 200px;font-size:20pt;font-family:微软雅黑,Arial;">生成二维码</button>
		  
		    
	  </div>

  	</form>
  	<jsp:include page="footer.jsp" flush="true"/>	
  </body>
 
</html>
