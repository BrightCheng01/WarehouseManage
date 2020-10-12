<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


  <%String roption=request.getParameter("roption"); %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  <style>
#register{border:2px solid grey;margin-top:400px; border-radius:12px;width:31%;height:65%;	background-color: rgba(240, 255, 255, 0.5);margin:80px auto auto auto;}
body{background:url(img/e20656af6c1ae6a596492ba6c815ee71.jpg);
background-size:100%;}
</style>
  
    <base href="<%=basePath%>">
    
    <title>账户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  
  
 
  
  
  
  <body >
  <a href="login.jsp"><button class="btn btn-success"> 退&nbsp;&nbsp;出</button></a>
  
  
  
  
  <div id="register" >
 
  
   
   <c:if test='<%=roption.equals("admin")%>'>
    <FORM action="/WarehouseManage/register.do?roption=admin" method=post name=form >
   
   <table border="0" width=30% heigh=80% align=center style="margin-top: 80px; "bgcolor="white"> 
    
     <tr>
   <td colspan="2" bgcolor="white" >
   <h2><%=roption%>请在下方区域填写注册信息</h2>
   </td>
   </tr>
	
    <tr>
   <td width=50% bgcolor="white">
  <span class="input-group-addon" >姓&nbsp;&nbsp;名:</span> <p><input type="text"  name="name"  placeholder="请在这里输入名字"  class="form-control"  style="width: 250px ; "> </p>
   </td>
   <td bgcolor="white">
 <span class="input-group-addon" >工&nbsp;&nbsp;号:</span><p><input type="text"  name="ano"  placeholder="请在这里输入工号"  class="form-control"  style="width: 250px ; "> </p>
   </td>

  
   </tr>
   
   <tr>
   <td bgcolor="white">
  <span class="input-group-addon" >性&nbsp;&nbsp;别:</span>
  <select id="sex" class="form-control" name="Sex" >
						<option value="男">男</option>
						<option value="女">女</option>
						
					    </select>
					    
			    
			 </td>
   <td bgcolor="white">
   <span class="input-group-addon" >填写&nbsp;&nbsp;密码:</span>
   <input  type="text" style="height:31px;width: 250px ; " class="form-control" 
 NAME="pwd"  placeholder="填写密码">
   </td>
   </tr>
   
   <tr>
   <td colspan="2" height=80%>
   <span class="input-group-addon" style="width: 950px ; ">备&nbsp;&nbsp;注:</span>
   <textarea  name="remark"  style="height:80%;width: 100% ; " class="form-control" 
  placeholder="填写备注  "  rows="10" cols="15"></textarea>
   </td>
 
   </tr>
   
   
    <tr>
   <td style="text-align:center; "bgcolor="white">
   <a href="Register.jsp?roption=<%=roption%>"><button type ="button" class="btn btn-success"  style="width:30%;"> 重置</button></a>
   
   </td>
   <td style="text-align:center; "bgcolor="white">
 <button type="submit"class="btn btn-success"  name="submit"  style="width:40%;height:30%;">确&nbsp;&nbsp;定</button>
   </td>
   </tr>


   </table>
  
   </Form>
  </c:if>
  
  
   
   <c:if test='<%=roption.equals("client")%>'>
   <FORM action="/WarehouseManage/register.do?roption=client" method=post name=form >
     <table border="0" width=30% heigh=80% align=center style="margin-top: 40px; "bgcolor="white">  
   
    
    <tr>
   <td colspan="2" bgcolor="white" >
   <h2><%=roption%>请在下方区域填写注册信息</h2>
   </td>
   </tr>
   <tr>
   <td width=50% bgcolor="white">
  <span class="input-group-addon" >客户&nbsp;&nbsp;名称:</span> <p><input type="text" " name="Name"  placeholder="请在这里输入名称"  class="form-control"  style="width: 250px ; "> </p>
   </td>
   <td bgcolor="white">
 <span class="input-group-addon" >客户&nbsp;&nbsp;编号:</span><p><input type="text"  name="Cno"  placeholder="请在这里输入编号"  class="form-control"  style="width: 250px ; "> </p>
   </td>

   </tr>
   
   <tr>
   <td bgcolor="white">
 <span class="input-group-addon" >联&nbsp;系&nbsp;人:</span>
 <p><input type="text" name="Con"  placeholder="请在这里输入联系人"  class="form-control"  style="width: 250px ;">	    </p>
			 </td>
   <td bgcolor="white">
   <span class="input-group-addon" >收货&nbsp;&nbsp;地址:</span>
  <p> <input type="text"  name="Address"  placeholder="请在这里输入收货地址"  class="form-control"  style="width: 250px ;"></p>
   </td>
   </tr>
   
   <tr>
   <td bgcolor="white">
 <span class="input-group-addon" >联系&nbsp;&nbsp;方式:</span>
<p><input type="text"  name="Tel"  placeholder="请在这里输入联系方式"  class="form-control"  style="width: 250px ; ">	    </p>
   </td>
   
   
   <td bgcolor="white">
  <span class="input-group-addon" >性&nbsp;&nbsp;别:</span> 
 <select id="sex" class="form-control" name="Sex" >
						<option value="男">男</option>
						<option value="女">女</option>
						
					    </select>
   
   </tr>
   
   <tr>
   <td colspan="2" bgcolor="white">
   <span class="input-group-addon" style="width:950px ; ">填写&nbsp;&nbsp;密码:</span>
   <input  type="text" style="height:31px;width: 250px ; " class="form-control" 
 NAME="pwd"  placeholder="填写密码">
   </td>
   </tr>
   
    
  
   <tr>
   <td colspan="2" height=60% bgcolor="white">
   <div style='overflow-y:auto;height:180px;'>
   <span class="input-group-addon" style="width: 950px ; ">详细&nbsp;&nbsp;信息:</span>
   <textarea    style="height:100%;width: 100% ; " class="form-control" 
 NAME="remark"  placeholder="若有需要则填"  rows="10" cols="15"></textarea>
 </div>
   </td>
 
   </tr>
   
   
  
   
   <tr>
   <td style="text-align:center; "bgcolor="white">
   <a href="Register.jsp?roption=<%=roption%>"><button type ="button" class="btn btn-success"  style="width:30%;"> 重置</button></a>
   
   </td>
   <td style="text-align:center; "bgcolor="white">
 <button type="submit"class="btn btn-success"  name="submit"  style="width:40%;height:30%;">确&nbsp;&nbsp;定</button>
   </td>
   </tr>
   
   
   

    </table>
       <input type="hidden" value=<%=roption%> name="roption">
   </form>
   
 
  
   </c:if>
   
   </form>
   </div>
  </body>
</html>
