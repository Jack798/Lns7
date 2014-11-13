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
<title>城区营业网点</title>
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
	<td rowspan="4">市区营销分公司	</td>
    <td>东城营业所    </td>
    <td>东城区砖角楼南里15号楼旁    </td>
    <td rowspan="4"><a href="tel:66054048" target="_blank">66054048</a></td>
</tr>
<tr>
	<td>西城营业所    </td>
    <td>西城区真武庙路四条8号院2号楼三层    </td>
  </tr>
<tr>
	<td>宣武营业所    </td>
    <td>丰台区菜户营天伦北里13号楼    </td>
  </tr><tr>
	<td>崇文营业所    </td>
    <td>崇文区南花市大街11号    </td>
    </tr>
<tr>
	<td rowspan="4">朝阳营销分公司	</td>
    <td>芍药居营业所    </td>
    <td>朝阳区芍药居北里304号楼    </td>
    <td rowspan="4"><a href="tel:84516138" target="_blank">84516138</a></td>
</tr>
<tr>
	<td>广渠门营业所    </td>
    <td>朝阳区广渠门外大街甲17号楼    </td>
  </tr><tr>
	<td>亚运村营业所    </td>
    <td>朝阳区安慧北里逸园20号楼    </td>
    </tr><tr>
	<td>青年路营业所    </td>
    <td>朝阳区建国路29号兴隆家园5号楼101号    </td>
    </tr><tr>
	<td rowspan="5">海淀营销分公司	</td>
    <td>北洼路营业所    </td>
    <td>海淀区北洼东街26号    </td>
    <td rowspan="5"><a href="tel:88511010" target="_blank">88511010</a></td>
</tr><tr>
	<td>双榆树营业所    </td>
    <td>海淀区双榆树东里20号楼    </td>
    </tr><tr>
	<td>板井营业所    </td>
    <td>海淀区曙光花园望山园10号楼东侧    </td>
    </tr><tr>
	<td>上地营业所    </td>
    <td>海淀区上地佳园裙房27号    </td>
    </tr><tr>
	<td>回龙观营业所    </td>
    <td>昌平区回龙观镇龙禧园北店嘉园南区2号楼5、6号底商    </td>
    </tr><tr>
	<td rowspan="7">丰台营销分公司	</td>
    <td>丰北营业所    </td>
    <td>丰台区泥洼路4号    </td>
    <td rowspan="7"><a href="tel:63859553" target="_blank">63859553</a>    </td>
</tr><tr>
	<td>南苑营业所    </td>
    <td>丰台区南苑镇北马中路42号    </td>
    </tr><tr>
	<td>方庄营业所    </td>
    <td>丰台区芳群园一区13号楼    </td>
    </tr><tr>
	<td>建欣苑营业所    </td>
    <td>丰台区大红门西路4号（建欣苑四里北木医院东侧）    </td>
    </tr><tr>
	<td>岳家楼营业所    </td>
    <td>丰台区郑常庄京铁家园二区8号楼一层    </td>
    </tr><tr>
	<td>亦庄营业所    </td>
    <td>亦庄经济技术开发区宏达北路甲5号    </td>
    </tr>
<tr>
	<td>吴家场营业所    </td>
    <td>海淀区吴家场路45号    </td>
  </tr>
</table>
	



	</div>
</body>
</html>
<!--zly-->