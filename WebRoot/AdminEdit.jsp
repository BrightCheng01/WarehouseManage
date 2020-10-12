<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>




<%@page import="Bean.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  



<script type= text/JavaScript> 
 function getElements(name){
    var returns = document.getElementsByName(name);
    if(returns.length > 0) return returns;
    returns = new Array();
    var e = document.getElementsByTagName('span');
    for(i = 0; i < e.length; i++) {
        if(e[i].getAttribute("name") == name) {
            returns[returns.length] = e[i];
        }
    }
    return returns;
}	

function initradio(rName,rValue){  
           var rObj = getElements(rName);
           for(var i = 0;i < rObj.length;i++){  
               if(rObj[i].value == rValue){  
                   rObj[i].checked =  'checked';  
               }  
           }  
       } 
       
       var s='女';
              initradio('sex',s); 
            
  </script>
  
    <base href="<%=basePath%>">
    
    <title>管理员编辑</title>
    
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
 <img src="${sessionScope.admin.img}"width=100% height=100% /> 
  </td>
   <td style="padding: 10px;"width="60">${sessionScope.admin.name}
  </td>
  <td width="180">工号: ${sessionScope.admin.cno}
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
   	<a href="AdminEdit.jsp"><button class="btn btn-success"  style="width:100%;height:95%;"> 管理个人信息</button></a>
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
   	<a href="/WarehouseManage/AddGoods.jsp"><button class="btn btn-success"style="width:100%;height:95%;"> 添加商品</button></a>
   </div>
   
   <div id="div38">
   	<a href="AddWarehouse.jsp"><button class="btn btn-success"style="width:100%;height:95%;"> 添加仓库</button></a>
   </div>
   
  </div>
  <div id="div4">
  
   
  
    <table border="1" width=70% heigh=80% align=center style="margin-top: 50px"> 
   <tr>
   <td colspan="2">
   <h2>请在下方区域修改个人信息</h2>
   </td>
   </tr>
   
    <tr>
   <td align="center"  colspan="2" height=20%>
   <p><img   src="${admin.img}"width=100px height=100px /> </p>
   
   <form action="/WarehouseManage/uploadphoto?select=admin&id=${admin.id}" method="post" enctype="multipart/form-data">
    上传照片:<input type="file" name="photo"><br/><br/>
    <button type="submit"  class="btn btn-success" value="上传" name="upload">上传</button>
    </form>
   </td>
   </tr>
<form method="post" action="/WarehouseManage/AEdit.do">
    <tr>
   <td width=50%>
  <span class="input-group-addon" >姓&nbsp;&nbsp;名:</span> <p><input type="text" value="${admin.name }" name="name"  placeholder="请在这里输入名字"  class="form-control"  style="width: 250px ; "> </p>
   </td>
   <td>
 <span class="input-group-addon" >工&nbsp;&nbsp;号:</span><p><input type="text" value="${admin.cno }" name="cno"  placeholder="请在这里输入工号"  class="form-control"  style="width: 250px ; "> </p>
   </td>
   
  

  
   </tr>
   
   <tr>
   <td>
  <span class="input-group-addon" >性&nbsp;&nbsp;别:</span>
  <select id="sex" class="form-control" name="sex" >
						<option value="男">男</option>
						<option value="女">女</option>
						
					    </select>
					    
			    
			 </td>
   <td>
   <span class="input-group-addon" >修改&nbsp;&nbsp;密码:</span>
   <input  type="text"  style="height:31px;width: 250px ; " class="form-control" 
 NAME="pwd"  placeholder="若有需要则填">
   </td>
   </tr>
   
   <tr>
   <td colspan="2" height=80%>
   <span class="input-group-addon" style="width: 950px ; ">备&nbsp;&nbsp;注:</span>
   <textarea  name="remark"  style="height:80%;width: 100% ; " class="form-control" 
 NAME="remark"  placeholder="若有需要则填"  rows="10" cols="15">${admin.remark }</textarea>
   </td>
 
   </tr>
   
   <tr>
   <td style="text-align:center; ">
   <a href="AdminEdit.jsp"><button type ="button" class="btn btn-success"  style="width:30%;"> 重置</button></a>
   
   </td>
   <td style="text-align:center; ">
 <button type="submit"class="btn btn-success"  name="submit"  style="width:40%;height:30%;">确&nbsp;&nbsp;定</button>
   </td>
   </tr>
   
   
   
   
   
   
   
   
   </table>
   <input type="hidden" name="oldpwd" value="${admin.pwd}">
   <input type="hidden" name="select" value="admin">
   <input type="hidden" name="img" value="${admin.img}">
   
   </form>
  </div>
  

  
  
  
  </div>

 
      
  </body>
</html>
