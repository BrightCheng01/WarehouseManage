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
    
    <script type="text/javascript">
$(function() {
$(".add-plus-input .add").click(function() {
var $num = $(this).next(".num");
var number = $num.attr("value");
$num.attr("value",parseInt(number) + 1);
});
$(".add-plus-input .plus").click(function() {

var $num = $(this).prev(".num");
var number = $num.attr("value");
if(parseInt(number)>0)
$num.attr("value",parseInt(number) - 1);
});
})
</script>
    
    <base href="<%=basePath%>">
    
    <title>个人订单查询</title>
    
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
  
  <body>
  
  
  
  <body>
  
  <div id="frame">
  <div id="div1">
 
  <table border="0" width=100% height=100%>
  <tr>
  <td width="65" height="65">
      <img src="${client.img}"width=100% height=100% /> 
  </td>
   <td style="padding: 10px;"width="60">${client.name}
  </td>
  <td width="180">帐号: ${client.cno}
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

  
   
   
   <table class="table table-striped table-bordered table-hover table-condensed">
       
        <caption>订单列表 - 共${page.total}条</caption>

        <thead>
        
        <tr class="success">
        
    		 <th>订单号</th>
            <th>货号</th>
            <th>商品名称</th>
            <th>数量</th>
      
                   
			<th>价格</th>
			<th>收货地址</th>			
			
			<th>总计</th>
			<th>日期</th>
			<th>订单状态</th>
			<th></th>
            <th></th>
			
            
        </tr>
        </thead>

        <tbody>
        
        <c:forEach items="${orderforms}" var="s" varStatus="status">
            
        
            <tr>
            	<td style="text-align:center; vertical-align:middle;">${s.ordercode}</td>
                <td style="text-align:center; vertical-align:middle;">${s.gno}</td>
                <td style="text-align:center; vertical-align:middle;">${s.name}</td>
                 <td style="text-align:center; vertical-align:middle;">${s.num}</td>
     
      
            	<td style="text-align:center; vertical-align:middle;">${s.price}</td>
            	<td style="text-align:center; vertical-align:middle;">${s.address}</td>
            	
            	<td style="text-align:center; vertical-align:middle;">${s.totalprice}</td>
            	<td style="text-align:center; vertical-align:middle;">${s.date}</td>
           		<td style="text-align:center; vertical-align:middle;">${s.isdone}</td>
                 
                  
            
                  
                  
               
              


 
                
               
            </tr>
            
        
        
    
        
        </c:forEach>
					
        </tbody>
    </table>
   
   <nav  style="margin:0 auto; width:300px ">
    <ul class="pagination">
        <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
            <a href="/WarehouseManage/listOrder.do?page.start=0&&select=client">
                <span>«</span>
            </a>
        </li>

        <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
            <a href="/WarehouseManage/listOrder.do?page.start=${page.start-page.count}&select=client">
                <span>‹</span>
            </a>
        </li>

        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">

            <c:if test="${status.count*page.count-page.start<=30 && status.count*page.count-page.start>=-10}">
                <li <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                    <a
                            href="/WarehouseManage/listOrder.do?page.start=${status.index*page.count}&select=client"
                            <c:if test="${status.index*page.count==page.start}">class="current"</c:if>
                    >${status.count}</a>
                </li>
            </c:if>
        </c:forEach>

        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="/WarehouseManage/listOrder.do?page.start=${page.start+page.count}&select=client">
                <span>›</span>
            </a>
        </li>
        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="/WarehouseManage/listOrder.do?page.start=${page.last}&select=client">
                <span>»</span>
            </a>
        </li>
    </ul>
</nav>
   
   
  </div>
  

  
  
  
  </div>
  
  
  
  </body>
</html>
