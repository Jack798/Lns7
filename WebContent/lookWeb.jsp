<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.Lns7.webRequest.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <%-- <base href="<%=basePath%>"> --%>
    
    <title>查看网页源码--自由者联盟</title>
    <meta name="baidu-site-verification" content="5kARAEUrwN" />
    <meta name="baidu_union_verify" content="e9eb432ca9f4292706e6fa2c05ac2130">
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<meta name="keywords" content="换个角度看网站,换个角度看网页,如何查看网页源码,查看网页源码">
	<meta name="description" content="发挥你的创意打造属于我们自由者的家园">
	<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="g.css">
	
<script>
javascript:Function('a,l,i,t,b,u,e,d',"a=['"+[

'                :h8G895r,',
'             ,hA@@@@@@@@#&5:',
'            S#@Hs:;h&@@@@@@#3',
'           8@@8      r&@@@@@@A;',
'          9@@M;:r1r   :9#@@@@@M;',
'         h@@@&ii391,   ;8GH@@@@B.',
'        :#@@@8 ;5r:.       iA@@@5',
'       .8@@@@G      ;s,:    .A@@#5',
'       rF@P@.Be,   .::. .;,  ;@@@M ,:',
'      .gMg@&@&&F   sh;,..,.  h@@@B sr',
'      .P@.@e@g@gs(         ;9@@s8# si',
'      s"M%@c@j@o@iXns :urs9%@c@s h,i1d',
'      ru#.@m@j@@@tBa@o&b5a3o#.@c8  i3;,',
'      roMm@"@)@;@@S:sS3r ,hS@@@@@&,,i:;;.',
'      ,1G@@@@@@@@@@5  :;:SGM@@@@@&.:,:8&hir:',
'       ;&@@@@@@@@@@B;   1HM@@@@@@Ms:,;r5h;H@,',
'        G@@@@@@@@@@G:   rsi&@@@@@@&:   ,:,X9,.',
'     r8M@@@@@@@@@@@#8r.    G@@@@@@@B3;:,.:s::;',
'   :G&B@@@@@@@@@@@@@@@MAXXXB@@@@@@@@@B31hi:,:;;',
'   sGi.;3#@@@@@@@@@@@@@@@@@@@@@@@@@@@@#9rr;,,,i,',
'    h1:  ,S#@@@@@@@@@@@@@@@@@@@@@@@@@@@@Xhi.  ,r',
'    13i,.  :X@@@@@@@@@@@@@@@@@@@@@@@@@@MXh...,;r:',
'    iXh;,..  9@@@@@@@@@@@@@@@@@@@@@@@@@@MA9hr;:is:',
'    ,X9r:,,.. 3@@@@@@@@@@@@@@@@@@@@@@@@@@@@G5s;;sh,',
'     9&5i;:,,. S@@@@@@@@@@@@@@@@@@@@@@@@@@@B9hsrsh1',
'     sBG5i;9&7&5&3&1:31,52&32&12&91&71&51&31&11&9&7&',
'     5&3&1:21,13&92&72&52&32&12&91&71&51&31&11&9&7&5&',
'      3&1:11,11&9&7&5&3&1:01,9&7&5&3&1:9,7&5&3&1:8@331'

].join("','")+"'];")();
</script>
	
	<script language="javascript"  src="javascript/jquery-1.10.2.min.js"/></script>
    <script type="text/javascript">
      		$(document).ready(function() {
			 $('#i_button').click(function(){
				 if( $('#i_urlText').val()==""){
					 alert("请先输入目标网址.");
					 return;
				 }else{
					 $(this).attr("disabled", "disabled"); 
					 var form = $("form");
					 form.attr("action","lookWeb.jsp");
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
		  <div>
		  <span style="font-size:20pt;font-family:微软雅黑,Arial;">目标网址:http://</span><input type="text" name="i_urlText" id="i_urlText" style="height: 50px;width: 600px;font-size:20pt;font-family:微软雅黑,Arial;" value="<%=request.getParameter("i_urlText")!=null ? request.getParameter("i_urlText") : "www."%>"/>  <button type="button" name="i_button" id="i_button" style="height: 50px;width: 200px;font-size:20pt;font-family:微软雅黑,Arial;">打开看看</button> 
			<br/>		 
			<%
			basePath = basePath.substring(7);
			%>
		  </div>
		  
		  <div style="margin-top: 5px;">
		  	 <span style="margin-right: 195px;"></span><a href="#" onClick="javascript:document.getElementById('i_urlText').value='<%=basePath%>/lookWeb.jsp';" style="font-size: 10pt;">我要看本网页有何不同</a>
		  </div>
		  
		  <div style="margin-top: 20px">
		  	<div style="font-size:9pt;color:#00FF00;font-family:宋体; overFlow-x: hidden; OVERFLOW: scroll; width:1300px; height:<%=request.getParameter("i_urlText")!=null ? 900 : 300%>px;border-style:solid;border-width:1px; border-color:#3399FF;background-color:#000000;">
				<%
				if(request.getParameter("i_urlText")!=null){
					try{
							HttpRequester requester = new HttpRequester();
							
					        HttpResponser responser = requester.sendGet("http://"+request.getParameter("i_urlText"));

					        out.println(responser.getContent());
					        
					        out.println("页面编码"+responser.getEncoding());
					}catch(Exception e){
							out.println("目标网站无响应，请检查输入网址\r\n"+e);
					}
			    
				}else{
					out.println("这里将从不一样的角度看到网页."); 
				}		 
		  		%>
		  	
		  	</div>
		  

		  </div>

		  <%-- <%@ include file="footer.jsp"%> --%>
 
	  </form>
	  <jsp:include page="footer.jsp" flush="true"/>
  </body>
  
</html>

