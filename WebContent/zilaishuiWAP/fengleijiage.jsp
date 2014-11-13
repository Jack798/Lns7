<%@page import="com.Lns7.WeixinUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta name="viewport"
	content="width=device-width; initial-scale=1.3;minimum-scale=1.0;maximum-scale=2.0" />
<meta name="MobileOptimized" content="240" />
<meta name="format-detection" content="telephone=no" />
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta http-equiv="Cache-control" content="max-age=3600" />
<title>供水分类价格</title>
<style>
body,div,p,a,table,textarea,form,img,ul,ol,li,dl,dt,dd,h1,h2,h3,h4,h5,h6
	{
	margin: 0;
	padding: 0
}

li {
	list-style: none
}

img {
	border: 0
}

a {
	color: #00e
}

em {
	color: #c00;
	font-style: normal
}

a em {
	text-decoration: underline
}

select,input,img {
	vertical-align: middle
}

body {
	font: 14px/21px arial, sans-sarif
}

.mt15 {
	margin-top: 15px
}

.line {
	margin: 0 6px
}

.gray {
	color: #999;
	font-size: 12px;
	line-height: 21px
}

.keyword,.keyword a {
	color: #c60a00
}

.bc {
	padding-top: 2px;
	padding-bottom: 2px
}

.b {
	margin: 5px 0
}

.d {
	margin-bottom: 6px
}

.i {
	margin-bottom: 4px
}

.site,.date,.size,.g {
	color: #008000;
	padding: 0;
	margin: 0
}

.site,.date,.size,.abs {
	font-size: small
}

.gray {
	color: #666
}

.green {
	color: #008000
}

.reswrap,.relate,.pagenav,.timestamp,.bc,.retlink,.ew,.url {
	padding-right: 6px;
	padding-left: 6px
}

.ew {
	padding-top: 3px;
	padding-bottom: 3px
}

.relate {
	padding-bottom: 5px;
	padding-top: 5px;
	line-height: 150%
}

.resitem {
	margin: 5px 0
}

.f {
	padding: 5px
}

.pagenav {
	padding-top: 5px;
	padding-bottom: 5px
}

.pagenav {
	margin: 5px 0
}

.retlink {
	margin-top: 4px
}

.timestamp {
	margin-bottom: 2em
}

.title2 {
	font-size: 14px
}

.line {
	margin: 0 6px
}

.gray {
	color: #999;
	font-size: 12px;
	line-height: 21px
}

.ipt_text {
	font-size: 14px;
	padding: 2px 5px;
	border: 1px solid #bbb;
	background: #fff
}

.logo {
	margin: 20px 0 0
}

.logo img {
	vertical-align: top
}

.search {
	padding: 18px 0 0
}

.search .ipt_btn {
	margin-top: 7px
}

.nav {
	padding: 10px 0 0
}

.nav a {
	line-height: 28px
}

.ad {
	padding-top: 18px
}

.footer {
	line-height: 22px;
	padding-top: 12px;
	overflow: hidden
}

.footer .time {
	margin-right: 10px
}

.iwap {
	text-align: center
}

.hot {
	color: #c00;
	font-size: 10px;
	font-family: Arial, Helvetica, sans-serif;
	padding: 0 5px 0 0;
	text-decoration: none
}

th{ 
    border-top-width: 1px; 
    border-top-style: solid; 
    border-top-color: #000000; 
    border-left-width: 1px; 
    border-left-style: solid; 
    border-left-color: #000000; 
} 

td{ 
    border-top-width: 1px; 
    border-top-style: solid; 
    border-top-color: #000000; 
    border-left-width: 1px; 
    border-left-style: solid; 
    border-left-color: #000000; 
} 
table{
 border-right-width: 1px;
 border-right-style: solid;
 border-right-color: #000000;
 border-bottom-width: 1px;
 border-bottom-style: solid;
 border-bottom-color: #000000;
}
</style>
</head>
<body>
	<div class="iwap">
<table  border="0" cellspacing="0" cellpadding="5">
<tr>
	<th>类别</th>
    <th>自来水价格(元/立方米)</th>
    <th>水资源费价格(元/立方米)</th>
    <th>污水处理费价格(元/立方米)</th>
    <th>综合价格(元/立方米)</th>
</tr>

<tr>
	<td>居民
	</td>
    <td>1.70
    </td>
    <td>1.26
    </td>
    <td>1.04
    </td>
    <td>4.00
    </td>    
</tr>
<tr>
	<td>行政事业
	</td>
    <td>2.80
    </td>
    <td>1.32
    </td>
    <td>1.68
    </td>
    <td>5.80
    </td>
</tr>
<tr>
	<td>工商业
	</td>
    <td>3.00
    </td>
    <td>1.44
    </td>
    <td>1.77
    </td>
    <td>6.21
    </td>
</tr><tr>
	<td>宾馆、饭店、餐饮业
	</td>
    <td>3.50
    </td>
    <td>1.16
    </td>
    <td>1.55
    </td>
    <td>6.21
    </td>
</tr><tr>
	<td>洗浴业
	</td>
    <td>58.90
    </td>
    <td>21.10
    </td>
    <td>1.68
    </td>
    <td>81.68
    </td>
</tr><tr>
	<td>洗车业
	</td>
    <td>38.90
    </td>
    <td>21.10
    </td>
    <td>1.68
    </td>
    <td>61.68
    </td>
</tr><tr>
	<td>纯净水
	</td>
    <td>38.90
    </td>
    <td>21.10
    </td>
    <td>1.68
    </td>
    <td>61.68
    </td>
</tr><tr>
	<td>中水
	</td>
    <td>--
    </td>
    <td>--
    </td>
    <td>--
    </td>
    <td>1.00
    </td>

</table>
	</div>
</body>
</html>
<!--zly-->