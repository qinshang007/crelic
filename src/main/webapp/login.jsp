<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文物知识库登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="scripts/myscripts.js" charset="gb2312"></script>
	<script src="scripts/jquery.js"></script>
	<script src="scripts/jsonRespUtils.js" type="text/javascript" ></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
  <body>
  	<center>
	    <div class="login">
	    	<div class="ltitle">
	    		<h1>文物知识库</h1>
	    	</div>
	    	<div class="left"><img style="width:382px;height:332px;" src="images/bg.jpg"></div>
	    	<div class="right">
	    		<form action="#" method="post">
		    		<div class="up">
			    		<span>登录名:</span>
			    		<input id="userName" type="text" name="userName" value="手机号/会员号/邮箱" style="width:300px;" onclick="clearDefaultText(this,'手机号/会员号/邮箱')" />
			    		<span>登录密码:</span>
			    		<input id="password" type="password" name="password" style="width:300px;" />
		    		</div>
	    		</form>
	    		<div class="down">
		    		<input id="lgbtn" type="image" src="images/login.jpg" style="height:36px;width:300px;" alt="Submit"/>
		    		<input id="regbtn" type="image" src="images/regist.jpg" style="height:36px;width:300px;" alt="Reset" />	    		
	    		</div>
	    	</div>
	    </div>
    </center>	
  </body>
  
  <script type=text/javascript>
	$("#lgbtn").click(function () {
		var userName = encodeURI($("#userName").val());
		var password = encodeURI($("#password").val());
		 var url="/crelic/home/login.do";
         $.post(url,{userName:userName,password:password},function(data){
        	 var jresp = new JsonRespUtils(data);
        	 if (jresp.isSuccessfully()){
        		location.href="/crelic/home/index.do";
              }else{
            	  alert(jresp.getMessage());
              }
         });
	})

	$("#regbtn").click(function () {
		var userName = encodeURI($("#userName").val());
		var password = encodeURI($("#password").val());
		 var url="/crelic/home/addUser.do";
         $.post(url,{userName:userName,password:password},function(data){
        	 var jresp = new JsonRespUtils(data);
        	 if (jresp.isSuccessfully()){
        		alert("注册成功！");
        		location.href="/crelic/home/index.do";
              }else{
            	  alert(jresp.getMessage());
              }
         });
	})

  </script>
</html>
