<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户编辑</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="mainpage.css">
	

<style>
body{background:url(img/e20656af6c1ae6a596492ba6c815ee71.jpg);
background-size:100%;}
</style>

  </head>
  
  <body >
<div id="frame">

<div id="div1">
 
  <table border="0" width=100% height=100%>
  <tr>
  <td width="65" height="65">
 <img src="${client.img}"width=100% height=100% /> 
  </td>
   <td style="padding: 10px;"width="60">${client.name}
  </td>
  <td width="180">账号: ${client.cno}
  </td>
  <td width="60">
<a href="login.jsp"><button class="btn btn-success"> 退&nbsp;&nbsp;出</button></a>
 
  </td>
  <td>
  
  </td>
  </tr>
  </table>
  </div>

<div id="div2">
   <h3>欢&nbsp;&nbsp;迎&nbsp;&nbsp;光&nbsp;&nbsp;临&nbsp;&nbsp;</h3>
  </div>

<div id="div3">
  
   
   <div id="div31">
   	<a href="/WarehouseManage/AEdit.do?select=Cclient&id=${client.id }"><button class="btn btn-primary"  style="width:100%;height:95%;"><span class="glyphicon glyphicon-user" style="color: rgb(255, 255, 255); font-size: 17px;">  管理个人信息</span></button></a>
   </div>
    <div id="div32">
   	<a href="/WarehouseManage/list.do?select=Cgoods"><button class="btn btn-primary"style="width:100%;height:95%;">
<span class="glyphicon glyphicon-th-list" style="color: rgb(255, 255, 255); font-size: 17px;">&nbsp; 浏览商品 </span></button></a>
   </div>
    <div id="div33">
   	<a href="/WarehouseManage/listOrder.do?select=client&cno=${client.cno }"><button class="btn btn-primary"style="width:100%;height:95%;"> <span class="glyphicon glyphicon-tasks" style="color: rgb(255, 255, 255); font-size: 17px;"> 查看订单</span></button></a>
   </div>
    
      
    
   
    div3
  </div>
  <div id="div4">
  
  
   
   
   <table border=
   "2" width=70% height=70% align=center > 
   <tr>
   <td colspan="2">
   <h2>请在下方区域修改个人信息</h2>
   </td>
   </tr>
   
    <tr>
   <td align="center"  colspan="2" height=20%>
   <p><img  src="${client.img}"width=100px height=100px /> </p>
   
   <form action="/WarehouseManage/uploadphoto?select=Cclient&id=${client.id}" method="post" enctype="multipart/form-data">
    上传照片:<input type="file" name="photo">
    <button type="submit"  class="btn btn-success" value="上传" name="upload">上传</button>
    </form>
   </td>
   </tr>
<form method="post" action="/WarehouseManage/Update.do">
    <tr>
   <td width=50%>
  <span class="input-group-addon" >客户&nbsp;&nbsp;名称:</span> <p><input type="text" value="${client.name }" name="Name"  placeholder="请在这里输入名称"  class="form-control"  style="width: 250px ; "> </p>
   </td>
   <td>
 <span class="input-group-addon" >客户&nbsp;&nbsp;编号:</span><p><input type="text" value="${client.cno }" name="Cno"  placeholder="请在这里输入编号"  class="form-control"  style="width: 250px ; "> </p>
   </td>

   </tr>
   
   <tr>
   <td>
 <span class="input-group-addon" >联&nbsp;系&nbsp;人:</span>
 <p><input type="text" value="${client.con}" name="Con"  placeholder="请在这里输入联系人"  class="form-control"  style="width: 250px ;">	    </p>
			 </td>
   <td>
   <span class="input-group-addon" >${client.address}收货&nbsp;&nbsp;地址:</span>
  <p> <input type="text" value="${client.address}" name="Address"  placeholder="请在这里输入收货地址"  class="form-control"  style="width: 250px ;"></p>
   </td>
   </tr>
   
   <tr>
   <td>
 <span class="input-group-addon" >联系&nbsp;&nbsp;方式:</span>
<p><input type="text" value="${client.tel }" name="Tel"  placeholder="请在这里输入联系方式"  class="form-control"  style="width: 250px ; ">	    </p>
   </td>
   
   
   <td>
  <span class="input-group-addon" >性&nbsp;&nbsp;别:</span> 
  <br>
   <input type="radio" name="Sex" value="男"  />男
    <input type="radio" name="Sex" value="女" />女			    
			 </td>
			 <br>
   
   </tr>
   
   <tr>
   <td colspan="2">
   <span class="input-group-addon" style="width:950px ; ">修改&nbsp;&nbsp;密码:</span>
   <input  type="text" style="height:31px;width: 250px ; " class="form-control" 
 NAME="pwd"  placeholder="若有需要则填">
   </td>
   </tr>
   
    
  
   <tr>
   <td colspan="2" height=60%>
   <div style='overflow-y:auto;height:180px;'>
   <span class="input-group-addon" style="width: 950px ; ">详细&nbsp;&nbsp;信息:</span>
   <textarea    style="height:100%;width: 100% ; " class="form-control" 
 NAME="remark"  placeholder="若有需要则填"  rows="10" cols="15">${client.remark }</textarea>
 </div>
   </td>
 
   </tr>
   
   
   
     <input type="hidden" name="cid" value="${client.id }">
   <!-- <input type="hidden" name="Specs" value="${good.specs }">-->
       <input type="hidden" name="Img" value="${client.img }">
        <input type="hidden" name="select" value="Cclient">
   <input type="hidden" name="oldpwd" value="${client.pwd}">
   
   <tr>
   <td style="text-align:center; ">
   <a href="CEdit.jsp"><button type ="button" class="btn btn-success"  style="width:30%;"> 重置</button></a>  
   </td>
   
   <td style="text-align:center; ">
 <button type="submit"class="btn btn-success"  name="submit"  style="width:40%;">确&nbsp;&nbsp;定</button>
   </td>
   </tr>
   
   
   </form>
   
   
   
   
   
   </table>
   
  
   
   
  </div>












</div>
  </body>
</html>
