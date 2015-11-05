var kkpager = {
		//divID
		pagerid : 'div_pager',
		//��ǰҳ��
		pno : 1,
		//��ҳ��
		total : 1,
		//����������
		totalRecords : 0,
		//�Ƿ���ʾ��ҳ��
		isShowTotalPage : true,
		//�Ƿ���ʾ�ܼ�¼��
		isShowTotalRecords : true,
		//�Ƿ���ʾҳ����ת�����
		isGoPage : true,
		//����ǰ��
		hrefFormer : '',
		//����β��
		hrefLatter : '',
		/****�����㷨****/
		getLink : function(n){
			//������㷨�����ڱ��磺
			//hrefFormer=http://www.xx.com/news/20131212
			//hrefLatter=.html
			//��ô��ҳ����1ҳ������http://www.xx.com/news/20131212.html
			//��2ҳ����http://www.xx.com/news/20131212_2.html
			//��nҳ����http://www.xx.com/news/20131212_n.html
			if(n == 1){
				return this.hrefFormer + this.hrefLatter;
			}else{
				return this.hrefFormer + '_' + n + this.hrefLatter;
			}
		},
		//��ת��õ����뽹��ʱ
		focus_gopage : function (){
			var btnGo = $('#btn_go');
			$('#btn_go_input').attr('hideFocus',true);
			btnGo.show();
			btnGo.css('left','0px');
			$('#go_page_wrap').css('border-color','#6694E3');
			btnGo.animate({left: '+=44'}, 50,function(){
				//$('#go_page_wrap').css('width','88px');
			});
		},
		
		//��ת��ʧȥ���뽹��ʱ

		blur_gopage : function(){
			setTimeout(function(){
				var btnGo = $('#btn_go');
				//$('#go_page_wrap').css('width','44px');
				btnGo.animate({
				    left: '-=44'
				  }, 100, function() {
					  $('#btn_go').css('left','0px');
					  $('#btn_go').hide();
					  $('#go_page_wrap').css('border-color','#DFDFDF');
				  });
			},400);
		},
		//��ת��ҳ����ת
		gopage : function(){
			var str_page = $("#btn_go_input").val();
			if(isNaN(str_page)){
				$("#btn_go_input").val(this.next);
				return;
			}
			var n = parseInt(str_page);
			if(n < 1 || n >this.total){
				$("#btn_go_input").val(this.next);
				return;
			}
			//������԰����window.open
			window.location = this.getLink(n);
		},
		//��ҳ��ť�ؼ���ʼ��
		init : function(config){
			//��ֵ
			this.pno = isNaN(config.pno) ? 1 : parseInt(config.pno);
			this.total = isNaN(config.total) ? 1 : parseInt(config.total);
			this.totalRecords = isNaN(config.totalRecords) ? 0 : parseInt(config.totalRecords);
			if(config.pagerid){this.pagerid = pagerid;}
			if(config.isShowTotalPage != undefined){this.isShowTotalPage=config.isShowTotalPage;}
			if(config.isShowTotalRecords != undefined){this.isShowTotalRecords=config.isShowTotalRecords;}
			if(config.isGoPage != undefined){this.isGoPage=config.isGoPage;}
			this.hrefFormer = config.hrefFormer || '';
			this.hrefLatter = config.hrefLatter || '';
			if(config.getLink && typeof(config.getLink) == 'function'){this.getLink = config.getLink;}
			//��֤
			if(this.pno < 1) this.pno = 1;
			this.total = (this.total <= 1) ? 1: this.total;
			if(this.pno > this.total) this.pno = this.total;
			this.prv = (this.pno<=2) ? 1 : (this.pno-1);
			this.next = (this.pno >= this.total-1) ? this.total : (this.pno + 1);
			this.hasPrv = (this.pno > 1);
			this.hasNext = (this.pno < this.total);
			
			this.inited = true;
		},
		//���ɷ�ҳ�ؼ�Html
		generPageHtml : function(){
			if(!this.inited){
				return;
			}
			
			var str_prv='',str_next='';
			if(this.hasPrv){
				str_prv = '<a href="'+this.getLink(this.prv)+'" title="��һҳ">��һҳ</a>';
			}else{
				str_prv = '<span class="disabled">��һҳ</span>';
			}
			
			if(this.hasNext){
				str_next = '<a href="'+this.getLink(this.next)+'" title="��һҳ">��һҳ</a>';
			}else{
				str_next = '<span class="disabled">��һҳ</span>';
			}
			
			
			var str = '';
			var dot = '<span>...</span>';
			var total_info='';
			if(this.isShowTotalPage || this.isShowTotalRecords){
				total_info = '<span class="normalsize">��';
				if(this.isShowTotalPage){
					total_info += this.total+'ҳ';
					if(this.isShowTotalRecords){
						total_info += '&nbsp;/&nbsp;';
					}
				}
				if(this.isShowTotalRecords){
					total_info += this.totalRecords+'������';
				}
				
				total_info += '</span>';
			}
			
			var gopage_info = '';
			if(this.isGoPage){
				gopage_info = '&nbsp;ת��<span id="go_page_wrap" style="display:inline-block;width:44px;height:18px;border:1px solid #DFDFDF;margin:0px 1px;padding:0px;position:relative;left:0px;top:5px;">'+
					'<input type="button" id="btn_go" onclick="kkpager.gopage();" style="width:44px;height:20px;line-height:20px;padding:0px;font-family:arial,����,sans-serif;text-align:center;border:0px;background-color:#0063DC;color:#FFF;position:absolute;left:0px;top:-1px;display:none;" value="ȷ��" />'+
					'<input type="text" id="btn_go_input" onfocus="kkpager.focus_gopage()" onkeypress="if(event.keyCode<48 || event.keyCode>57)return false;" onblur="kkpager.blur_gopage()" style="width:42px;height:16px;text-align:center;border:0px;position:absolute;left:0px;top:0px;outline:none;" value="'+this.next+'" /></span>ҳ';
			}
			
			//��ҳ����
			if(this.total <= 8){
				for(var i=1;i<=this.total;i++){
					if(this.pno == i){
						str += '<span class="curr">'+i+'</span>';
					}else{
						str += '<a href="'+this.getLink(i)+'" title="��'+i+'ҳ">'+i+'</a>';
					}
				}
			}else{
				if(this.pno <= 5){
					for(var i=1;i<=7;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a href="'+this.getLink(i)+'" title="��'+i+'ҳ">'+i+'</a>';
						}
					}
					str += dot;
				}else{
					str += '<a href="'+this.getLink(1)+'" title="��1ҳ">1</a>';
					str += '<a href="'+this.getLink(2)+'" title="��2ҳ">2</a>';
					str += dot;
					
					var begin = this.pno - 2;
					var end = this.pno + 2;
					if(end > this.total){
						end = this.total;
						begin = end - 4;
						if(this.pno - begin < 2){
							begin = begin-1;
						}
					}else if(end + 1 == this.total){
						end = this.total;
					}
					for(var i=begin;i<=end;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a href="'+this.getLink(i)+'" title="��'+i+'ҳ">'+i+'</a>';
						}
					}
					if(end != this.total){
						str += dot;
					}
				}
			}
			
			str = "&nbsp;"+str_prv + str + str_next  + total_info + gopage_info;
			$("#"+this.pagerid).html(str);
		}
};
