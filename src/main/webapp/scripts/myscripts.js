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
	var moveable = new Array('����','������','ͭ��','������ʯ��','�ա�����','����','ʯ��','��ľ����','ש��','ʯ��'
			,'�ǽ���','������','���ܡ�����','����ͼ��','���¡�֤��','��������','��ʯ','������������','�鷨','�滭','�׹Ǽ��','��������','�ľ�','����','ӡ��'
            ,'��������','������������','����','��Ȼ�걾','����','��','��','ë','Ƥ��','��');
	
	for(var i=0;i<moveable.length;i++)
	{
			var type = encodeURIComponent(moveable[i]);
			$("#movediv").append(".<a href='/crelic/home/type.do?culType="+type+"&&pageNow=1'>"+moveable[i]+"</a><br>");	
	}	
			
	var unmoveable = new Array('�¹۱ڻ�','Ĺ�ұڻ�','ʯ�߱ڻ�','��͢�ڻ�','סլ','����','̳��','��Ĺ','����',
			'����','������','����','����','����','԰��','����','���','��¥','����','����¥','Ϸ̨','����','��¥'
			,'��¥','��¥','��¥','·ͤ','�Ʒ�');
			
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
