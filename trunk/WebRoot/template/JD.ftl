{php $header['title']='【自如友家_经典】'} {template 'header.tpl'}
<div id="zr_bg">
	<!--有家的图片开头-->
	<div class="youjia_bg">
		<img src="{STATIC_HTTP}images/youjia_bg.png" width="919" height="425" />
		<div class="youjia_middle">
			<div class="youjia_float01">
				<img src="{STATIC_HTTP}images/youjia_01.png" width="104"
					height="104" />
			</div>
			<div class="youjia_float02">
				<img src="{STATIC_HTTP}images/youjia_02.png" width="104"
					height="104" />
			</div>
			<div class="youjia_float03">
				<img src="{STATIC_HTTP}images/youjia_03.png" width="104"
					height="104" />
			</div>
			<div class="youjia_title_bg">
				<span class="youjia_big_t">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>友家，</strong>
				</span><span class="youjia_big_t" style="color: #0099CC"><strong>克制与尊重</strong>
				</span>
				<br />
				<br />
				&nbsp;&nbsp;&nbsp;&nbsp;生活中难免有磕绊，我们应互相尊重，并保持必要的克制。在自如·友家，我们希望你好似进入朋友的家，既自如又轻松，又尊重朋友的生活习惯和生活方式。
			</div>
			<div class="youjia_title_bg">
				<br />
				<br />
				&nbsp;&nbsp;&nbsp;&nbsp;拥有一个家，原来可以很自如。在这里，我们大方分享自己的快乐，
				</span>我们主动担当家中的事务，我们共同维护公共区间，因为这里是我们共同的家。
				</span>
				<br />
				<br />
				<span class="youjia_big_t">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>友家，</strong>
				</span><span class="youjia_big_t" style="color: #F60;"><strong>分享与担当</strong>
				</span>
			</div>
			<div class="youjia_title_bg">
				<span class="youjia_big_t">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>友家，</strong>
				</span><span class="youjia_big_t" style="color: #74c0d0;"><strong>快乐与善意</strong>
				</span>
				<br />
				<br />
				&nbsp;&nbsp;&nbsp;&nbsp;在利润驱动的市场中，我们坚持不做群租。友家中每一份子的快乐，都会给友邻快乐。友家中每一份子的善意，都会得到
				友邻善意的回馈。
			</div>
		</div>
	</div>

	<!--列表的代表-->
	<div class="zhuanti_list">
		<#list special as u>
		<div class="zhuanti_zong">
			<!--<div class="zhuanti_rent"></div>-->
			<p class="zhuanti_top"></p>
			<div class="zhuanti_middle">
				<a href="/z/vr/${u.url}" target="_blank"><img src="{STATIC_HTTP}${u.imagePath}" width="292" height="219" /></a>
				<p class="zhuanti_txt">
					${title} ${u.roomName}
				</p>
				<p class="zhuanti_price"></p>
				<p style="height: 20px;">
					${u.roomType}&nbsp;&nbsp;${u.roomArea}㎡&nbsp;&nbsp;${u.roomPosition}卧&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;保洁费
					${u.cleaningFee}元/月
				</p>
			</div>
			<p class="zhuanti_bottom"></p>
		</div>
		</#list>

		{php $NO_S_BOTTOM=true} {template 'footer.tpl'}