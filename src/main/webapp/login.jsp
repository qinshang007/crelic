<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
  <body>
  	<center>
	    <div class="login">
	    	<div class="ltitle">
	    		<h1>登录/注册 &nbsp;&nbsp;文物知识库</h1>
	    	</div>
	    	<div class="left"><img style="width:382px;height:332px;" src="images/bg.jpg"></div>
	    	<div class="right">
	    		<form action="/crelic/home/login.do" method="post">
		    		<div class="up">
			    		<span>登录名:</span>
			    		<input type="text" name="userName" value="手机号/会员号/邮箱" style="width:300px;" />
			    		<span>登录密码:</span>
			    		<input type="password" name="password" style="width:300px;" />
		    		</div>
		    		<div class="down">
		    		<input type="image" src="images/login.jpg" style="height:36px;width:300px;" alt="Submit" />
		    		<input type="image" src="images/regist.jpg" style="height:36px;width:300px;" alt="Reset" />	    		
		    		</div>
	    		</form>
	    	</div>
	    </div>
    </center>	
  </body>
</html>
