$(document).ready(function() {
 	/*
	var getUrl = 'index.php?r=folder/search/photoFolder';
	$.post(getUrl,function(retstr){			
			$("#folders").html(retstr);
	});
	*/

	//默认列出图片列表
	getImages();

	$("#folderList").change(function(){getImages();})
	$("#confirm").click(function(){formsubmit();})
	
});

var url = '';
function formsubmit(){	
	if (url == '')
	{		
		$("#errorsrc").text("请选取图片");
		return false;
	}	
	
	//将图片保存到kaopu服务器
	var getUrl = "index.php?r=member/image/saveToLocal";
	//alert("url:"+url);
	$.post(getUrl,{url:url},function(retstr){
		    //alert(retstr);
			var rets = retstr.split('@@');
			//alert("return2"+rets[0]);	
			var filename = rets[1];
			var dir = rets[0];
			
			$("#cut_img").attr("src",'upload/photo/'+dir+'/'+filename);
			$("#filename").val(filename);
			$("#dirname").val(dir);
			$("#step2").css("display","block");
			$("#step1").css("display","none");
			
			$("#user_img_a").css({display:"none"});
			
	});
	
	
	
}

function getImages(){
  var foldId = $("#folderList").val();
  //alert(33);
  var img = '<ul>';  
  var size = 0;
      	
  if(foldId == ''){
	  $("#imagelist").html('');
	  
  }else{
  	/**
	  //alert(111);
  	  //alert(foldId);
      var getUrl = 'index.php?r=file/search/PhotoSearch';
      var srcurl = '';

      $.post(getUrl,{path:foldId},function (rets){
      	//alert(rets);
      	rets = eval(rets);
        if(rets.length>0){	
      	  	
        for(var i=0;i<rets.length;i++){
			//alert(kaopu_alfresco_url);
			//http://storage.kaopu.com:8080/space/d/s/workspace/@kaopu.01@SpacesStore/e948058a-058f-4f3c-8d84-0565fde63e24/201068203615421.jpg;jsessionid=7AC040F1926DABDF7CE3B2CCA705C581.jvm14?ticket=ST-186725-brwW6OFK9YBez9kgKgMI&oid=kaopu.com
			url = kaopu_alfresco_url+'/space/d/s/workspace/@kaopu.01@SpacesStore/'+rets[i]['id']+'/'+rets[i]['name']+'?userId='+rets[i]['creator']+'&oid='+home_domain;
			srcurl = kaopu_alfresco_url+'/space/d/s/workspace/@kaopu.01@SpacesStore/'+rets[i]['id']+'/'+rets[i]['name'];
			//alert(url);
			//alert(srcurl);
			size = rets[i]['size'];
			if (((size/1024)/1024) <= 2.5 ){				
				img += '<li class="y3_xztx_libj1" id="wj'+rets[i]['id']+'">';
				img+='<img id="'+rets[i]['id']+'"  val="'+srcurl+'" src="'+url+'" width="20px" height="20px" title="'+rets[i]['name']+'"/>';
				img+='<span>'+rets[i]['name']+'</span></li>';
			}
		}		
      }
      
      img += '</ul>';  	
 	
   
      	$("#imagelist").html(img);
      	$("#selectedImg").val();      	
      	
      	$("#imagelist li").click(function(){
      	var file_id = $(this).attr("id");
      	file_id = file_id.replace("wj","");
      	
      	if(typeJudge($("#" + file_id).attr("title"))){
      		$("#imagelist li").css("backgroundColor","#FFFFFF");
      		$(this).css("backgroundColor","#EAF9FE");
      		$("#selectedImg").val($("#" + file_id).attr("title"));
			url=$("#" + file_id).attr("val");
			//alert(url);
			$("#confirm").removeAttr("disabled") ;
		}
		}
		
		)});
		**/
  }
}

function typeJudge(src)
{
	  photoEx=src.substring(src.lastIndexOf("."));   
 
	  if(photoEx.toLowerCase()==".jpg" || photoEx.toLowerCase()==".gif" || photoEx.toLowerCase()==".png" || photoEx.toLowerCase()==".bmp"){   
		$("#errorsrc").text(""); 
	  	return true;  
	  }else{   		
		$("#errorsrc").text("请选择符合要求的图片");
	  return false;   
	  }

	return true;
}

function goout()
{
		$("#file").val("");
		$("#step2").css("display","none");
		//$("#step1").css("display","none");
		$(".danqiantx").css("display","");
}