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
	var moveable = new Array('ʯ��','ʯ��','����','����','����','ש��','ͭ��','������','��ľ����','����������','����','ľ��'
            ,'�鷨','�滭','֯��','��������','�׹Ǽ��','��������','�ľ�','����','ӡ��','���ִ�����'
            ,'��������','������������','����','��Ȼ�걾','��','��','��','ñ','����','����','����','�ɰ�','����','Ь','���','����'
            ,'��̺','��̺','�̵�','����','����','ӭ��','����','����','����','��Χ'
            ,'��','��','��','����','����','����','����');
	
	for(var i=0;i<moveable.length;i++)
	{
			var type = encodeURIComponent(moveable[i]);
			$("#movediv").append(".<a href='/crelic/home/type.do?culType="+type+"&&pageNow=1'>"+moveable[i]+"</a><br>");	
	}	
			
	var unmoveable = new Array('��͢�ڻ�','Ĺ�ұڻ�','ʯ�߱ڻ�','���۱ڻ�','��ԫ��¥','���ۡ','լ�����','̳������','�����ۡ','ѧ����Ժ',
			'��վ���','��������','�Ʒ�Ӱ��','̨ͤ¥��','�¹�����','Է��԰��','�ź���ͷ','�̰�����','������Ȫ','�����Ž���');
			
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
