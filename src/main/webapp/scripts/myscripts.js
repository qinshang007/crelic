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
	var moveable = new Array('石器','石刻','玉器','陶器','瓷器','砖瓦','铜器','金银器','漆木竹器','其他金属器','漆器','木器'
            ,'书法','绘画','织绣','雕塑造像','甲骨简牍','文献文书','文具','货币','印信','近现代文物'
            ,'民俗文物','少数民族文物','杂项','自然标本','衣','巾','冠','帽','披肩','补子','腰带','荷包','香囊','鞋','帐幔','卧褥'
            ,'壁毯','地毯','铺垫','坐褥','靠垫','迎手','椅披','门帘','帐子','桌围'
            ,'轴','卷','册','条屏','屏风','扇面','镜心');
	
	for(var i=0;i<moveable.length;i++)
	{
			var type = encodeURIComponent(moveable[i]);
			$("#movediv").append(".<a href='/crelic/home/type.do?culType="+type+"&&pageNow=1'>"+moveable[i]+"</a><br>");	
	}	
			
	var unmoveable = new Array('宫廷壁画','墓室壁画','石窟壁画','道观壁画','城垣城楼','宫殿府邸','宅第民居','坛庙祠堂','衙署官邸','学堂书院',
			'驿站会馆','店铺作坊','牌坊影壁','亭台楼阙','寺观塔幢','苑囿园林','桥涵码头','堤坝渠堰','池塘井泉','其他古建筑');
			
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
