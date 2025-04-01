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
		<TITLE>修改发放申请</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="fafangshenqing_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateFafangshenqing.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改发放申请<input type="hidden" name="id" value="${fafangshenqing.id}" /></td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">名称：</td><td><input name='mingcheng' type='text' id='mingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">库存：</td><td><input name='kucun' type='text' id='kucun' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">申请数量：</td><td><input name='shenqingshuliang' type='text' id='shenqingshuliang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelshenqingshuliang' /></td></tr>		<tr ><td width="200">申请理由：</td><td><textarea name='shenqingliyou' cols='50' rows='5' id='shenqingliyou' onblur='checkform()' style='border:solid 1px #000000; color:#666666' ></textarea>&nbsp;*<label id='clabelshenqingliyou' /></td></tr>		<tr ><td width="200">日期：</td><td><input name='riqi' type='text' id='riqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelriqi' /></td></tr>		<tr ><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("yuangongxinxi","xingming","gonghao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		<tr ><td width="200">部门：</td><td><input name='bumen' type='text' id='bumen' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.bumen.value='<%=connDbBean.readzd("yuangongxinxi","bumen","gonghao",(String)request.getSession().getAttribute("username"))%>';document.form1.bumen.setAttribute("readOnly",'true');</script>		<tr 0><td width="200">发放状态：</td><td><select name='fafangzhuangtai' id='fafangzhuangtai'><option value="申请中">申请中</option><option value="已发放">已发放</option><option value="已驳回">已驳回</option></select></td></tr>		<tr 1><td width="200">回复意见：</td><td><textarea name='huifuyijian' cols='50' rows='5' id='huifuyijian' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bianhao.value='${fafangshenqing.bianhao}';</script>	<script language="javascript">document.form1.mingcheng.value='${fafangshenqing.mingcheng}';</script>	<script language="javascript">document.form1.kucun.value='${fafangshenqing.kucun}';</script>	<script language="javascript">document.form1.shenqingshuliang.value='${fafangshenqing.shenqingshuliang}';</script>	<script language="javascript">document.form1.shenqingliyou.value='${fafangshenqing.shenqingliyou}';</script>	<script language="javascript">document.form1.riqi.value='${fafangshenqing.riqi}';</script>	<script language="javascript">document.form1.gonghao.value='${fafangshenqing.gonghao}';</script>	<script language="javascript">document.form1.xingming.value='${fafangshenqing.xingming}';</script>	<script language="javascript">document.form1.bumen.value='${fafangshenqing.bumen}';</script>	<script language="javascript">document.form1.fafangzhuangtai.value='${fafangshenqing.fafangzhuangtai}';</script>	<script language="javascript">document.form1.huifuyijian.value='${fafangshenqing.huifuyijian}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var shenqingshuliangobj = document.getElementById("shenqingshuliang"); if(shenqingshuliangobj.value==""){document.getElementById("clabelshenqingshuliang").innerHTML="&nbsp;&nbsp;<font color=red>请输入申请数量</font>";return false;}else{document.getElementById("clabelshenqingshuliang").innerHTML="  "; } 	    var shenqingliyouobj = document.getElementById("shenqingliyou"); if(shenqingliyouobj.value==""){document.getElementById("clabelshenqingliyou").innerHTML="&nbsp;&nbsp;<font color=red>请输入申请理由</font>";return false;}else{document.getElementById("clabelshenqingliyou").innerHTML="  "; } 	var riqiobj = document.getElementById("riqi"); if(riqiobj.value==""){document.getElementById("clabelriqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入日期</font>";return false;}else{document.getElementById("clabelriqi").innerHTML="  "; } 	if(parseInt(document.form1.kucun.value)<parseInt(document.form1.shenqingshuliang.value)){alert("对不起，库存必需大于申请数量");return false;}	


return true;   
}   
popheight=450;
</script>  
