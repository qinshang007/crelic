// JavaScript Document
function typeCl(typebe)
{
	var start = typebe.indexOf(' ') + 1;
	var end = typebe.length;
	var typeaf = typebe.substring(start,end);
	return typeaf;
}

function myFunction()
{
	var moveable = new Array('瓷器','金银器','铜器','宝、玉石器','陶、泥器','铁器','石器','漆木竹器','砖瓦','石刻'
			,'骨角器','玻璃器','雕塑、造像','文献图书','徽章、证件','度量衡器','化石','其他金属器具','书法','绘画','甲骨简牍','文献文书','文具','货币','印信'
            ,'民俗文物','少数民族文物','杂项','自然标本','其他','棉','麻','毛','皮革','锦');
	
	for(var i=0;i<moveable.length;i++)
	{
			var type = encodeURIComponent(moveable[i]);
			$("#movediv").append(".<a href='/crelic/home/type.do?culType="+type+"&&pageNow=1'>"+moveable[i]+"</a><br>");	
	}	
			
	var unmoveable = new Array('寺观壁画','墓室壁画','石窟壁画','宫廷壁画','住宅','宫殿','坛庙','陵墓','佛寺',
			'道观','清真寺','教堂','佛塔','经幢','园林','商铺','会馆','酒楼','作坊','藏书楼','戏台','桥梁','城楼'
			,'门楼','鼓楼','钟楼','路亭','牌坊');
			
	for(var i=0;i<unmoveable.length;i++)
	{
			var type = encodeURIComponent(typeCl(unmoveable[i]));
			$("#unmovediv").append(".<a href='/crelic/home/type.do?culType="+type+"&&pageNow=1'>"+unmoveable[i]+"</a><br>");	
	}	
	
}

function clearDefaultText (el,message)
{
	 var obj = el;
	 if(typeof(el) == "string")
	 obj = document.getElementById(id);
	 if(obj.value == message)
	 {
	 	obj.value = "";
	 }
	 obj.onblur = function()
	 {
		 if(obj.value == "")
		 {
		    obj.value = message;
		 }
	 }
}
