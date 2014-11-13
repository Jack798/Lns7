<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%@ page import="com.Lns7.WordProcessing"%><%@ page import="java.security.*"%><%
System.out.println(request.getParameter("echostr"));
out.println(request.getParameter("echostr").trim());
%>