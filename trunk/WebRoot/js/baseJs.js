/**
 * 
 */
function toHide1(){
	$(document).find('#dlzh1').hide();
}
function toHide2(){
	$(document).find('#dlzh2').hide();
} 
function toHide3(){
	$(document).find('#input03').attr('value','');
}
function toHide4(){
	$(document).find('#txlan').slideToggle();
}
function dis(){
	$('#txlan').show(500);
}
function blur1(){
	if($('#input01').attr('value')=='') $(document).find('#dlzh1').show();
	if($('#input01').attr('value')!='') $('#input01').attr('value',this.value);
	
}
function blur2(){
	if($('#input02').attr('value')=='') $(document).find('#dlzh2').show();
	if($('#input02').attr('value')!='') $('#input02').attr('value',this.value);
}
function blur3(){
	if($('#input03').attr('value')=='') $('#input03').attr('value','输入结果');
	if($('#input03').attr('value')!='') $('#input03').attr('value',this.value);
}