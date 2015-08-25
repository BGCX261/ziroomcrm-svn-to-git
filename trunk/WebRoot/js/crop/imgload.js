$(document).ready(function() {

//$("#step2").css({display:"none"});
$("#myform").submit( function() {
    return  jsUpload();
}); 

$("#returntoindex").click(function(){
	window.location.href="index.php?r=member/member/getMemberInfo";	
});

});

function checkfile(filename)
{
	var  filetype=filename.split(".");
	var filelength=filetype.length;
	var filenumber=filelength-1;
	filetype = filetype[filenumber].toLowerCase();
	
	if(filetype =="jpg" || filetype =="gif" || filetype =="png" || filetype == "bmp" )
	{
	  return true;
	}
	else {
		return false;
	}
}

function jsUpload()
{
	//var reg = new RegExp("([.jpg|.gif|.png]$)","i");
	var filename = $("#file").val();
	
	if(!checkfile(filename)){
		
	  $("#errormsg").text("您选择的文件格式不符合要求，请重新上传");
	  $("#step1").show();
	  return false;
	}
	
	$("#errormsg").text("");

	return true;
}
