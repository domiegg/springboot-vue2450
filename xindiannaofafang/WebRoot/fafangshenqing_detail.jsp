<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>发放申请详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  发放申请详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${fafangshenqing.bianhao}</td>     <td width='11%'>名称：</td><td width='39%'>${fafangshenqing.mingcheng}</td></tr><tr>     <td width='11%'>库存：</td><td width='39%'>${fafangshenqing.kucun}</td>     <td width='11%'>申请数量：</td><td width='39%'>${fafangshenqing.shenqingshuliang}</td></tr><tr>     <td width='11%'>申请理由：</td><td width='39%'>${fafangshenqing.shenqingliyou}</td>     <td width='11%'>日期：</td><td width='39%'>${fafangshenqing.riqi}</td></tr><tr>     <td width='11%'>工号：</td><td width='39%'>${fafangshenqing.gonghao}</td>     <td width='11%'>姓名：</td><td width='39%'>${fafangshenqing.xingming}</td></tr><tr>     <td width='11%'>部门：</td><td width='39%'>${fafangshenqing.bumen}</td>     <td width='11%'>发放状态：</td><td width='39%'>${fafangshenqing.fafangzhuangtai}</td></tr><tr>     <td width='11%'>回复意见：</td><td width='39%'>${fafangshenqing.huifuyijian}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

