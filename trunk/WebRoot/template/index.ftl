<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="imagetoolbar" content="no" />
    <META name="keywords" content="合租房,整租房,合租出租房,一居室出租,合租信息,自如客，北京白领公寓"> 
    <META name="description" content="自如网,北京白领公寓，创造品质租住生活,零押金、免费宽带、定期保洁、全新品牌家电家具、拎包入住,无论是老乡合租,男生整租,女生合租都可轻松搞定,咨询电话:400-100-1111">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	<meta http-equiv="pragma" content="no-cache"/>    
	<meta http-equiv="cache-Control" content="no-cache"/>    
	<meta http-equiv="expires" content="Sunday 26 October 2008 01:00 GMT" />
<title>自如友家白领公寓-创造品质租住生活</title>
<link href="{STATIC_HTTP}css/style_index.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script src="{STATIC_HTTP}js/iepng.js" type="text/javascript"></script>
<script type="text/javascript">
   EvPNG.fix('div,img'); 
</script>
<![endif]-->

	<script type="text/javascript" src="{STATIC_HTTP}js/ziroom.js"></script>
	<script type="text/javascript" src="{STATIC_HTTP}js/jquery.min.js"></script>
	
    <script  language="JavaScript" type="text/javascript">
function  secBoard(n)
{var nba=document.getElementById("index_menua").getElementsByTagName("li")
var cba=document.getElementById("index_list01").getElementsByTagName('div');

for(i=0;i<nba.length;i++)
nba[i].className="sec1";
nba[n].className="sec2";
for(i=0;i<cba.length;i++)
cba[i].style.display="none";
cba[n].style.display="block";
}
</script>

<!--幻灯片-->
<script type="text/javascript">
var url = [];
<#list sowing as u>
url[${u_index}]='${u.url}';
</#list>
</script>
<script type="text/javascript">

function $(id){
	return typeof id === "string" ? document.getElementById(id) : id;
}
function $$(oParent, elem){
	return (oParent || document).getElementsByTagName(elem);
}
function $$$(oParent, sClass){
	var aElem = $$(oParent, '*');
	var aClass = [];
	var i = 0;
	for(i=0;i<aElem.length;i++)if(aElem[i].className == sClass)aClass.push(aElem[i]);
	return aClass;
}
function Slide(){
	this.initialize.apply(this, arguments);
}
Object.extend = function(destination, source){
    for (var property in source) {
        destination[property] = source[property];
    }
    return destination;
};
Slide.prototype = {
	initialize : function(obj, list, but, hove, onEnd,url){
		if($(obj)){
			this.obj = $(obj);
			this.oList = $$$(this.obj, list)[0];
			this.oUl = $$(this.oList, 'ul')[0];
			this.aList = $$(this.oList, 'li');
			this.aListH = this.aList[0].offsetHeight;
			this.aListW = this.aList[0].offsetWidth;
			this.oBut = $$$(this.obj, but)[0];
			this.aBut = $$(this.oBut, 'li');
			this.oEve(onEnd);
			this.oAction = this.onEnd.action;
			this.onEnd.method == 'mouseover' ? this.method = "mouseover" : this.method = "click";
			this.onEnd.autoplay == 'stop' ? this.autoplay = "stop" : this.autoplay = "play";
			if(this.oAction == 'top'){
				this.oUl.style.height = this.aListH * this.aList.length +'px';
			}else if(this.oAction == 'left'){
				this.oUl.style.width = this.aListW * this.aList.length +'px';
			}else if(this.oAction == 'opacity'){
				this.oUl.style.height = this.aListH +'px';
				var i = 0;
				for(i=0;i<this.aList.length;i++){
					this.aList[i].style.position = 'absolute';
					this.aList[i].className = 'opacity';
				}
				this.aList[0].className = '';
			}else{
				this.oUl.style.height = this.aListH * this.aList.length +'px';
			}
			document.getElementById('imager').href =url[0];//第一个
			this.getEvent(hove);
		}
	},
	oEve: function(onEnd){
        this.onEnd = {
			method : 'click',
			autoplay: 'stop'
		};
        Object.extend(this.onEnd, onEnd || {});
    },
	addEvent : function(oElm, strEvent, fuc) {
		window.addEventListener ? oElm.addEventListener(strEvent, fuc, false) : oElm.attachEvent('on' + strEvent, fuc);
	},
	getEvent : function(hove) {
		var _this = this;
		var i = iNow = 0;
		for(i=0;i<this.aBut.length;i++){
			(function(){
				var j = i;
				_this.addEvent(_this.aBut[j], _this.method, function(){
					_this.fnClick(j, hove);
					_this.autoPlayTab(j, hove);
				});
			})();
		}
		this.autoPlayTab(i, hove);
	},
	autoPlayTab : function(iNow, hove){
		if(this.autoplay == 'play'){
			var _this = this;
			this.iNow = iNow;
			this.obj.onmouseover = function(){
				clearInterval(_this.timer);
			};
			this.obj.onmouseout = function(){
				clearInterval(_this.timer);
				_this.timer = setInterval(playTab,4000);
			};
			
			function playTab(){
				if(_this.iNow == _this.aBut.length)_this.iNow = 0;
				_this.fnClick(_this.iNow, hove);
				_this.iNow++;
			}
		}
		clearInterval(_this.timer);
			_this.timer = setInterval(playTab,4000);
	},
	fnClick : function(oBut, hove){
		var i = 0;
		for(i=0;i<this.aBut.length;i++)this.aBut[i].className = '';
		this.aBut[oBut].className = hove;
		if(this.oAction == 'top'){
			this.sMove(this.oUl, {top:-(this.aListH * oBut)});
		}else if(this.oAction == 'left'){
			this.sMove(this.oUl, {left:-(this.aListW * oBut)});
		}else if(this.oAction == 'opacity'){
			var i = 0;
			for(i=0;i<this.aList.length;i++){
				this.sMove(this.aList[i], {opacity:0});
			}
			this.sMove(this.aList[oBut], {opacity:100});
		}else{
			this.sMove(this.oUl, {top:-(this.aListH * oBut)});
		}
	},
	getStyle : function(obj, attr)
	{
		return obj.currentStyle?obj.currentStyle[attr]:getComputedStyle(obj, false)[attr];
	},
	sMove : function(obj, json, onEnd){
		var _this = this;
		for(i=0; i<this.aList.length;i++) {
			if (this.aList[i] == obj) {
			 document.getElementById('imager').href = url[i];
			}
		}
		clearInterval(obj.timer);
		obj.timer = setInterval(function(){
			_this.dMove(obj, json, onEnd);
		},30);
	},
	dMove : function(obj, json, onEnd){
		this.attr = '';
		this.bStop = true;
		
		for(this.attr in json){
			this.iCur = 0;			
			this.attr == 'opacity' ? this.iCur = parseInt(parseFloat(this.getStyle(obj, this.attr))*100) : this.iCur = parseInt(this.getStyle(obj, this.attr));
			this.iSpeed = (json[this.attr] - this.iCur) / 12;
			this.iSpeed = this.iSpeed > 0 ? Math.ceil(this.iSpeed) : Math.floor(this.iSpeed);			
			if(json[this.attr] != this.iCur)this.bStop = false;
			if(this.attr == 'opacity'){
				obj.style.filter = 'alpha(opacity:' + (this.iCur + this.iSpeed) +')';
				obj.style.opacity = (this.iCur + this.iSpeed ) / 100;
			}else{
				obj.style[this.attr] = this.iCur + this.iSpeed + 'px';
			}
		}
		if(this.bStop){
			clearInterval(obj.timer);			
			if(onEnd)onEnd();
		}
	}
};
window.onload = function(){

var obj = new Slide('box3', 'list', 'but', 'hove', {action:'opacity', autoplay:'play'}, url);
};
</script>


</head>



<body>
<!--{if IN_INTRA_NET}
<script type="text/javascript" language="javascript">
var $I = function (d){return document.getElementById(d)};
var CLS={
   create: function() {
	  return function() {
		this.$IADD = function (fn){CLS.add(this,fn)};
	    this.init.apply(this, arguments);
	  }
   },
   add:function (obj,fn){
	   fn.apply(obj,arguments);
   },
   enterFrame:function (){
	    this.onEnterFrame=function (){};
		this.$IPLAY = function (g){
			this.enterFrameP = this.enterFrameP || 10;
			this.CLStimeIndex = CLS.ontimes.length;
			CLS.ontimes.push(this);
			window.clearTimeout(this.enterFrameTimeout);
			window.clearInterval(this.enterFrameInterval);
			if(g)this.enterFrameTimeout = window.setTimeout('CLS.ontimes['+this.CLStimeIndex+'].enterFrameInterval=window.setInterval("CLS.ontimes['+this.CLStimeIndex+'].onEnterFrame()",'+this.enterFrameP+')',parseInt(g*1000));
			else this.enterFrameInterval = window.setInterval("CLS.ontimes["+this.CLStimeIndex+"].onEnterFrame()",this.enterFrameP);
		}
		this.$ISTOP = function (){
			window.clearInterval(this.enterFrameInterval);
		}
		this.$ISET = function (p){
			this.enterFrameP = p;
		}
   },
   ontimes:new Array()
};
CLS.Marquee = CLS.create();
CLS.Marquee.prototype = {
   init:function (button,box,speed){
      this.box = $I(box);
	  this.tit = $I(button)
	  this.kong = $I("kong");
	  this.onOpen = true;
	  this.show = false;
	  this.time = 0;
	  this.speed = speed;
	  this.kong.style.height = this.box.offsetHeight +"px";
	  this.Maxw = this.box.offsetWidth-this.tit.offsetWidth;
	  this.box.style.right = -this.box.offsetWidth + "px";
	  this.boxTop = this.kong.offsetTop;
	  var _t = this;
	  this.tit.onclick = function (){
	    this.show = true;
	    if(_t.onOpen){
		  _t.onEnterFrame = _t.close;
		  _t.onOpen = false;
		}else{
		  _t.onEnterFrame = _t.open;
		  _t.onOpen = true;
		}
		_t.$IPLAY();
	  };
	  this.$IADD(CLS.enterFrame);
	  this.onEnterFrame = this.open;
	  this.$IPLAY();
   },
   open:function(){
      this.tit.innerHTML = "-";
      var _r = parseInt(this.box.style.right);
	  var _b = (0 - _r)/30;
	  this.box.style.right = (_r + _b) +"px";
	  //this.kong.style.top = (document.documentElement.scrollTop + this.boxTop) +"px";
	  this.kong.style.bottom = "0px";
	  if(_b==0 && !this.show){
	   this.time +=10;
	   if(this.time>=this.speed*1000){
	     this.show = true;
		 this.onOpen = false;
		 this.$ISTOP();
	     this.onEnterFrame = this.close;
		 this.$IPLAY(); 
	   }
	  }	  
   },
   close:function (){
      this.tit.innerHTML = "+";
      var _r = parseInt(this.box.style.right);
	  var _b = (-this.Maxw - _r)/5;
	  this.box.style.right = Math.round(_r + _b) +"px";
	  //this.kong.style.top = (document.documentElement.scrollTop + this.boxTop) +"px";
	  this.kong.style.bottom = "0px";
   }
};

window.onload = function(){

var obj = new Slide('box3', 'list', 'but', 'hove', {action:'opacity', autoplay:'play'});
};
 setTimeout(function(){new CLS.Marquee("tit","abc",5)},200);//tit是点击按钮的Id ，abc是浮动块的ID,10是显示时长



</script>


<style type="text/css">



#abc {
	border: 1px solid #F98A41;
	position: absolute;
	height: 131px;
	width: 270px;
	right: -100%;
	background-color: #FFFFFF;
}
#abc #tit {
	background-color: #F98A41;
	position: relative;
	height: 100%;
	width: 20px;
	color: #FFFFFF;
	text-align: center;
	float: left;
	cursor:pointer;
}

#abc #cba {
	height: 100%;
	width: 245px;
	float: right;
	background:#FFFFFF;
}
#cba p{
	line-height: 19px;
	text-decoration: none;
}
#kong {
	overflow: hidden;
	position: fixed;
	width: 100%;
	height:150px;
	right: 0px;
	z-index:10;
}
.right {
	float: right;
	width: 190px;
	padding: 5px;
	color: #000000;
}

</style>

<div id="kong">
 
 <div id="abc">
 <div id="cba">
 <a  style=" text-decoration:none; color:#666666;" href="http://172.16.5.111/z/i/announcedTwo.html"><img src="{STATIC_HTTP}images/yousanya.png"  style="float:right; margin:8px 8px auto auto;"/>
 <p style=" display:block; margin:8px auto auto 6px;">
2011年度第二期
<br />
自如金牌店经理、<br />
金牌经纪人最终<br />
榜单，
<br />
三亚游即将成行！<br />
</p></a>
 </div>
   <div id="tit"><a href="#"></a></div>
   <div class="right">
</div>
 </div>
</div>
{else}
<script type="text/javascript" language="javascript">
window.onload = function (){
var obj = new Slide('box3', 'list', 'but', 'hove', {action:'opacity', autoplay:'play'});
};
</script>
{/if}
-->
<div id="bg">
<!--头部的内容，包括导航和标志-->
<div id="top">
  <div id="apDiv1"><a href="/"><img src="{STATIC_HTTP}images/logo_index.png" alt="ziroom_logo"/></a></div>



<!--走马灯-->  
<div class="box" id="box3" style="z-index:1">
  <div class="list">
          <ul>
          
		<#list sowing as u>
			<#if u_index==0>
				
		 <li style="opacity:1;"><div style="width:600px; height:400px;"><a href="${u.url}" target="_blank"><img src="{STATIC_HTTP}${u.bigPicturePath}" border="0"></a></div>
                <div class="spaned">
                <div class="spaneder">
                    <img src="{STATIC_HTTP}${u.smallPicturePath}" /></div>
                    <div class="write">
                        <p style=" margin:20px 0 0 85px; font-size:14px; line-height:14px;">
                        ${u.textDescription}
                        </p>
                     </div>
                </div>
            </li>	
			<#else>
              <li>
                <div style="width:600px; height:400px;"><a <#if !u_has_next>id="imager"</#if> href="#" target="_blank"><img src="{STATIC_HTTP}${u.bigPicturePath}" border="0"></a></div>
                <div class="spaned">
                <div class="spaneder"><img src="{STATIC_HTTP}${u.smallPicturePath}" /></div><div class="write">
                <p style=" margin:19px 0 0 15px; font-size:14px; line-height:14px;">
                ${u.textDescription}
</p></div>

                </div>
              </li>
				
			</#if>
		</#list>
         
          </ul>
    	</div>
        <div class="but" style="z-index:15;">
			<ul>
				<#list sowing as u>
					<#if u_index==0>
						<li class="hove">${u_index+1}</li>
					<#else>
						<li>${u_index+1}</li>
					</#if>
				</#list>
          </ul>
    	</div>
    </div>
  
  <script type="text/javascript">
new Slide('box3', 'list', 'but', 'hove', {action:'opacity', autoplay:'play'});
</script>



  
<!--导航--> 
  {template 'tpl_header_nav.tpl'}
  
  
</div>

<div class="cloudle">
</div>
<div id="search_index">
<div  class="search_blank">
<p style="font-size:14px; margin:0 auto 5px 5px; font-family:'微软雅黑', '黑体', '宋体';">找寻属于你的&nbsp;ziroom</p>

<form action="" method="GET" id="i_doqkey_form" >
	<input type="text" class="txtBox" id="i_q_keyword" />
	<input type="button" class="search" value="搜 索" onclick="doQKey();"/>
	<input style="display:none;" type="hidden" name="qwd" id="i_doqkey_qwd" />
</form>

<script type="text/javascript">
var defaultQKeyWord = '小区/楼盘/房源 关键字查询' ;
var doQKeyUrl = '{get_url_nlist()}' ;
initQKey() ;
</script>
</div>

<script type="text/javascript" src="{get_url_js_citya()}"></script>
<div id="index_list">
<div id="index_list01">
<div class="index_choose" style="display:block;">

<table border="0" cellpadding="0" cellspacing="0"  class="table_index">
  <tr>
    <td><span>区域：&nbsp;&nbsp;</span></td>
    <td>
      <select class="jumpMenu" id="i1_district" name="zzxx">
	  <option value="">不限</option>
	  </select>
   </td>
  </tr>
  <tr>
    <td><span>商圈：</span></td>
    <td>
        <select class="jumpMenu" id="i1_districtbusiness" name="zzxx">
          <option value="">不限</option>
        </select>
      </td>
  </tr>
  <tr>
    <td><span>价格：</span></td>
    <td>
      <select class="jumpMenu" id="i1_pr" name="zzxx">
        <option value="">请选择</option>
		{php $c_prs = get_range_pr()}
		{loop $c_prs[2] $k $v}
		{php if(!$k) continue}
		<option value="{$k}">{get_t_range_show($v,'以下','以上','元/月')}</option>
		{/loop}
     </select>
    </td>
  </tr>
  <tr>
    <td><span>产品：</span></td>
    <td>
      <select class="jumpMenu" id="i1_hp" name="zzxx">
	    <option value="">不限</option>
		{php $tmp=get_range_hp()}
		
		{loop $tmp[1] $k $v}
		{php if(!$k) continue}
        <option value="{$k}">{get_dict_show($v)}</option>
		{/loop}
        </select>
   </td>
  </tr>
  <tr>
    <td><span>类型：</span></td>
    <td>
      <select class="jumpMenu" id="i1_yy" name="zzxx">
        <option value="">不限</option>
        <option value="1">男生合租</option>
        <option value="2">女生合租</option>
      </select>
    </td>
  </tr>
 
  <tr>
    <td colspan="2" style="padding-top:25px;"><a href="javascript:;" onclick="doIndexQuery('1');return false;" class="index_sure">确定</a></td>
    </tr>
</table>
</div>

<div class="index_choose">

<table border="0" cellpadding="0" cellspacing="0"  class="table_index">
  <tr>
    <td><span>地铁：&nbsp;&nbsp;</span></td>
    <td>
      <select class="jumpMenu" id="i0_subway">
        <option value="">不限</option>
      </select>
    </td>
  </tr>
  <tr>
    <td><span>站点：</span></td>
    <td>
        <select class="jumpMenu" id="i0_subwaystation">
          <option value="">不限</option>
          </select>
    </td>
  </tr>
  <tr>
    <td><span>价格：</span></td>
    <td>
      <select class="jumpMenu" id="i0_pr">
        <option value="">请选择</option>
		{php $c_prs = get_range_pr()}
		{loop $c_prs[2] $k $v}
		{php if(!$k) continue}
		<option value="{$k}">{get_t_range_show($v,'以下','以上','元/月')}</option>
		{/loop}
     </select>
    </td>
  </tr>
   <tr>
    <td><span>产品：</span></td>
    <td>
      <select class="jumpMenu" id="i0_hp">
	    <option value="">不限</option>
		{php $tmp=get_range_hp()}
		{loop $tmp[1] $k $v}
		{php if(!$k) continue}
        <option value="{$k}">{get_dict_show($v)}</option>
		{/loop}
        </select>
   </td>
  </tr>
  <tr>
    <td><span>类型：</span></td>
    <td>
      <select class="jumpMenu" id="i0_yy">
        <option value="">不限</option>
        <option value="1">男生合租</option>
        <option value="2">女生合租</option>
      </select>
    </td>
  </tr>
 

  <tr>
     <td colspan="2" style="padding-top:25px;"><a href="javascript:;" onclick="doIndexQuery('0');return false;" class="index_sure">确定</a></td>
    </tr>
</table>
</div>
<div class="index_choose">

<table border="0" cellpadding="0" cellspacing="0"  class="table_index">
  <tr>
    <td><span>环线：&nbsp;&nbsp;</span></td>
    <td>
      <select class="jumpMenu" id="i2_cycle">
        <option value="">不限</option>
      </select>
    </td>
  </tr>
  <tr>
    <td><span>方位：</span></td>
    <td>
        <select class="jumpMenu" id="i2_cycleface">
         <option value="">不限</option>
        </select>
    </td>
  </tr>
   <tr>
    <td><span>价格：</span></td>
    <td>
      <select class="jumpMenu" id="i2_pr">
        <option value="">请选择</option>
		{php $c_prs = get_range_pr()}
		{loop $c_prs[2] $k $v}
		{php if(!$k) continue}
		<option value="{$k}">{get_t_range_show($v,'以下','以上','元/月')}</option>
		{/loop}
     </select>
    </td>
  </tr>
  <tr>
    <td><span>产品：</span></td>
    <td>
      <select class="jumpMenu" id="i2_hp">
	    <option value="">不限</option>
		{php $tmp=get_range_hp()}
		{loop $tmp[1] $k $v}
		{php if(!$k) continue}
        <option value="{$k}">{get_dict_show($v)}</option>
		{/loop}
        </select>
   </td>
  </tr>
  <tr>
    <td><span>类型：</span></td>
    <td>
      <select class="jumpMenu" id="i2_yy">
        <option value="">不限</option>
        <option value="1">男生合租</option>
        <option value="2">女生合租</option>
      </select>
    </td>
  </tr>
 
  <tr>
     <td colspan="2" style="padding-top:25px;"><a href="javascript:;" onclick="doIndexQuery('2');return false;" class="index_sure">确定</a></td>
    </tr>
</table>
</div>
<div class="index_choose">

<table border="0" cellpadding="0" cellspacing="0"  class="table_index">
  <tr>
    <td><span>产品：&nbsp;&nbsp;</span></td>
    <td>
      <select class="jumpMenu" id="i4_hp">
	    <option value="">不限</option>
		{php $tmp=get_range_hp()}
		{loop $tmp[1] $k $v}
		{php if(!$k) continue}
        <option value="{$k}">{get_dict_show($v)}</option>
		{/loop}
        </select>
    </td>
  </tr>
 <tr>
    <td><span>类型：</span></td>
    <td>
      <select class="jumpMenu" id="i4_yy">
        <option value="">不限</option>
        <option value="1">男生合租</option>
        <option value="2">女生合租</option>
      </select>
    </td>
  </tr>
  <tr>
    <td><span>价格：</span></td>
    <td>
      <select class="jumpMenu" id="i4_pr">
        <option value="">请选择</option>
		{php $c_prs = get_range_pr()}
		{loop $c_prs[2] $k $v}
		{php if(!$k) continue}
		<option value="{$k}">{get_t_range_show($v,'以下','以上','元/月')}</option>
		{/loop}
     </select>
    </td>
  </tr>
  
 {* <tr>
    <td><span>职业：</span></td>
    <td>
      <select class="jumpMenu">
        <option>不限</option>
        <option>会计</option>
        <option>律师</option>
      </select>
    </td>
  </tr>
  *}
  <tr>
    <td><span>老乡：</span></td>
    <td>
      <select class="jumpMenu" id="i4_lx">
        <option>不限</option>
		{php $c_lxs = get_range_lx()}
{loop $c_lxs $k $v}
{php if(!$k) continue}
<option value="{$k}">{$v}</option>
{/loop}
      </select>
	
     
    </td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    
  </tr>
 
  <tr>
    <td colspan="2" style="padding-top:25px;"><a href="javascript:;" onclick="doIndexQuery('4');return false;" class="index_sure">确定</a></td>
    </tr>
</table>
</div>
</div>


<script type="text/javascript">
var defaultCity = '北京' ;
var baseIndexQUrl = '{get_mselect_qzz_base_url(array(),get_mselect_config())}' ;
i$('i1_district').onchange = function(){
	CAI.inBusiness(defaultCity,this.value,'i1_districtbusiness');
}
i$('i0_subway').onchange = function(){
	CAI.inSubwayStation(defaultCity,this.value,'i0_subwaystation');
}
i$('i2_cycle').onchange = function(){
	CAI.inCycleFace('i2_cycleface');
}

CAI.inDistrict(defaultCity,'i1_district') ;
CAI.inSubway(defaultCity,'i0_subway') ;
CAI.inCycle(defaultCity,'i2_cycle') ;

function doIndexQuery(vi){
	var ss = i$s('index_list01','select') ;
	var idata = {} ;
	idata.ar = '0' ;
	idata.sr = '0' ;
	idata.rt = '0' ;
	idata.it = '0' ;
	idata.p = '0' ;
	idata.order = '0' ;
	idata.ah = '0' ;
	idata.noreset = '0' ;
	
	idata.zz = '0' ;
	
	idata.mtab = vi ;
	for(var i=0;i<ss.length;i++){
		if(!ss[i].id || ss[i].id.indexOf('i')!=0) continue ;
		var v = ss[i].value ;
		
		if(!/^\d+$/.test(v)){
			var xs = ss[i].options[ss[i].selectedIndex];
			if(xs == undefined) {
				v = '';
			} else {
				var tmp = ss[i].options[ss[i].selectedIndex].getAttribute('cid') ;
				if(tmp) v = tmp ;
				else v = '' ;
			}
		}
		
		var tmp = ss[i].id.indexOf('i') ;
		var k = ss[i].id.substr(tmp+3) ;
		var n = ss[i].id.substr(1,1) ;
		if(typeof idata[k] == 'undefined') idata[k] = '0' ;
		if(v == '' || v == '0') continue ;
		
		if(n == vi) idata[k] = v ;
	}
	if(idata.yy != '0'){
		idata.zz = '2' ;
		idata.noreset = '4' ;
	}

	var url = '{get_url_nlist()}';
	var params = "";
	if(vi=='0') {
		//url += "/m1";
		params = "-m1";
	}
	// var url = baseIndexQUrl;
	//alert(url);
	//alert(idata);
	
	for(var i in idata){
		switch(i) {
			case "district":
				params +="-d"+idata[i];
				break;
			case "districtbusiness":
				params +="-b"+idata[i];
				break;
			case "pr":
				params +="-r"+idata[i];
				break;
			case "hp":
				params +="-h"+idata[i];
				break;
			case "yy":
				params +="-y"+idata[i];
				break;
			case "subway":
				params +="-s"+idata[i];
				break;
			case "subwaystation":
				params +="-t"+idata[i];
				break;
			case "cycle":
				break;
			case "cycleface":
				break;
		}
		//url = url.replace(new RegExp('{'+i+'}','gm'),idata[i]) ;
	}
	if(params.substr(0, 1) == "-") {
		params = params.substr(1, params.length);
	}
	//alert(params);
	//alert(params.substr(0,url.indexOf('0')));
	//if(params.indexOf('-')==0) params = params.substr(0,params.length) ;
	//url = url.replace(/(-0)*(.html)?$/,'') ;
	//if(url.indexOf('0') == url.length-1) url = url.substr(0,url.indexOf('0')) ;
	//url = url.substr(0,url.indexOf('0')) ;
	//if(url.lastIndexOf('/') != url.length-1 && url.indexOf('.html')==-1) url += '.html' ;
	window.location.href = url+params +".html";
}

(function(){
	window.lastHPGSYY = {} ;
	var ss = i$s('index_list01','select') ;
	for(var i=0;i<ss.length;i++){
		if(!ss[i].id || ss[i].id.indexOf('_hp') == -1) continue ;
		
		ss[i].onchange = function(){
			var yyid = this.id.replace('_hp','') + '_yy' ;
			if(this.options[this.options.selectedIndex].text.indexOf('闺宿') == -1){
				i$(yyid).options[1].disabled = false ;
			}else{
				if(iv$(yyid) == '1'){
					i$(yyid).value = '2' ;
				}
				i$(yyid).options[1].disabled = true ;
			}
		}
	}
}()) ;
</script>


<div class="index_menu" id="index_menua">
<div class="index_img"><img src="{STATIC_HTTP}images/index_list_quick.gif" alt="" width="76" height="74" /></div>
<ul>
  <li class="sec2"  onclick="secBoard(0)"><a href="javascript:;" onclick="return false;">区域</a></li>
  <li class="sec1"  onclick="secBoard(1)"><a href="javascript:;" onclick="return false;">地铁</a></li>
  <li class="sec1"  onclick="secBoard(2)"><a href="javascript:;" onclick="return false;">环线</a></li>
  <li class="sec1"  onclick="secBoard(3)"><a href="javascript:;" onclick="return false;">特色</a></li>
</ul>
</div>
</div>


<div class="index_moive">
	<a href="http://pic.ziroom.com.cn/show/index.html" target="_blank" style="float:right;"><img src="{STATIC_HTTP}images/index_moive_2.png" height="110" /></a>
	<a href="/z/i/myziroomstory.html" target="_blank" style="float:left;"><img src="{STATIC_HTTP}images/index_moive_1.png" height="110" /></a>
	<div class="clear"></div>
    <div class="shida"><a href="{get_url_zhaopin()}" target="_blank"><img src="{STATIC_HTTP}images/whh_index_ad.gif" /></a></div>
</div>

</div>

<div id="content_three">
  <ul>
  <li><img class="index_img01" src="{STATIC_HTTP}images/index01_03.gif" alt="" width="276" height="69" /><span class="title_index">自如网是做什么的？</span>
  <p >&nbsp;&nbsp;&nbsp;&nbsp;自如网致力于为网友创造品质租住生活。所有房屋实施统一装修、家居、家电配置等。<br />
    &nbsp;&nbsp;&nbsp;&nbsp;您只需要考虑自己的目标地段，装修、家具家电、保洁、维修等等都由自如网完成。<br />
    &nbsp;&nbsp;&nbsp;&nbsp;第一期合租产品——自如•友家已经上线。<br />
    提供：租客认证、一客一锁、免费宽带、宜家家具、品牌家电、靓居保洁、及时维修……，让您居住无忧。</p></li>
  <li><img class="index_img01" src="{STATIC_HTTP}images/index01_08.gif" alt="" width="276" height="69" /><span class="title_index" >自如网适合什么样的租客？</span><p >&nbsp;&nbsp;&nbsp;&nbsp;不论是繁忙的单身白领精英，还是活力温馨的两口小家，如果你还在挑剔找不到干净、整洁的好房子，那么就来自如网。<br />
&nbsp;&nbsp;&nbsp;&nbsp;我们正在“建”房子，以配得上追求品质的你！<br />
&nbsp;&nbsp;&nbsp;&nbsp;自如客们都追求安全、便捷、品质的生活，在这里不仅能找到中意的房子，还能碰到同样兴趣的朋友。</p></li>
  <li><img class="index_img01" src="{STATIC_HTTP}images/index01_06.gif" alt="" width="276" height="69" /><span class="title_index">自如网的品质保障承诺！</span>
    <p ><strong>时效房源</strong>：保障所有房源均为实时的真实信息。<br />
<strong>一房一价</strong>：所有房源均采用实价销售，如果您的实际成交价格不同于网站价格，我们将双倍返还差价。<br />
<strong>全真配置</strong>：自如网对所有房源均提供标准化的产品和服务，如果您发现房源图片中，有任何产品与实际不符，我们将为您免费更换。<img  style=" display:block; width:187px; margin:5px auto 0 auto;" src="{STATIC_HTTP}images/pingzhi.gif" alt="" width="187" height="61" /></p></li>
</ul>
</div>


{template 'footer.tpl'}
