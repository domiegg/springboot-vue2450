<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="fafangshenqinghsgb" scope="page" class="com.bean.FafangshenqingBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=fafangshenqing.xls");
%>
<html>
  <head>
    <title>��������</title>
  </head>

  <body >
 <%
			String sql="select * from fafangshenqing  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>���</td>    <td align='center'>����</td>    <td align='center'>���</td>    <td align='center'>��������</td>        <td  width='65' align='center'>����</td>    <td align='center'>����</td>    <td align='center'>����</td>    <td align='center'>����</td>    <td align='center'>����״̬</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=fafangshenqinghsgb.getAllFafangshenqing(13);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.mingcheng}</td>    <td>${u.kucun}</td>    <td>${u.shenqingshuliang}</td>        <td>${u.riqi}</td>    <td>${u.gonghao}</td>    <td>${u.xingming}</td>    <td>${u.bumen}</td>    <td>${u.fafangzhuangtai}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

