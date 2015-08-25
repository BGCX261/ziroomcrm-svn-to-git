//全局变量定义
var CANVAS_WIDTH = 400; //画布的宽
var CANVAS_HEIGHT = 300; //画布的高
//var ICON_SIZE = 220;  //截取框的大小，正方形
var WIDTH_ICON_SIZE = 290;
var HEIGHT_ICON_SIZE = 220;
var LEFT_EDGE = (CANVAS_WIDTH - WIDTH_ICON_SIZE) / 2; //82
var TOP_EDGE = (CANVAS_HEIGHT - HEIGHT_ICON_SIZE) / 2; //73
var RIGHT_EDGE = LEFT_EDGE + WIDTH_ICON_SIZE;
var BOTTOM_EDGE = TOP_EDGE + HEIGHT_ICON_SIZE;

var CANVAS_LEFT_MARGIN = 4;
var CROP_LEFT = LEFT_EDGE;
var CROP_TOP = - BOTTOM_EDGE;


$(window).load(function() {
    var iconElement = $("#cut_img");

    //获取上传图片的实际高度，宽度
    var image = new Image();
    image.src = iconElement.attr("src");
    var realWidth = image.width;
    var realHeight = image.height;  
    image = null;       
   
    //计算缩放比例开始
    var minFactor = Math.max(WIDTH_ICON_SIZE, HEIGHT_ICON_SIZE) / Math.max(realWidth, realHeight);
    if (WIDTH_ICON_SIZE > realWidth && HEIGHT_ICON_SIZE > realHeight) {
        minFactor = 1;
    }
    var factor = minFactor > 0.25 ? 8.0 : 4.0 / Math.sqrt(minFactor);
	
    //图片缩放比例
    var scaleFactor = 1;

    //图片实际尺寸，并近似到整数
    var currentWidth = Math.round(scaleFactor * realWidth);
    var currentHeight = Math.round(scaleFactor * realHeight);


    //图片相对CANVAS的初始位置，图片相对画布居中
	var	originLeft = (CANVAS_WIDTH - realWidth) / 2;
	var	originTop = - (CANVAS_HEIGHT + realHeight) / 2;

    //设置图片当前尺寸和位置
	iconElement.css({ width: currentWidth + "px", height: currentHeight + "px", left: (originLeft - (currentWidth - realWidth) / 2) + "px" , top: (originTop - (currentHeight - realHeight) / 2) + "px" });

	var oldMoveLeft = 0;
	var oldMoveTop = 0;
	var oldMoveScaleFactor = 0;
	var initialValue = true;
	
	
	$("#cut_img").load(function() {
		//获取上传图片的实际高度，宽度
		var image = new Image();
		image.src = $("#cut_img").attr("src");
		realWidth = image.width;
		realHeight = image.height;  		     
	   
		//计算缩放比例开始
		minFactor = Math.max(WIDTH_ICON_SIZE, HEIGHT_ICON_SIZE) / Math.max(realWidth, realHeight);
		if (WIDTH_ICON_SIZE > realWidth && HEIGHT_ICON_SIZE > realHeight) {
			minFactor = 1;
		}
		factor = minFactor > 0.25 ? 8.0 : 4.0 / Math.sqrt(minFactor);
		
		//图片缩放比例
		scaleFactor = 1;
		var initValue = 5;

		if (realWidth > CANVAS_WIDTH && realHeight > CANVAS_HEIGHT) {
			if (realWidth / CANVAS_WIDTH > realHeight / CANVAS_HEIGHT) {
				scaleFactor = CANVAS_HEIGHT / realHeight;
			}
			else {
				scaleFactor = CANVAS_WIDTH / realWidth;
			}
		}

		initValue = 200 *  (Math.log(scaleFactor*factor)/Math.log(factor));
		$(".child").css("left", initValue + "px");

		//图片实际尺寸，并近似到整数
		var currentWidth = Math.round(scaleFactor * realWidth);
		var currentHeight = Math.round(scaleFactor * realHeight);


		//图片相对CANVAS的初始位置，图片相对画布居中
		var originLeft = (CANVAS_WIDTH - realWidth) / 2;
		var originTop = - (CANVAS_HEIGHT + realHeight) / 2;


		//设置图片当前尺寸和位置
		iconElement.css({ width: currentWidth + "px", height: currentHeight + "px", left: (originLeft - (currentWidth - realWidth) / 2) + "px" , top: (originTop - (currentHeight - realHeight) / 2) + "px" });

		oldMoveScaleFactor = scaleFactor;
		oldMoveLeft = parseInt(iconElement.css("left"));
		oldMoveTop = parseInt(iconElement.css("top"));
		
		//初始化默认值
		$("#txt_left").val(CROP_LEFT - parseInt(iconElement.css("left")));
		$("#txt_top").val(CROP_TOP - parseInt(iconElement.css("top")));
		$("#txt_Zoom").val(scaleFactor);
	});	
	
	
	$.ui.disableSelection($("#Crop"));
	$("#Crop").mousedown( function(ev) { $('#cut_img').trigger('mousedown.draggable', [ev]);}); 


    //设置图片可拖拽
	$("#cut_img").draggable(
    {
		cursor: 'move',
        drag: function(e, ui) {	
		  scaleFactor = $("#txt_Zoom").val();          
		  iconElement = $("#cut_img");
          
          var image = new Image();
          image.src = iconElement.attr("src");
          realWidth = image.width;
          realHeight = image.height;
          image = null;

          //图片实际尺寸
          currentWidth = Math.round(scaleFactor * realWidth);
          currentHeight = Math.round(scaleFactor * realHeight);

		  originLeft = (CANVAS_WIDTH - realWidth) / 2;
		  originTop = - (CANVAS_HEIGHT + realHeight) / 2;

          //图片当前尺寸和位置
		  //iconElement.css({ width: currentWidth + "px", height: currentHeight + "px", left: (originLeft - (currentWidth - realWidth) / 2) + "px" , top: (originTop - (currentHeight - realHeight) / 2) + "px" });

          oldMoveLeft =  parseInt(iconElement.css("left"));
		  oldMoveTop =  parseInt(iconElement.css("top"));
		  oldMoveScaleFactor = scaleFactor;

		  $("#txt_Zoom").val(scaleFactor);
		  $("#txt_left").val(CROP_LEFT - parseInt(iconElement.css("left")));
		  $("#txt_top").val(CROP_TOP - parseInt(iconElement.css("top")));
		}

    });

    //缩放的代码，要缩放以截取框为中心，所以要重新计算图片的left和top
    $(".child").draggable(
    {
      cursor: "move", containment: $("#bar"),
      drag: function(e, ui) {
		  var left = parseInt($(this).css("left"));          
		  initialValue = false;
		  SilderSetValue(left);  

          $("#txt_Zoom").val(scaleFactor);
		  $("#txt_left").val(CROP_LEFT - parseInt(iconElement.css("left")));
		  $("#txt_top").val(CROP_TOP - parseInt(iconElement.css("top")));

      }
  });

    var SilderSetValue = function(value) {

		if (initialValue)
		{
			scaleFactor = 1;
			initialValue = false;
		}
		else
		{
			scaleFactor = Math.pow(factor, value/200) / factor;			
		}
		
		if(scaleFactor < minFactor) 
		{
		    scaleFactor = minFactor;
		}
		//alert(scaleFactor);
		currentWidth = scaleFactor * realWidth;
		currentHeight = scaleFactor * realHeight;		
		iconElement.css("width",currentWidth + "px");		
		iconElement.css("height",currentHeight + "px");

		if(oldMoveScaleFactor == 0)
		{
			oldMoveScaleFactor = scaleFactor;
		}
		if(oldMoveLeft == 0)
		{
			oldMoveLeft = parseInt(iconElement.css("left"));
			
		}
		if(oldMoveTop == 0)
		{
			oldMoveTop = parseInt(iconElement.css("top"));
		}
		
		iconElement.css("left",Math.round(CANVAS_WIDTH/2 - (CANVAS_WIDTH/2-oldMoveLeft)*scaleFactor/oldMoveScaleFactor) + "px");
		iconElement.css("top",Math.round((CANVAS_HEIGHT/2+oldMoveTop)*scaleFactor/oldMoveScaleFactor - CANVAS_HEIGHT/2) + "px");
		

    }

    //点击加减号
    $("#shrink").click(function() {	
		var childleft = parseInt($("#silder").css("left"));
		if (childleft < 5)	{
			$("#silder").css("left", 0 + "px");
		}
		else{
			$("#silder").css("left", childleft - 5 + "px");
			childleft = childleft - 5;
		}

		initialValue = false;
		SilderSetValue(childleft);  

        $("#txt_Zoom").val(scaleFactor);
		$("#txt_left").val(CROP_LEFT - parseInt(iconElement.css("left")));
		$("#txt_top").val(CROP_TOP - parseInt(iconElement.css("top")));
    });
    
    $("#zoom").click(function() {
		var childleft = parseInt($("#silder").css("left")) ;
		//alert(childleft);
		if (childleft >= 216)	{
			$("#silder").css("left", 216 + "px");
		}
		else{
			$("#silder").css("left", childleft + 5 + "px");
			childleft = childleft + 5;
		}

		initialValue = false;
		SilderSetValue(childleft);  

        $("#txt_Zoom").val(scaleFactor);
		$("#txt_left").val(CROP_LEFT - parseInt(iconElement.css("left")));
		$("#txt_top").val(CROP_TOP - parseInt(iconElement.css("top")));
    });

});