$(function(){
	$(".tableList tbody tr").bind("mouseover", function() {
		$(this).css("backgroundColor", "#c1ebff");
	});
	$(".tableList tbody tr").bind("mouseout", function() {
		$(this).css("backgroundColor", "");
	});
});