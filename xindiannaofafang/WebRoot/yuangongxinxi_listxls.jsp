<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="yuangongxinxihsgb" scope="page" class="com.bean.YuangongxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=yuangongxinxi.xls");
%>
<html>
  <head>
    <title>Ա����Ϣ</title>
  </head>

  <body >
 <%
			String sql="select * from yuangongxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>����</td>    <td align='center'>����</td>    <td align='center'>����</td>    <td  width='40' align='center'>�Ա�</td>    <td align='center'>����</td>    <td align='center'>ְ��</td>    <td  width='65' align='center'>��ְʱ��</td>    <td align='center'>�绰</td>        <td  width='80' align='center'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=yuangongxinxihsgb.getAllYuangongxinxi(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.gonghao}</td>    <td>${u.mima}</td>    <td>${u.xingming}</td>    <td align='center'>${u.xingbie}</td>    <td>${u.bumen}</td>    <td>${u.zhiwu}</td>    <td>${u.ruzhishijian}</td>    <td>${u.dianhua}</td>        <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=yuangongxinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

