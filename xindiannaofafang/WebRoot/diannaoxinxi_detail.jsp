<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>电脑信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  电脑信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${diannaoxinxi.bianhao}</td>     <td width='11%'>名称：</td><td width='39%'>${diannaoxinxi.mingcheng}</td></tr><tr>     <td width='11%'>品牌：</td><td width='39%'>${diannaoxinxi.pinpai}</td>     <td width='11%'>型号：</td><td width='39%'>${diannaoxinxi.xinghao}</td></tr><tr>     <td width='11%'>配置：</td><td width='39%'>${diannaoxinxi.peizhi}</td>     <td width='11%'>库存：</td><td width='39%'>${diannaoxinxi.kucun}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

