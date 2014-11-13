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
<title>郊区营业网点</title>
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
<div style="font-weight:bold"><a href="tel:96116" target="_blank">北京市自来水集团客服电话：96116</a></div>
		<table border="0" cellspacing="0" cellpadding="5">
<tr>
	<th>单位名称</th>
    <th>营业所名称</th>
    <th>地 址</th>
    <th>联系电话</th>
</tr>
<tr>
	<td>长辛店分公司	</td>
    <td>长辛店分公司营业厅    </td>
    <td>丰台区长辛店镇李家菜园16号    </td>
    <td><a href="tel:83866234" target="_blank">83866234</a></td>
</tr>
<tr>
	<td>南口分公司	</td>
    <td>南口分公司营业厅    </td>
    <td>昌平区南口镇水厂路120号    </td>
    <td><a href="tel:69771032" target="_blank">69771032 </a>   </td>
</tr>
<tr>
	<td>门头沟分公司	</td>
    <td>门头沟分公司营业厅    </td>
    <td>门头沟区城子大街128号    </td>
    <td><a href="tel:69843549" target="_blank">69843549 </a>   </td>
</tr>
<tr>
	<td>潞洲水务公司	</td>
    <td>潞州水务公司营销管理部收费大厅    </td>
    <td>通州区新华东街194号    </td>
    <td><a href="tel:69545885" target="_blank">69545885 </a>   </td>
</tr>
<tr>
	<td>兴润水务公司	</td>
    <td>兴润水务公司营销部售水处    </td>
    <td>大兴黄村永华路39号    </td>
    <td><a href="tel:61215014" target="_blank">61215014 </a>   </td>
</tr>
<tr>
	<td>怀柔分公司	</td>
    <td>怀柔自来水公司营业厅    </td>
    <td>怀柔区开放路56号    </td>
    <td><a href="tel:69647014" target="_blank">69647014 </a>   </td>
</tr>
<tr>
	<td rowspan="2">良泉水业公司	</td>
    <td>良乡水业公司良乡营业厅    </td>
    <td>房山区良乡西路南大街31号    </td>
    <td><a href="tel:69382654" target="_blank">69382654   </a> </td>
</tr>
<tr>
	<td>良乡水业公司城关营业厅    </td>
    <td>房山区城关镇房窑路7号    </td>
    <td><a href="tel:69314387" target="_blank">69314387 </a>   </td>
</tr>
<tr>
	<td rowspan="2">缙阳水业公司	</td>
    <td>缙阳水业公司营业厅    </td>
    <td>延庆县东外大街67号    </td>
    <td><a href="tel:69103272" target="_blank">69103272</a>    </td>
</tr>
<tr>
	<td>缙阳水业康庄自来水营业厅    </td>
    <td>延庆县康庄商业区C区6-1号    </td>
    <td><a href="tel:61161355" target="_blank">61161355</a>    </td>
</tr>
<tr>
	<td rowspan="2">檀州自来水公司	</td>
    <td>檀州自来水公司收费大厅    </td>
    <td>密云县新西路60号（自来水公司楼内）    </td>
    <td><a href="tel:69089939" target="_blank">69089939</a>    </td>
</tr>
<tr>
	<td>檀州自来水公司北门地区收费厅    </td>
    <td>密云县沿湖小区9号楼南侧    </td>
    <td><a href="tel:69044369" target="_blank">69044369</a>    </td>
</tr>
</table>
	</div>
</body>
</html>
<!--zly-->