<%@ page language="java" import="java.util.*,com.crelic.model.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文物知识库</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="scripts/myscripts.js" charset="gb2312"></script>
	<script src="scripts/jquery.js"></script>
	<script src="scripts/SuperSlide.js"></script>
	<script src="scripts/scroller_roll.js"></script>
		
	<link href="css/5icool.org.css" rel="stylesheet" type="text/css" />
	<link href="css/scroller_roll.css" rel="stylesheet" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="css/style.css">

	<script type="text/javascript">
		$(document).ready(myFunction);
		
		 $(function() {
			 $("#scroller_roll3").scroller_roll({
                 title_show: 'enable',//enable  disable
                 time_interval: '30',
                 window_background_color: "none",
                 window_padding: '1',
                 border_size: '0',
                 border_color: '#0099CC',
                 images_width: '104',
                 images_height: '100',
                 images_margin: '5',
                 title_size: '12',
                 title_color: 'black',
                 show_count: '5'
             });
         });
		 
		 function search()
		 {
			 var keyWord = document.getElementById("keyWord").value;
			 if(keyWord==""||keyWord==null||keyWord=="请输入检索的内容")
				 alert("检索内容不能为空！");
			 else{
				 keyWord = encodeURIComponent(keyWord);
				 window.location.href = "/crelic/home/search.do?keyWord="+keyWord+"&&pageNow=1";
			 }
		 }
		 
	</script>

  </head>
  
  <body>
  	<div class="top">
		<div class="title">
			<c:choose>
				<c:when test="${not empty sessionScope.username}">
					<span>欢迎您,${sessionScope.username}!|<a href="/crelic/home/collections.do?pageNow=1">收藏夹</a>|<a href="/crelic/home/logout.do">退出</a></span>
				</c:when>
				<c:otherwise>
					<span><a href="/crelic/login.jsp">登录</a>|<a href="/crelic/home/collections.do?pageNow=1">收藏夹</a></span>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="search">
			<span class="type">文物信息分类</span>
			<input id="keyWord" class="searchBox" type="text" name="search" value="请输入检索的内容" 
				onclick="clearDefaultText(this,'请输入检索的内容')"/>
			<div class="searchSummit" onclick="search()"></div>		
		</div>
	</div>
  	 	
    <div class="content">
		<div class="content-left" >
			<div class="ltitle"><img src="images/movable.png" height="32" width="143"/></div>
			<div id="movediv" class="content-left-up"  ></div>
			<div class="ltitle"><img src="images/unmovable.png" height="32" width="143" /></div>
			<div id="unmovediv" class="content-left-down" ></div>
		</div>	
		<div class="content-middle">
			<div class="ctitle"><img src="images/hotsearch.jpg"/></div>
			<div id="index_banner">
			  <div class="burder">
			    <div id="slideBox" class="slideBox">
			      <div class="bd">
			        <ul>
			        	<c:forEach var="cb" items="${hsList}">
				          <li> 
				          	<a target="_blank" href="/crelic/home/display.do?culId=<c:out value="${cb.identifier}"/>"><img src="<%=url %>/crelicBase/upload/<c:out value="${cb.mainpic}"/>"/></a>
				            <div class="burder_content"> <span class="burder_content_type"><c:out value="${cb.title}"/></span> <a target="_blank" class="burder_content_title">形态描述</a>
				            <p class="burder_content_content"><c:out value="${cb.shape}"/></p>
				            <a class="burder_content_lookall" target="_blank" href="/crelic/home/display.do?culId=<c:out value="${cb.identifier}"/>">进入详情页&gt;</a> </div>
				          </li>
			        	</c:forEach>
			        </ul>
			      </div>
			      <div class="hd">
			        <ul>
			         	<c:forEach var="cb" items="${hsList}">
							<li>
								<a href="/crelic/home/display.do?culId=<c:out value="${cb.identifier}"/>"><c:out value="${cb.title}"/><img src="images/pmd_hover.gif"/></a>
							</li>
			        	</c:forEach>
			        </ul>
			      </div>
			    </div>
			    <script type="text/javascript">jQuery(".slideBox").slide({ mainCell:".bd ul",effect:"left",autoPlay:true} );</script> 
			  </div>
			</div>	
			<div class="ctitle"><img src="images/newobject.jpg"/></div>
			<div id="scroller_roll3" class="scroller_roll">
	            <ul>
	                <c:forEach var="cb" items="${lcList}">
						<li>
						 <a href="/crelic/home/display.do?culId=<c:out value="${cb.identifier}"/>" title="<c:out value="${cb.title}"/>">
						 	<img src="<%=url %>/crelicBase/upload/<c:out value="${cb.mainpic}"/>" width="105" height="100" alt="title"/>
						 </a>
						</li>
			        </c:forEach>
	            </ul>
	            <div style="clear: both"></div>
        	</div>
		</div>	
		<div class="content-right">
			<div class="rtitle"><img src="images/announcement.png" height="30" width="136"/></div>
			<div class="news">
				<ul>
					<li>.国家文物局召开领导班子专题</li>
					<li>.国家文物局召开领导班子专题</li>
					<li>.国家文物局召开领导班子专题</li>
					<li>.国家文物局召开领导班子专题</li>
				</ul>
			</div>
			<div class="rtitle"><img src="images/friendlylink.png" height="30" width="136" /></div>
			<div class="link">
				<ul>
					<li><a href="#"><img alt="" src="images/zju.jpg"></a></li>
					<li><a href="#"><img alt="" src="images/zjwwj.jpg"></a></li>
					<li><a href="#"><img alt="" src="images/zjbwg.jpg"></a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="tail"></div>
  </body>
</html>
