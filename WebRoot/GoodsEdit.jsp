<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>货物编辑</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="mainpage.css">
	

<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">


  </head>
  
  <body>
   
   
   <div id="frame">
  <div id="div1">
 
  <table border="0" width=100% height=100%>
  <tr>
  <td width="65" height="65">
      <img src="${admin.img}"width=100% height=100% /> 
  </td>
   <td style="padding: 10px;"width="60">${admin.name}
  </td>
  <td width="180">工号: ${admin.cno}
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
   <h3>仓&nbsp;&nbsp;库&nbsp;&nbsp;及&nbsp;&nbsp;商&nbsp;&nbsp;品&nbsp;&nbsp;信&nbsp;&nbsp;息&nbsp;&nbsp;管&nbsp;&nbsp;理&nbsp;&nbsp;系&nbsp;&nbsp;统</h3>
  </div>
  <div id="div3">
  
   
   <div id="div31">
   	<a href="/WarehouseManage/AdminEdit.jsp"><button class="btn btn-success"  style="width:100%;height:95%;"> 管理个人信息</button></a>
   </div>
    <div id="div32">
   	<a href="/WarehouseManage/list.do?select=goods"><button class="btn btn-success"style="width:100%;height:95%;"> 管理商品信息</button></a>
   </div>
   <div id="div39">
   	<a href="/WarehouseManage/list.do?select=user"><button class="btn btn-success"style="width:100%;height:95%;"> 用户管理</button></a>
   </div>
    <div id="div33">
   	<a href="/WarehouseManage/list.do?select=warehouses"><button class="btn btn-success"style="width:100%;height:95%;"> 管理仓库信息</button></a>
   </div>
   
    <div id="div34">
   	<a href="/WarehouseManage/listOrder.do?select=admin"><button class="btn btn-success"style="width:100%;height:95%;"> 商品出入库</button></a>
   </div>
   <div id="div35">
   	<a href="/WarehouseManage/list.do?select=client"><button class="btn btn-success"style="width:100%;height:95%;"> 客户管理</button></a>
   </div>
   <div id="div36">
   	<a href="/WarehouseManage/ListRecord.do?select=orecord"><button class="btn btn-success"style="width:100%;height:95%;"> 出入库记录</button></a>
   </div>
   <div id="div37">
   	<a href="/WarehouseManage/AddGoods.jsp"><button class="btn btn-success"style="width:100%;height:95%;"> 出入库记录</button></a>
   </div>
    <div id="div38">
   	<a href="AddWarehouse.jsp"><button class="btn btn-success"style="width:100%;height:95%;"> 添加仓库</button></a>
   </div>

  </div>
  <div id="div4">
  
   
   
   
   
   
   
   <table border=
   "2" width=70% height=70% align=center > 
   <tr>
   <td colspan="2">
   <h2>请在下方区域修改货物信息</h2>
   </td>
   </tr>
   
    <tr>
   <td align="center"  colspan="2" height=20%>
   <p><img  src="${good.img}"width=100px height=100px /> </p>
   
   <form action="/WarehouseManage/uploadphoto?select=good&id=${good.id}" method="post" enctype="multipart/form-data">
    上传照片:<input type="file" name="photo">
    <button type="submit"  class="btn btn-success" value="上传" name="upload">上传</button>
    </form>
   </td>
   </tr>
<form method="post" action="/WarehouseManage/Update.do">
    <tr>
   <td width=50%>
  <span class="input-group-addon" >商品&nbsp;&nbsp;名称:</span> <p><input type="text" value="${good.name }" name="Name"  placeholder="请在这里输入名称"  class="form-control"  style="width: 250px ; "> </p>
   </td>
   <td>
 <span class="input-group-addon" >商品&nbsp;&nbsp;编号:</span><p><input type="text" value="${good.gno }" name="Gno"  placeholder="请在这里输入编号"  class="form-control"  style="width: 250px ; "> </p>
   </td>
   
  

  
   </tr>
   
   <tr>
   <td>
 <span class="input-group-addon" >商品&nbsp;&nbsp;数量:</span>
 <p><input type="text" value="${good.num }" name="Num"  placeholder="请在这里输入数量"  class="form-control"  style="width: 250px ; "> </p>		    
			 </td>
   <td>
   <span class="input-group-addon" >进&nbsp;货&nbsp;价:</span>
   <input type="text" value="${good.iprice }" name="Iprice"  placeholder="请在这里输入进货价"  class="form-control"  style="width: 250px ; ">
   </td>
   </tr>
   
   <tr>
   <td>
 <span class="input-group-addon" >出&nbsp;货&nbsp;价:</span>
<input type="text" value="${good.oprice }" name="Oprice"  placeholder="请在这里输入出货价"  class="form-control"  style="width: 250px ; ">	    
			 </td>
   <td>
   <span class="input-group-addon" >所在&nbsp;&nbsp;仓库:</span>
   <input type="text" value="${good.warehouse }" name="Warehouse"  placeholder="请在这里输入仓库编号"  class="form-control"  style="width: 250px ; ">
   </td>
   </tr>
   
    <tr>
   <td>
 <span class="input-group-addon" >数量&nbsp;&nbsp;上限:</span>
<input type="text" value="${good.max }" name="Max"  placeholder="请在这里输入"  class="form-control"  style="width: 250px ; ">	    
			 </td>
			 
			 
   <td>
   <span class="input-group-addon" >数量&nbsp;&nbsp;下限:</span>
   <input type="text" value="${good.min }" name="Min"  placeholder="请在这里输入"  class="form-control"  style="width: 250px ; ">
   </td>
   </tr>
   
   <tr>
   <td>
   <span class="input-group-addon" >选择&nbsp;&nbsp;商品类别:</span>
  <select id="Sort" class="form-control" name="Sort" >
						<option value="食品">食品</option>
						<option value="电器">电器</option>
						<option value="日用品">日用品</option>
						
					    </select>
   </td>
   </tr>
   
   
   <tr>
   <td colspan="2"  >
    <div style='overflow-y:auto;height:180px;'>
   <span class="input-group-addon" style="width: 950px ; ">详细&nbsp;&nbsp;信息:</span>
   <textarea    style="height:90%;width: 100% ; " class="form-control" 
 NAME="remark"  placeholder="若有需要则填"  rows="10" cols="15">${good.remark }</textarea>
   </div>
   </td>
 
   </tr>
   
   
   
   <input type="hidden" name="gid" value="${good.id }">
    <input type="hidden" name="Specs" value="${good.specs }">
       <input type="hidden" name="Img" value="${good.img }">
        <input type="hidden" name="select" value="goods">
   
   <tr>
   <td style="text-align:center; ">
   <a href="GoodsEdit.jsp"><button type ="button" class="btn btn-success"  style="width:30%;"> 重置</button></a>
   
   </td>
   <td style="text-align:center; ">
 <button type="submit"class="btn btn-success"  name="submit"  style="width:40%;">确&nbsp;&nbsp;定</button>
   </td>
   </tr>
   
   
   
   
   
   
   
   
   </table>
 

   
   
   
   
   
   
   
  </div>
  

  
  
  
  </div>

   
   
   
   
  </body>
</html>
