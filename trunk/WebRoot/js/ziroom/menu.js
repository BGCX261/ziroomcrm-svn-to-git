/**
 * 系统一级菜单导航
 * 
 * @param action
 */
function forwardLeftMenu(action) {
	mainFrame.src = "center.do";
}

/**
 * tab页js
 * @param m
 * @param n
 * @param count
 */
function showtabs(m,n,count) {
	for(var i=1;i<=count;i++) {
		if(i == n) {
			$("#menutab_"+m+"_"+i).css("display", '');
			$("#menu_"+m+"_"+i).addClass("menub1_1");
			$("#menu_"+m+"_"+i).removeClass("menub1_2");
		} else {
			$("#menutab_"+m+"_"+i).css("display", 'none');
			$("#menu_"+m+"_"+i).addClass("menub1_2");
			$("#menu_"+m+"_"+i).removeClass("menub1_1");
		}
	}
}