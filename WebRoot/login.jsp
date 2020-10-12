<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<link rel="stylesheet" type="text/css" href="login.css"/>
    <script type="text/javascript" src="login.js"></script>
    
    <style>
    
    body {    background-image: url("img/358330-106.jpg");;
background-size: 100%;
background-repeat: no-repeat;
}
    </style>
    
    <script type="text/javascript">
    	function check(){
    		var flag = true;
    		var admin = document.getElementById("username").value;
    		var password = document.getElementById("password").value;
    		
		 if ("" == admin){
				alert("请输入账号！");
				flag = false;
				return false;
			}
			else if ("" == password){
				alert("请输入密码！");
				flag = false;
				return false;
			}
			if(flag == true){
				//form.submit();
				return true;
			}
		}
    </script>
    
  </head>
 <%	//session.invalidate();  %>
  <body >
  <div id="login_frame"> 
     <p id="image_logo"><img src="img/SplashScreen.png" width="50px" height= "40px"/></p>   
     <form method="post" action="/WarehouseManage/login.do">        
     <p><label class="label_input">用户名</label><input type="text" name="username" id="username" class="text_field"/></p>  
     <p><label class="label_input">密码</label><input type="password" name="password" id="password" class="text_field"/></p>     
     <div id="login_control">      <input type="submit"  name="submit" id="btn_login" value="登录" onclick="return check();"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     						<!--  <a href="/WarehouseManage/Register.do"><button id="btn_login" class="label_input"> 注册</button></a>	 -->           
      
     <br>
     		选择登录身份：<select class="form-control" name="option" > 
     		<option  value="admin">管理员</option>
     		<option  value="client">客户</option>
     		</select>
     </div>    
     </form>
     
     
      <FORM action="/WarehouseManage/Register.jsp" method=post name=form>
	
	&nbsp;&nbsp;&nbsp;请选择注册身份 &nbsp;&nbsp;&nbsp;&nbsp;<select name="roption">
	<option value="admin">管理员</option>
	<option value="client">客户</option>
	
    </select>
 <a href="/WarehouseManage/Register.jsp"><button class="btn btn-success"id="btn_login">注册账号</button>&nbsp; &nbsp;&nbsp; &nbsp;</a>
</FORM>
 </div>


  </body>
</html>
