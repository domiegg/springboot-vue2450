<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>电脑信息查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">电脑信息列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="diannaoxinxiList.do" name="myform" method="post">
									查询   名称：<input name="mingcheng" type="text" id="mingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  品牌：<input name="pinpai" type="text" id="pinpai" style='border:solid 1px #000000; color:#666666' size="12" />  型号：<input name="xinghao" type="text" id="xinghao" style='border:solid 1px #000000; color:#666666' size="12" />  配置：<input name="peizhi" type="text" id="peizhi" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>编号</td>
    <td align='center'>名称</td>
    <td align='center'>品牌</td>
    <td align='center'>型号</td>
    
    <td align='center'>库存</td>
    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.bianhao}</td>
    <td>${u.mingcheng}</td>
    <td>${u.pinpai}</td>
    <td>${u.xinghao}</td>
    
    <td>${u.kucun}</td>
    
                              <td align="center"> ${u.addtime } </td>

															<td align="center">
															<c:if test="${sessionScope.cx=='员工'}"> <a href="fafangshenqing_add.jsp?id=${u.id }">申请</a>  </c:if>
															 
                              <c:if test="${sessionScope.cx=='超级管理员'}"> <a href="doUpdateDiannaoxinxi.do?id=${u.id }">编辑</a>  <a href="deleteDiannaoxinxi.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a></c:if> <a href="diannaoxinxiDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from diannaoxinxi where 1=1 ";
				
if(request.getParameter("mingcheng")=="" ||request.getParameter("mingcheng")==null ){}else{String nmingcheng=new String(request.getParameter("mingcheng").getBytes("8859_1"));if(nmingcheng.contains("?")){nmingcheng=request.getParameter("mingcheng");}sql=sql+" and mingcheng like '%"+nmingcheng+"%'";}
if(request.getParameter("pinpai")=="" ||request.getParameter("pinpai")==null ){}else{String npinpai=new String(request.getParameter("pinpai").getBytes("8859_1"));if(npinpai.contains("?")){npinpai=request.getParameter("pinpai");}sql=sql+" and pinpai like '%"+npinpai+"%'";}
if(request.getParameter("xinghao")=="" ||request.getParameter("xinghao")==null ){}else{String nxinghao=new String(request.getParameter("xinghao").getBytes("8859_1"));if(nxinghao.contains("?")){nxinghao=request.getParameter("xinghao");}sql=sql+" and xinghao like '%"+nxinghao+"%'";}
if(request.getParameter("peizhi")=="" ||request.getParameter("peizhi")==null ){}else{String npeizhi=new String(request.getParameter("peizhi").getBytes("8859_1"));if(npeizhi.contains("?")){npeizhi=request.getParameter("peizhi");}sql=sql+" and peizhi like '%"+npeizhi+"%'";}
			sql+=" order by id desc";
double kucunz=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						kucunz=kucunz+Float.valueOf(RS_result.getString("kucun")).floatValue();

						
						
			 }
			%>
		共计库存:<%=kucunz%>； 
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="diannaoxinxiList.do?page=1" >首页</a>
             <a href="diannaoxinxiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="diannaoxinxiList.do?page=${page.page+1 }">下一页</a>
			<a href="diannaoxinxiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
