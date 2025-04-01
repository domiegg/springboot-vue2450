<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>员工信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  员工信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>工号：</td><td width='39%'>${yuangongxinxi.gonghao}</td>     <td width='11%'>密码：</td><td width='39%'>${yuangongxinxi.mima}</td></tr><tr>     <td width='11%'>姓名：</td><td width='39%'>${yuangongxinxi.xingming}</td>     <td width='11%'>性别：</td><td width='39%'>${yuangongxinxi.xingbie}</td></tr><tr>     <td width='11%'>部门：</td><td width='39%'>${yuangongxinxi.bumen}</td>     <td width='11%'>职务：</td><td width='39%'>${yuangongxinxi.zhiwu}</td></tr><tr>     <td width='11%'>入职时间：</td><td width='39%'>${yuangongxinxi.ruzhishijian}</td>     <td width='11%'>电话：</td><td width='39%'>${yuangongxinxi.dianhua}</td></tr><tr>     <td width='11%'>备注：</td><td width='39%'>${yuangongxinxi.beizhu}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

