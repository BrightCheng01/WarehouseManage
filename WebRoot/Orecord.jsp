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
  
  <script>
        $(function () {
            $("ul.pagination li.disabled a").click(function () {
                return false;
            });
        });
    </script>
    
   
    
    <base href="<%=basePath%>">
    
    <title>进货记录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="mainpage.css">
	

  </head>
  
  <body>
  
  
  
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
   	<a href="/WarehouseManage/AddGoods.jsp"><button class="btn btn-success"style="width:100%;height:95%;"> 添加商品</button></a>
   </div>
   <div id="div38">
   	<a href="AddWarehouse.jsp"><button class="btn btn-success"style="width:100%;height:95%;"> 添加仓库</button></a>
   </div>
   
  </div>
  <div id="div4">

   <ul class="breadcrumb">
	<li><a href="/WarehouseManage/ListRecord.do?select=orecord">出货记录</a></li>
	<li><a href="/WarehouseManage/ListRecord.do?select=irecord">进货记录</a></li>
	
</ul>
   
   
   <table class="table table-striped table-bordered table-hover table-condensed">
       
        <caption>出货记录列表 - 共${page.total}条</caption>

        <thead>
        
        <tr class="success">
        
    		 <th>出货单号</th>
            <th>商品名称</th>
            <th>商品编号</th>
            <th>商品数量</th>
             <th>出货价</th>
            <th>总价</th>
            <th>客户名称</th>
            <th>客户编号</th>
            <th>联系人</th>
            <th>电话</th>           
			<th>地址</th>			
			<th>出货日期</th>
			<th>经办人</th>
	
					
			
			
			
			
            
        </tr>
        </thead>

        <tbody>
        
        <c:forEach items="${orecords}" var="s" varStatus="status">
            
        
            <tr>
            	<td style="text-align:center; vertical-align:middle;">${s.ono}</td>
                <td style="text-align:center; vertical-align:middle;">${s.oname}</td>
                <td style="text-align:center; vertical-align:middle;">${s.ogno}</td>
                 <td style="text-align:center; vertical-align:middle;">${s.onum}</td>
     
   				  <td style="text-align:center; vertical-align:middle;">${s.oprice}</td>
            	
            	<td style="text-align:center; vertical-align:middle;">${s.totaloprice}</td>
            	<td style="text-align:center; vertical-align:middle;">${s.cname}</td>
            	
           		<td style="text-align:center; vertical-align:middle;">${s.cno}</td>
      
            	<td style="text-align:center; vertical-align:middle;">${s.contact}</td>
            	
            	<td style="text-align:center; vertical-align:middle;">${s.tel}</td>
            	<td style="text-align:center; vertical-align:middle;">${s.address}</td>
            	
           		<td style="text-align:center; vertical-align:middle;">${s.date}</td>
                 
                  <td style="text-align:center; vertical-align:middle;">${s.operator}</td>
            
                  
                  
               
              
                
 
                
               
            </tr>
            
        
        
    
        
        </c:forEach>
					
        </tbody>
    </table>
   
   <nav  style="margin:0 auto; width:300px ">
    <ul class="pagination">
        <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
            <a href="/WarehouseManage/ListRecord.do?page.start=0&&select=orecord">
                <span>«</span>
            </a>
        </li>

        <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
            <a href="/WarehouseManage/ListRecord.do?page.start=${page.start-page.count}&select=orecord">
                <span>‹</span>
            </a>
        </li>

        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">

            <c:if test="${status.count*page.count-page.start<=30 && status.count*page.count-page.start>=-10}">
                <li <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                    <a
                            href="/WarehouseManage/ListRecord.do?page.start=${status.index*page.count}&select=orecord"
                            <c:if test="${status.index*page.count==page.start}">class="current"</c:if>
                    >${status.count}</a>
                </li>
            </c:if>
        </c:forEach>

        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="/WarehouseManage/ListRecord.do?page.start=${page.start+page.count}&select=orecord">
                <span>›</span>
            </a>
        </li>
        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="/WarehouseManage/ListRecord.do?page.start=${page.last}&select=orecord">
                <span>»</span>
            </a>
        </li>
    </ul>
</nav>
   
   
   
   
   
   
   
   
   
  </div>
  

  
  
  
  </div>
  
  
  
  </body>
</html>
