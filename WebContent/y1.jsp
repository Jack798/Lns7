<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%@ page import="com.Lns7.WordProcessing"%><%@ page import="java.security.*"%><%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;


//获取易信验证时GET过来的参数

String signature = request.getParameter("signature"); //易信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
String timestamp = request.getParameter("timestamp");//时间戳
String nonce = request.getParameter("nonce");//随机数
String echostr = request.getParameter("echostr");//随机字符串

/*
//String signature = request.getParameter("signature"); //易信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
String timestamp = "2014040124";//时间戳
String nonce = "97553457755413";//随机数
String echostr = "dkuhwdmtiusadaqpch";//随机字符串

//System.out.println(signature);

System.out.println(timestamp);
System.out.println(nonce);
System.out.println(echostr);
System.out.println("=============");
*/
String[] signarray = new String[]{"dkcm543fd93d",timestamp,nonce}; 
Arrays.sort(signarray);

StringBuffer sb = new StringBuffer();
System.out.println(signarray.length);
for(int i=0;i<signarray.length;i++){
	System.out.println(signarray[i]);
	sb.append(signarray[i]);
}
MessageDigest md = null;
String outStr = null;
md = MessageDigest.getInstance("SHA-1");  
byte[] digest = md.digest(sb.toString().getBytes());


String str = "";
String tempStr = "";
for (int i = 1; i < digest.length; i++) {
    tempStr = (Integer.toHexString(digest[i] & 0xff));
    if (tempStr.length() == 1) {
        str = str + "0" + tempStr;
    }
    else {
        str = str + tempStr;
    }
}
outStr = str.toLowerCase();

if(signature.equals(outStr)){
	out.println(echostr);
}else{
	out.println(echostr);
}



//String signstr = DigestUtils.shaHex(signarray);

%>


