{php $header['title']='【自如友家_闺宿】'}
{template 'header.tpl'}
<div id="zr_bg">
  <!--有家的图片开头-->
<div class="guisu_bg"></div>
<div class="guisu_middle">
<div class="guisu_big01">&nbsp;&nbsp;&nbsp;&nbsp;如果你喜欢用照片秀一下自己的小屋，那么闺宿是你最好的选择。因为闺宿从房屋色彩到家具选择，都充分考虑到了女生的偏好。<span style="color:#F90">温馨、可爱、浪漫是这里的主题词。</span>入住闺宿的第一件事，就是拿起相机把她小屋分享给闺中蜜友吧。
</div>

<div class="guisu_big02">&nbsp;&nbsp;&nbsp;&nbsp;如果你担心下班晚了，回家不方便、不安全，那么闺宿产品是在同区域中地理位置最好的，<span style="color:#F90">一般离地铁口、公交站会相对更近，下了车不用多久你就可以步行到家了。</span>同时小区的物业也是同区域中较好的，在居住安全上让女生们高枕无忧。</div>
<div class="guisu_big03">&nbsp;&nbsp;&nbsp;&nbsp;如果你私密衣物需要阳光晾晒，那么闺宿产品中的房源已经考虑到女生对采光的需求，<span style="color:#F90">尽最大所能选取采光条件较好的房型。</span></div>
</div>


<div style="margin:10px auto; width:395px;">
<img src="{STATIC_HTTP}images/guisu_bottom.gif" width="395" height="35" /></div>



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