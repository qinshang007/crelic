<%@ page language="java" import="java.util.*,com.crelic.model.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'classification.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="scripts/myscripts.js" charset="gb2312"></script>
	<script src="scripts/jquery.js"></script>
	<script type="text/javascript" src="scripts/fengye.js" charset="gb2312"></script>
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link href="css/5icool.org.css" rel="stylesheet" type="text/css" />
	<link href="css/display.css" type="text/css" rel="stylesheet">	
	
	<script type="text/javascript">
		
		var moreageon = false;
		var morecoloron = false;
		var isTimeSelected = false;
		var isColorSelected = false;
		var time = "";
		var color = "";
			
		function getQueryString(name) 
		{ 
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
			var r = window.location.search.substr(1).match(reg); 
			if (r != null) return decodeURIComponent(r[2]); return null; 
		}
		
				
		function moreAge()
		{
			if(!moreageon)
			{
				$("#moreagePanel").show();
				$("#littleagePanel").hide();
				$("#moreageButt").hide();
				$("#littleageButt").show();
				moreageon = true;
			}
			else
			{
				$("#moreagePanel").hide();
				$("#littleagePanel").show();
				$("#moreageButt").show();
				$("#littleageButt").hide();
				moreageon = false;
			}
		}
		
		function moreColor()
		{
			if(!morecoloron)
			{
				$("#moreColorPanel").show();
				$("#littleColorPanel").hide();
				$("#moreColorButt").hide();
				$("#littleColorButt").show();
				morecoloron = true;
			}
			else
			{
				$("#moreColorPanel").hide();
				$("#littleColorPanel").show();
				$("#moreColorButt").show();
				$("#littleColorButt").hide();
				morecoloron = false;
			}
		}

			
		$(function(){

			 $('.svalue > div').click(function(){

				var id = $(this).attr('id');
				var id_pre = id.substring(0,1);
				
				if(id_pre == 'l' || id_pre == 'm')
				{
					if(!isTimeSelected)
					{
						isTimeSelected = true;
						time = encodeURIComponent(id.substring(2,id.length));
						$("#"+id).css("color","#FFAA01");
					}
					else
					{
						 var ltime = 'l_' + time;
						 $("#"+ltime).css("color","#888");
						 var mtime = 'm_' + time;
						 $("#"+mtime).css("color","#888");
						 time = encodeURIComponent(id.substring(2,id.length));
						 $("#"+id).css("color","#FFAA01");
					}
				}
				else if(id_pre == 'c')
				{
					if(!isColorSelected)
					{
						isColorSelected = true;
						color = id.substring(3,id.length);
						$("#"+id).css("color","#FFAA01");
					}
					else
					{
						 var lcolor = 'cl_' + color;
						 $("#"+lcolor).css("color","#888");
						 var mcolor = 'cm_' + color;
						 $("#"+mcolor).css("color","#888");
						 color = id.substring(3,id.length);
						 $("#"+id).css("color","#FFAA01");
					}
				}
				
		         window.location.href = "/crelic/home/search.do?keyWord=${keyWord}&pageNow=1&&time="+time+"&&color="+color;

			});
			 
			 $('.skey').click(function(){
				 
				 
				 var id = $(this).attr('id');
				 var id_pre = id.substring(0,1);
				 
				 if(id_pre == 't')
				 {
					 isTimeSelected = false;
					 var ltime = 'l_' + time;
					 $("#"+ltime).css("color","#888");
					 var mtime = 'm_' + time;
					 $("#"+mtime).css("color","#888");
					 time = "";
				 }
				 else if(id_pre == 'c')
				{
					 isColorSelected = false;
					 var lcolor = 'cl_' + color;
					 $("#"+lcolor).css("color","#888");
					 var mcolor = 'cm_' + color;
					 $("#"+mcolor).css("color","#888");
					 color = "";
				}
				 
		         window.location.href = "/crelic/home/search.do?keyWord=${keyWord}&pageNow=1&&time="+time+"&&color="+color;
			 });

		})
		
		function init()
		{
			var t = getQueryString("time");
			var c = getQueryString("color");
			if(t!=null && t!="")
			{
				time = t;
				isTimeSelected = true;
				var ltime = 'l_' + time;
				document.getElementById(ltime).style.color="red";  
				var mtime = 'm_' + time;
				document.getElementById(mtime).style.color="red"; 
			}
			if(c!=null && c!="")
			{
				color = c;
				isColorSelected = true;
				var lcolor = 'cl_' + color;
				document.getElementById(lcolor).style.color="red";  
				var mcolor = 'cm_' + color;
				document.getElementById(mcolor).style.color="red"; 
			}
			
			var listSize='${fn:length(clList)}';
			if(listSize=='0'){
				$("#fengyePanel").hide();
			}
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

		 function getTimeAndColor()
		 {
			 var str="&time="+time+"&color="+color;
			 return str;
		 }
		 
		 function test(){
			 alert('${fn:length(ArrayList)}');
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
				<input class="searchBox" type="text" id="keyWord" name="search" value="请输入检索的内容" 
					onclick="clearDefaultText(this,'请输入检索的内容')"/>
				<div class="searchSummit" onclick="search()"></div>		
			</div>
		</div>
  
	    <div class="classification">
	    	<div class="left">
	    		<div class="dltitle" onclick="test()"><img src="images/display/recommend.jpg" /></div>
	 			<div class="dcontent">
		 			<ul>
		                <c:forEach var="cul" items="${recommList}">
		                	<li><a href="/crelic/home/display.do?culId=${cul.identifier}" title="${cul.title}"><img src="<%=url %>/crelicBase/upload/${cul.mainpic}" width="105" height="100" alt="title"/></a></li>
		                </c:forEach>
		 			</ul>
	 			</div>		
	    	</div>
	    	<div class="right">
	    		<div class="select">
	    			<div class="stitle"><span>筛选条件&nbsp;--&nbsp;${keyWord}</span></div>
	    			<div class="scon" id="age">
	    				<div class="skey" id="t_时代">时代:</div>
	    				<div id="littleagePanel" class="svalue" >
	    					<div class="elem" id="l_秦">秦朝</div>
	    					<div class="elem" id="l_汉">汉朝</div>
	    					<div class="elem" id="l_唐">唐朝</div>
	    					<div class="elem" id="l_宋">宋朝</div>
	    					<div class="elem" id="l_元">元朝</div>
	    					<div class="elem" id="l_明">明朝</div>
	    					<div class="elem" id="l_清">清朝</div>
	    				</div>
	    				<div id="moreagePanel" class ="more" style="display:none">
	    					<div class="svalue">
		    					<div class="elem" id="m_旧石器时代">旧石器时代</div>
		    					<div class="elem" id="m_新时器时代">新时器时代</div>
		    					<div class="elem" id="m_夏">夏朝</div>
		    					<div class="elem" id="m_商">商朝</div>
		    					<div class="elem" id="m_西周">西周</div>
		    			 		<div class="elem" id="m_春秋">春秋</div>
		    					<div class="elem" id="m_战国">战国</div>
	    					</div>  
	    					<div class="svalue">
		    					<div class="elem" id="m_秦">秦朝</div>
		    					<div class="elem" id="m_汉">汉朝</div>
		    					<div class="elem" id="m_三国">三国</div>
		    					<div class="elem" id="m_晋">晋朝</div>
		    					<div class="elem" id="m_南北朝">南北朝</div>
		    					<div class="elem" id="m_隋">隋朝</div>
		    					<div class="elem" id="m_唐">唐朝</div>
	    					</div>    					
	    					 <div class="svalue">
		    					<div class="elem" id="m_五代">五代</div>
		    					<div class="elem" id="m_宋">宋朝</div>
		    					<div class="elem" id="m_辽">辽朝</div>
		    					<div class="elem" id="m_金">金朝</div>
		    					<div class="elem" id="m_西夏">西夏</div>
		    					<div class="elem" id="m_元">元朝</div>
		    					<div class="elem" id="m_明">明朝</div>
	    					</div>
	    					<div class="svalue">
	    						<div class="elem" id="m_清">清朝</div>
		    					<div class="elem" id="m_中华民国">中华民国</div>
		    					<div class="elem elmore" title="m_中华人民共和国" id="中华人民共和国">中华人民共和国</div>
	    					</div> 
	    				</div>   								  					
	    				<div class="soption" onclick="moreAge();">
	    					<span id="moreageButt">更多<img src="images/display/2013100702.gif" /></span>
	    					<span id="littleageButt" style="display:none">收起<img src="images/display/2013100703.gif" /></span>
	    				</div>
	    			</div>
	    			<div class="scon" id="color">
	    				<div class="skey" id="c_颜色">颜色:</div>
	    				<div class="svalue" id="littleColorPanel">
	    					<div class="elem" id="cl_白">白色</div>
	    					<div class="elem" id="cl_黑">黑色</div>
	    					<div class="elem" id="cl_红">红色</div>
	    					<div class="elem" id="cl_绿">绿色</div>
	    					<div class="elem" id="cl_蓝">蓝色</div>
	    					<div class="elem" id="cl_青">青色</div>
	    					<div class="elem" id="cl_紫">紫色</div>
	    				</div>
	    				<div class ="more" style="display:none" id="moreColorPanel">
	    					<div class="svalue">
		    					<div class="elem" id="cm_白">白色</div>
		    					<div class="elem" id="cm_黑">黑色</div>
		    					<div class="elem" id="cm_红">红色</div>
		    					<div class="elem" id="cm_绿">绿色</div>
		    					<div class="elem" id="cm_蓝">蓝色</div>
		    					<div class="elem" id="cm_青">青色</div>
		    					<div class="elem" id="cm_紫">紫色</div>
	    					</div>  
	    					<div class="svalue">
		    					<div class="elem" id="cm_粉">粉红</div>
		    					<div class="elem" id="cm_红">妃红</div>
		    					<div class="elem" id="cm_胭脂">胭脂</div>
		    					<div class="elem" id="cm_橘黄">橘黄</div>
		    					<div class="elem" id="cm_茶色">茶色</div>
		    					<div class="elem" id="cm_棕">棕色</div>
		    					<div class="elem" id="cm_绿">柳绿</div>
	    					</div>    					
	    					 <div class="svalue">
		    					<div class="elem" id="cm_翡翠">翡翠</div>
		    					<div class="elem" id="cm_靛青">靛青</div>
		    					<div class="elem" id="cm_藏青">藏青</div>
		    					<div class="elem" id="cm_藏蓝">藏蓝</div>
		    					<div class="elem" id="cm_紫檀">紫檀</div>
		    					<div class="elem" id="cm_藕色">藕色</div>
		    					<div class="elem" id="cm_水绿">水绿</div>
	    					</div>
	    					<div class="svalue">
		    					<div class="elem" id="cm_象牙">象牙</div>
		    					<div class="elem" id="cm_莹白">莹白</div>
		    					<div class="elem" id="cm_玄青">玄青</div>
		    					<div class="elem" id="cm_乌黑">乌黑</div>
		    					<div class="elem" id="cm_铜绿">铜绿</div>
		    					<div class="elem" id="cm_乌金">乌金</div>
		    					<div class="elem" id="cm_老银">老银</div>
	    					</div>    								  					
	    				</div>
	    				<div class="soption" onclick="moreColor();">
	    					<span id="moreColorButt">更多<img src="images/display/2013100702.gif" /></span>
	    					<span id="littleColorButt" style="display:none">收起<img src="images/display/2013100703.gif" /></span>
	    				</div>
	    			</div>
	    			<div class="scon" id="sort" style="display:none">
	    				<div class="skey">排序:</div>
	    				<div class="svalue" >
	    					<div class="elem"><span>综合</span></div>
	    					<div class="elem"><span>时代</span></div>
	    					<div class="elem"><span>完残程度</span></div>
	    				</div>
	    				<div class="soption">
	    					<ul>
	    						<li><a>大图</a></li>
	    						<li><a>列表</a></li>
	    					</ul>
	    				</div>
	    			</div>
	    		</div>
	    		<%
	    			ArrayList al = (ArrayList)request.getAttribute("clList");	    			
	    		%>
	    		<div class="showpic">
	    			<%
	    			
	    				int size = al.size();	    			
	    				if(size == 0)
	    				{	
	    			%>
	    				<h1>找不到文物！</h1>
	    				
	    			<% 	
	    				}
	    				else
	    				{
	    			
	    					boolean another_piccon = false;
	    			%>
	    					<div class="piccon">
	    			<% 
		    				for(int i=0; i < size; i++)
		    				{
		    					CulturalBean cb = (CulturalBean)al.get(i);	 
		    					if(i >=4 && !another_piccon)
		    					{
	    			%>
	    					</div>
	    					<div class="piccon">
	    			<%
	    							another_piccon = true;
	    						}
	    			%>
	    					<div class="pvalue"><a href="/crelic/home/display.do?culId=<%=cb.getIdentifier() %>" title="<%=cb.getTitle() %>"><img src="<%=url %>/crelicBase/upload/<%=cb.getMainpic() %>" /><p><%=cb.getTitle() %></p></a></div>
	    			<% 
	    					}
	    				}
	    			%>
	    				</div>
	    		</div>
	    		<div class="fengye" id="fengyePanel"><div id="div_pager"></div></div>
	    	</div>	    	
    </div>
    
	<div class="tail"></div>	
	
    <script type="text/javascript">
    
		function getParameter(name) { 
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
			var r = window.location.search.substr(1).match(reg); 
			if (r!=null) return unescape(r[2]); return null;
		}
		
		var totalPage = <%=request.getAttribute("pageCount") %>;
		var totalRecords = <%=request.getAttribute("rowCount") %>;
		var pageNo = <%=request.getAttribute("pageNow") %>;
		if(!pageNo){
			pageNo = 1;
		}
		//生成分页控件
		kkpager.init({
			pno : pageNo,
			//总页码
			total : totalPage,
			//总数据条数
			totalRecords : totalRecords,
			//目标地址
			hrefFormer : '/crelic/home/search.do?keyWord=${keyWord}',
			//链接尾部
			hrefLatter : getTimeAndColor(),
			
			getLink : function(n){
				return this.hrefFormer + this.hrefLatter + "&pageNow="+n;
			}
		});
		kkpager.generPageHtml();
	</script>
    
  </body>
</html>
