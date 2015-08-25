{php $header['title']='【自如友家_原创】'}
{template 'header.tpl'}
<div id="zr_bg">
<div class="zr_block"></div>

<!--design的图片开头-->
<div class="design_bg"></div>
<div class="zhuanti_list">
  <#list special as u>
  <div class="zhuanti_zong">
  <!--<div class="zhuanti_rent"></div>-->
  <p class="zhuanti_top"></p>
  <div class="zhuanti_middle">
  <a href="/z/vr/${u.url}" target="_blank"><img name="" src="{STATIC_HTTP}${u.imagePath}" width="292" height="219" alt="" /></a>
  <p class="zhuanti_txt">友家·原创 ${u.roomName}</p>
  <p class="zhuanti_price"></p>
  <p  style="height:20px;">${u.roomType}&nbsp;&nbsp;${u.roomArea}㎡&nbsp;&nbsp;${u.roomPosition}卧&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;保洁费 ${u.cleaningFee}元/月</p>

  </div>
  <p class="zhuanti_bottom"></p>
  </div>
  </#list>


{php $NO_S_BOTTOM=true} {template 'footer.tpl'} 