<%@ page language="java" import="java.util.*,com.crelic.model.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
CulturalBean cb = (CulturalBean)request.getAttribute("cb");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="scripts/myscripts.js" charset="gb2312"></script>
	<script src="scripts/jquery.js"></script>
	<script src="scripts/base.js" type=text/javascript></script>
	<script src="scripts/lib.js" type=text/javascript></script>
	<script src="scripts/163css.js" type=text/javascript></script>
	
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link href="css/5icool.org.css" rel="stylesheet" type="text/css" />
	<link href="css/display.css" type="text/css" rel="stylesheet">
	<link href="css/info.css" type="text/css" rel="stylesheet">		

	<script type=text/javascript>
	
		$(function(){			
		   $(".jqzoom").jqueryzoom({
				xzoom:400,
				yzoom:400,
				offset:10,
				position:"right",
				preload:1,
				lens:1
			});
			$("#spec-list").jdMarquee({
				deriction:"left",
				width:350,
				height:56,
				step:2,
				speed:4,
				delay:10,
				control:true,
				_front:"#spec-right",
				_back:"#spec-left"
			});
			$("#spec-list img").bind("mouseover",function(){
				var src=$(this).attr("src");
				$("#spec-n1 img").eq(0).attr({
					src:src.replace("\/n5\/","\/n1\/"),
					jqimg:src.replace("\/n5\/","\/n0\/")
				});
				$(this).css({
					"border":"2px solid #ff6600",
					"padding":"1px"
				});
			}).bind("mouseout",function(){
				$(this).css({
					"border":"1px solid #ccc",
					"padding":"2px"
				});
			});				
		});
		
		function navigation(name)
		{
			$("#shapeDiv").hide();
			$("#funcDiv").hide();
			$("#techonologyDiv").hide();
			$("#cultureDiv").hide();
			
			var showDiv = name+"Div";
			$("#"+showDiv).show();
		}
		
		function collect()
		{
			var culId = '${cb.identifier}';
			var cultype = '${cb.classification}'
			var url = "/crelic/home/collect.do";
			var pars  = "?culId="+culId+"&cultype="+cultype;
            $.ajax({  
                type:"post",//请求方式  
                url:url+pars,//发送请求地址 
                timeout:30000,//超时时间：30秒  
                dataType:"json",//设置返回数据的格式  
                //请求成功后的回调函数 data为json格式  
                success:function(data){  
                  	$("#collect").hide();
                  	$("#delcollect").show();
                	alert("收藏成功!"); 
               },  
               //请求出错的处理  
               error:function(){  
                   alert("请求出错");  
               }  
            });  
		}
		
		function delcollect()
		{
			var culId = '${cb.identifier}';
			var cultype = '${cb.classification}'
			var uri = "/crelic/home/delcollect.do";
			var pars  = "?culId="+culId;
            $.ajax({  
                type:"post",//请求方式  
                url:uri+pars,//发送请求地址  
                timeout:30000,//超时时间：30秒  
                dataType:"json",//设置返回数据的格式  
                //请求成功后的回调函数 data为json格式  
                success:function(data){  
				  $("#delcollect").hide(); 
				  $("#collect").show();
				  alert("操作成功!");
               },  
               //请求出错的处理  
               error:function(){  
                   alert("请求出错");  
               }  
            });  
		}
		
		function showby()
		{
			 $("#bydiv").show(); 
		}

		function biaoyin()
		{
			var userName = '${sessionScope.username}';
			var culId = '${cultural.identifier}';
			var cultype = '${cultural.classification}'
			var by = $("#byinput").val();
			var uri = "/crelic/home/biaoyin.do";
			var pars  = "?userName="+userName+"&culId="+culId+"&cultype="+cultype+"&by="+by;
            $.ajax({  
                type:"post",//请求方式  
                url:uri+pars,//发送请求地址  
                timeout:30000,//超时时间：30秒  
                dataType:"json",//设置返回数据的格式  
                //请求成功后的回调函数 data为json格式  
                success:function(data){  
				  $("#bydiv").hide(); 
				  alert("操作成功!");
               },  
               //请求出错的处理  
               error:function(){  
                   alert("请求出错");  
               }  
            });  
		}

		 function search()
		 {
			 var keyWord = document.getElementById("keyWord").value;
			 if(keyWord==""||keyWord==null)
				 alert("检索内容不能为空！");
			 else{
				 keyWord = encodeURIComponent(keyWord);
				 window.location.href = "/crelic/home/search.do?keyWord="+keyWord+"&&pageNow=1";
			 }
		 }
		 
		function display(){
			var type = $("#type").val();
			if(type=='器物'){
				//基本信息
				$("#locationDiv").hide();
				//造型要素
				$("#structureDiv").hide();
				$("#decorationDiv").hide();
				//文化要素
				$("#socialHistoryInfoDiv").hide();
			}else if(type=='织物'){
				//基本要素
				$("#locationDiv").hide();
				//造型要素
				$("#shapeDiv2").hide();
				$("#structureDiv").hide();
				$("#decorationDiv").hide();
				//功能要素
				$("#c_usageDiv").hide();
				//文化要素
				$("#socialHistoryInfoDiv").hide();
			}else if(type='建筑'){
				//基本信息
				$("#placeOfOriginDiv").hide();
				$("#excavationDateDiv").hide();
				$("#excavationPlaceDiv").hide();
				$("#currentLocationDiv").hide();
				$("#exhibitonHistoryDiv").hide();
				//造型要素
				$("#shapeDiv2").hide();
				$("#patternDiv").hide();
				//功能要素
				$("#sceneDiv").hide();
				$("#c_usageDiv").hide();
				$("#symbolicDiv").hide();
				//文化要素
				$("#historyInfoDiv").hide();
				$("#folkloreDiv").hide();
			}else if(type=='壁画'){
				//基本信息
				$("#locationDiv").hide();
				//造型要素
				$("#shapeDiv2").hide();
				$("#structureDiv").hide();
				$("#decorationDiv").hide();
				//功能要素
				$("#sceneDiv").hide();
				$("#c_usageDiv").hide();
				//文化要素
				$("#socialHistoryInfoDiv").hide();
			}
		}
		 
		function init()
		{
			var isCollect='${isCollect}';
			if(isCollect=='1')
			{
				$("#collect").hide();
				$("#delcollect").show();
			}
			display();
		}
		
	</script>
	
  </head>
  
  <body onload="init()">
  
    <div class="top">
		<div class="title">
			<c:choose>
				<c:when test="${not empty sessionScope.username}">
					<span>欢迎您,${sessionScope.username}!|<a href="/crelic/home/collections.do?pageNow=1">收藏夹</a>|<a href="/crelic/home/index.do">首页</a></span>
				</c:when>
				<c:otherwise>
					<span><a href="/crelic/login.jsp">登录</a>|<a href="/crelic/home/index.do">首页</a></span>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="search">
			<span class="type">文物信息分类</span>
			<input class="searchBox" type="text" name="search" id="keyWord" value="请输入检索的内容" 
				onclick="clearDefaultText(this,'请输入检索的内容')" />
			<div class="searchSummit" onclick="search()"></div>		
		</div>
	</div>
  
    	<div class="display">
   		<div class="left">
   			<div class="up">
	   			<div class="dltitle"><img src="images/display/recommend.jpg" /></div>
	   			<div class="dcontent">
	   				<ul>
		                <c:forEach var="cul" items="${recommList}" end="3">
		                	<li><a href="/crelic/home/display.do?culId=${cul.identifier}" title="${cul.title}"><img src="<%=url %>/crelicBase/upload/${cul.mainpic}" width="105" height="100" alt="title"/></a></li>
		                </c:forEach>
	   				</ul>
	   			</div>
	   		</div>
	   		<div class="down">
	   			<div class="dltitle"><img src="images/display/othersee.jpg" /></div>
	   			<div class="dcontent">
	   				<ul>
		                <c:forEach var="cul" items="${otcl}">
		                	<li><a href="/crelic/home/display.do?culId=${cul.identifier}" title="${cul.title}"><img src="<%=url %>/crelicBase/upload/${cul.mainpic}" width="105" height="100" alt="title"/></a></li>
		                </c:forEach>
	   				</ul>
	   			</div>
   			</div>
   		</div>
   		<div class="right">
   			<div class="up">
   				<input type="hidden" id="type" name="type" value='<%=cb.getType() %>' />
	   			<div class="rtitle"><span>名称：&nbsp;<%=cb.getTitle() %></span></div>
		   		<div class="picinfo">
			   		<div id=preview>
						<div class=jqzoom id=spec-n1 onClick="window.open('http://www.workcss.com/')"><IMG height=350
						src="<%=url %>/crelicBase/upload/<%=(String)cb.getMainpic() %>" jqimg="<%=url %>/crelicBase/upload/<%=(String)cb.getMainpic() %>" width=350>
						</div>
						<div id=spec-n5>
							<div class=control id=spec-left>
								<img src="images/display/left.gif" />
							</div>
							<div id=spec-list>
								<ul class=list-h>
									<%
										int len = cb.getEwPicture().size();
										if(len == 0){
									%>
										<li><img src="<%=url %>/crelicBase/upload/<%=(String)cb.getMainpic()%>" /> </li>
									<%
										}else if(len >= 6)
											for(int i=0; i<len; i++)
											{
									%>
												<li><img src="<%=url %>/crelicBase/upload/<%=(String)cb.getEwPicture().get(i).getFileSrc() %>" /> </li>
									<% 
											}
										else
										{
											int count = 0;
											while(count < 8)
											{
									%>
												<li><img src="<%=url %>/crelicBase/upload/<%=(String)cb.getEwPicture().get(count%len).getFileSrc() %>" /> </li>
									<% 
												count++;
											}
										}
									%>
								</ul>
							</div>
							<div class=control id=spec-right>
								<img src="images/display/right.gif" />
							</div>					
					  	</div>
					</div>
					<div class="picbutton">
						<div id="bigpic" class="buttonimg" onclick="showby();"><img src="images/display/biaoying.jpg" /></div>
						<div id="collect" class="buttonimg" onclick="collect()"><img src="images/display/collect.jpg" /></div>
						<div id="delcollect" class="buttonimg" style="display:none" onclick="delcollect()"><img src="images/display/delcollect.jpg" /></div>												
					</div>				
				</div>
				<div class="wordinfo">
					<table>
					  <tr>
					    <td class="tdpro1">其他名称：</td>
					    <td class="tdval1"><%=cb.getUsed_title() %></td>
					  </tr>
					  <tr>
					    <td class="tdpro1">类别：</td>
					    <td class="tdval1"><%=cb.getClassification() %></td>
					  </tr>
					  <tr>
					    <td class="tdpro1">级别：</td>
					    <td class="tdval1"><%=cb.getC_level() %></td>
					  </tr>
					  <tr>
					    <td class="tdpro1">创作朝代：</td>
					    <td class="tdval1"><%=cb.getCreation_date() %></td>
					  </tr>
					  <tr>
					    <td class="tdpro1">创作时期：</td>
					    <td class="tdval1"><%=cb.getCreation_time() %></td>
					  </tr>
					  <tr>
					    <td class="tdpro1">创作者：</td>
					    <td class="tdval1"><%=cb.getCreator() %></td>
					  </tr>
					  <tr id="placeOfOriginDiv">
					    <td class="tdpro1">产地：</td>
					    <td class="tdval1"><%=cb.getPlace_of_origin() %></td>
					  </tr>
					  <tr>
					    <td class="tdpro1">度量：</td>
					    <td class="tdval1"><%=cb.getMeasurement() %></td>
					  </tr>
					  <tr id="locationDiv">
					    <td class="tdpro1">地域环境：</td>
					    <td class="tdval1"><%=cb.getLocation() %></td>
					  </tr>
					  <tr id="excavationDateDiv">
					    <td class="tdpro1">出土时间：</td>
					    <td class="tdval1"><%=cb.getExcavation_date() %></td>
					  </tr>
					  <tr id="excavationPlaceDiv">
					    <td class="tdpro1">出土地点：</td>
					    <td class="tdval1"><%=cb.getExcavation_place() %></td>
					  </tr>
					  <tr id="currentLocationDiv">
					    <td class="tdpro1">现藏地点：</td>
					    <td class="tdval1"><%=cb.getCurrent_location() %></td>
					  </tr>
					  <tr id="exhibitonHistoryDiv">
					    <td class="tdpro1">展览历史：</td>
					    <td class="tdval1"><%=cb.getExhibition_history() %></td>
					  </tr>
					</table>
					<div id="bydiv" class="biaoyin" style="display:none">
						标引：<input type="text" id="byinput" value="标引词以;隔开" onclick="clearDefaultText(this,'标引词以;隔开')">
						<input type="button" value="提交" onclick="biaoyin();"/>
					</div>
				</div>
			</div>	
			<div class="down">
				<ul>
					<li><a id="shape" onclick="javascript:navigation('shape');return false;" href="#">造型要素</a></li>
					<li><a id="func" onclick="javascript:navigation('func');return false;" href="#">功能要素</a></li>
					<li><a id="techonology" onclick="javascript:navigation('techonology');return false;" href="#">技术要素</a></li>
					<li><a id="culture" onclick="javascript:navigation('culture');return false;" href="#">历史信息</a></li>
				</ul>
				<div id="shapeDiv" class="property">
					<div id="shape-up" class="element">
		    			<div id="shapeDiv2" class="eledisc">
		    				<h4>器型:</h4>
		    				<br>
		    				<p>&nbsp;&nbsp;&nbsp;<%=cb.getShape() %></p>
		    			</div>
		    			<div id="patternDiv" class="eledisc">
		    				<h4>纹饰:</h4>
		    				<br>
		    				<p>&nbsp;&nbsp;&nbsp;<%=cb.getPattern() %></p>
		    			</div>
		    			<div id="structureDiv" class="eledisc">
		    				<h4>结构:</h4>
		    				<br>
		    				<p>&nbsp;&nbsp;&nbsp;<%=cb.getStructure() %></p>
		    			</div>
		    			<div id="decorationDiv" class="eledisc">
		    				<h4>装饰:</h4>
		    				<br>
		    				<p>&nbsp;&nbsp;&nbsp;<%=cb.getDecoration() %></p>
		    			</div>
			    	</div>
			    	<hr>
			    	<div id="color-down" class="element">
		    			<div id="colordisc" class="eledisc">
		    				<h4>色彩描述:</h4>
		    				<br>
		    				<p>&nbsp;&nbsp;&nbsp;<%=cb.getColor() %></p>
		    			</div>
			    	</div>				
				</div>
				<div id="funcDiv" class="property" style="display:none">
			    	<div id="usefun" class="element">
		    			<div id="sceneDiv" class="eledisc">
		    				<h4>使用情境:</h4>
		    				<br>
		    				<p>&nbsp;&nbsp;&nbsp;<%=cb.getScene() %></p>
		    			</div>
		    			<div id="c_usageDiv" class="eledisc">
		    				<h4>使用方式:</h4>
		    				<br>
		    				<p>&nbsp;&nbsp;&nbsp;<%=cb.getC_usage() %></p>
		    			</div>
		    		</div>
		    		<div id="symbolicDiv" class="element">
		    			<div class="eledisc">
		    				<h4>象征意义:</h4>
		    				<br>
		    				<p>&nbsp;&nbsp;&nbsp;<%=cb.getSymbolic_meaning() %></p>
		    			</div>
			    	</div>
		    		<div id="beautyfun" class="element">
		    			<h4>审美:</h4>
		    			<br>
		    			<p>&nbsp;&nbsp;&nbsp;<%=cb.getAesthetic_desc() %></p>
		    		</div>	
				</div>
				<div id="techonologyDiv" class="property" style="display:none">
			    	<div id="material" class="element">
			    		<h4>材质:</h4>
			    		<br>
			     		<p>&nbsp;&nbsp;&nbsp;<%=cb.getMaterial() %></p>
			    	</div>
			    	<hr>
			    	<div id="craft" class="element">
			    		<h4>工艺:</h4>
			    		<br>
			    		<div id="process" class="eledisc">
			    			<p>&nbsp;&nbsp;&nbsp;<%=cb.getTechnique() %></p>
			    		</div>
			    	</div>				
				</div>
				<div id="cultureDiv" class="property" style="display:none";>
					 <div class="element">
			    		<div id="historyInfoDiv" class="eledisc">
			    			<h4>历史信息:</h4>
			    			<br>
			    			<p>&nbsp;&nbsp;&nbsp;<%=cb.getHistory_info() %></p>
			    		</div>
			    		<hr>
			    		<div id="folkloreDiv" class="eledisc">
			    			<h4>民间典故:</h4>
			    			<br>
			    			<p>&nbsp;&nbsp;&nbsp;<%=cb.getFolklore() %></p>
			    		</div>
			    		<div id="socialHistoryInfoDiv" class="eledisc">
			    			<h4>社会历史信息:</h4>
			    			<br>
			    			<p>&nbsp;&nbsp;&nbsp;<%=cb.getSocial_history_info() %></p>
			    		</div>
			    	</div>					
				</div>
			</div>   			
   		</div>
   	</div>
   	<div class="tail"></div>
  </body>
</html>
