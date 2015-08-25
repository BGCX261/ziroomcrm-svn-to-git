/**
 * 表单验证方法
 * @param style 错误提示样式
 * @param form 表单ID
 * @param methods 扩展方法数组列表
 * @returns {Boolean}
 */
function strutsValidator(style, form, methods) {
	var errors = new Array();
	var method = form + "()";
	errors = eval(method);
	/*
	var index = errors.length;
	if (typeof methods != "undefined") {
		for (var i = 0; i < methods.length; i++) {
			var mtd = methods[i] + "()";
			var msg = eval(mtd);
			if (msg != "") {
				var add = true;
				for (var j = 0; j < errors.length; j++) {
					var o = errors[j];
					if (o.field == msg.field) {
						add = false;
						break;
					}
				}
				if (add) {
					errors[index++] = msg;
				}
			}
		}
	}
	*/
	// 没有错误提交表单
	if (errors.length == 0) {
		return true;
	}
	// 输出错误提示信息
	var msg = "";
	for (var i = 0; i < errors.length; i++) {
		var o = errors[i];
		msg += o.error + "\n";
	}
	msg = "以下原因导致提交失败：\n" + msg;
	alert(msg);
	return false;
}

/**
 * 扩展jQuery
 */
(function($) {
	$.fn.extend({
		validator : function(json) {
			var obj = this;
			// 错误信息列表
			var errors = new Array();
			var index = 0;
			$.each(json, function(field, rules) {
				// 字段验证
				var str = $.rule(obj, field, rules);
				if (str != "") {
					errors[index++] = {"field":field,"error":str};
				}
			});
			return errors;
		}
	});
})(jQuery);