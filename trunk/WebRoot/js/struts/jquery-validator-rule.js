/**
 * 扩展jQuery加入简单验证方法
 */
(function($) {
	$.extend({
			/**
			 * jQuery form表单验证规则方法
			 * 
			 * @param obj
			 *            表单对象
			 * @param field
			 *            字段
			 * @param rules
			 *            验证规则
			 */
			rule : function(obj, field, rules) {
				// 获得表单指定的值
				var value = $.getFormFieldValue(obj, field);
				//alert(field + ":" + value);
				var msg = "";
				// requiredstring验证
				if(rules.requiredstring) {
					msg = $.requiredstring(value, eval("rules.requiredstring"));
					if(msg != "") {
						return msg;
					}
				}
				// stringlength验证
				if(rules.stringlength) {
					msg = $.stringlength(value, eval("rules.stringlength"));
					if(msg != "") {
						return msg;
					}
				}
				// required验证
				if(rules.required) {
					msg = $.requiredstring(value, eval("rules.required"));
					if(msg != "") {
						return msg;
					}
				}
				// int验证
				if(rules.int) {
					msg = $.int(value, eval("rules.int"));
					if(msg != "") {
						return msg;
					}
				}
				// double验证
				if(rules.double) {
					msg = $.double(value, eval("rules.double"));
					if(msg != "") {
						return msg;
					}
				}
				// date验证
				if(rules.date) {
					msg = $.date(value, eval("rules.date"));
					if(msg != "") {
						return msg;
					}
				}
				// email验证
				if(rules.email) {
					msg = $.email(value, eval("rules.email"));
					if(msg != "") {
						return msg;
					}
				}
				// url验证
				if(rules.url) {
					msg = $.url(value, eval("rules.url"));
					if(msg != "") {
						return msg;
					}
				}
				// regex验证
				if(rules.regex) {
					msg = $.regex(value, eval("rules.regex"));
					if(msg != "") {
						return msg;
					}
				}
				return msg;
			},
			/******************************以下是扩展JQuery添加验证方法*****************************************/

			/**
			 * 字符串必填校验，字符串不等""
			 * 
			 * @param val
			 * @param rule
			 */
			requiredstring : function(val, rule) {
				var msg = "";
				val = val.replace(/(^\s*)|(\s*$)/g, "");
				if (val.length == 0) {
					msg = rule.msg;
				}
				return msg;
			},
			/**
			 * 字符串长度范围验证
			 * 
			 * @param val
			 * @param rule
			 * @returns {String}
			 */
			stringlength : function(val, rule) {
				var msg = "";
				var isError = true;
				var len = val.length;
				if (rule.minLength) {
					min = rule.minLength;
					if (parseInt(len) < parseInt(min)) {
						isError = false;
					}
				}
				if (rule.maxLength) {
					max = rule.maxLength;
					if (parseInt(len) > parseInt(max)) {
						isError = false;
					}
				}
				if (!isError) {
					var s = rule.msg;
					msg = s.replace("{min}", min);
					msg = msg.replace("{max}", max);
				}
				return msg;
			},
			/**
			 * 整数校验方法
			 * 
			 * @param val
			 * @param rule
			 * @returns {String}
			 */
			int : function(val, rule) {
				var msg = "";
				var isError = true;
				var reg = /^(\d*|\-?[1-9]{1}\d*)$/;
				if (!val.match(reg)) {
					return "请输入整数";
				}
				if (rule.min) {
					min = rule.min;
					if (parseInt(val) < parseInt(min)) {
						isError = false;
					}
				}
				if (rule.max) {
					max = rule.max;
					if (parseInt(val) > parseInt(max)) {
						isError = false;
					}
				}
				if (!isError) {
					var s = rule.msg;
					msg = s.replace("{min}", min);
					msg = msg.replace("{max}", max);
				}
				return msg;
			},
			/**
			 * 数值型数据验证方法
			 * 
			 * @param val
			 * @param rule
			 */
			double : function(val, rule) {
				var msg = "";
				var isError = true;
				var reg = (/^-?([1-9]\d*\.\d+|[1-9]\d*|0|0\.\d*[1-9])$/);
				if (!val.match(reg)) {
					return "请输入数值";
				}
				if (rule.minInclusive) {
					min = rule.minInclusive;
					if (parseFloat(val) < parseFloat(min)) {
						isError = false;
					}
				}
				if (rule.maxInclusive) {
					max = rule.maxInclusive;
					if (parseFloat(val) > parseFloat(max)) {
						isError = false;
					}
				}
				if (!isError) {
					var s = rule.msg;
					msg = s.replace("{min}", min);
					msg = msg.replace("{max}", max);
				}
				return msg;
			},
			/**
			 * 日期验证
			 * 
			 * @param val
			 * @param rule
			 */
			date : function(val, rule) {
				var msg = "";
				var isError = true;
				var reg = (/^[1-2]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|[3][0-1])$/);
				if (!val.match(reg)) {
					return "请输入日期";
				} else {
					if (!$.isDate(val)) {
						return "请输入合法的日期。";
					}
				}
				var d = new Date(Date.parse(val.replace(/-/g, "/")));
				// 日期范围验证
				if (rule.min) {
					min = rule.min;
					var m = new Date(Date.parse(min.replace(/-/g, "/")));
					
					if (d < m) {
						isError = false;
					}
				}
				if (rule.max) {
					max = rule.max;
					var m = new Date(Date.parse(max.replace(/-/g, "/")));
					if (d > m) {
						isError = false;
					}
				}
				if (!isError) {
					var s = rule.msg;
					msg = s.replace("{min}", min);
					msg = msg.replace("{max}", max);
				}
				return msg;
			},
			/**
			 * 正则表达式验证
			 * 
			 * @param val
			 * @param rule
			 * @returns {String}
			 */
			regex : function(val, rule) {
				var msg = "";
				var isError = true;
				if (val == null || val == "") {
					return "";
				} else {
					var reg = rule.expression;
					if (!val.match(reg)) {
						return rule.msg;
					}
				}
				return msg;
			},
			/**
			 * 电子邮箱验证
			 * 
			 * @param val
			 * @param rule
			 * @returns {String}
			 */
			email : function(val, rule) {
				var reg = /^[_A-Za-z0-9]+(.[_A-Za-z0-9]+)*@[A-Za-z0-9]+(.[_A-Za-z0-9]+)+$/;
				rule.expression = reg;
				return $.regex(val, rule);
			},
			/**
			 * 网址验证
			 * 
			 * @param val
			 * @param rule
			 * @returns
			 */
			url : function(val, rule) {
				var reg = /^(https?):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i;
				rule.expression = reg;
				return $.regex(val, rule);
			},
			/**
			 * @TODO 
			 * 表达式验证
			 * 
			 * @param val
			 * @param rule
			 * @returns {String}
			 */
			fieldexpression : function(obj, val, rule) {
				var msg = "";
				if (!$.expression(obj, val, rule.expression)) {
					msg = rule.msg;
				}
				return msg;
			},
			/**
			 * 日期合法验证
			 * 
			 * @param val
			 * @returns {Boolean}
			 */
			isDate : function(val) {
				var isTrue = true;
				var year, month, day;
				var d = val.split("-");
				year = parseInt(d[0]);
				month = parseInt(d[1]);
				day = d[2];
				switch (month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if (parseInt(day) <= 31 && parseInt(day) > 0) {
						isTrue = true;
					} else {
						isTrue = false;
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if (parseInt(day) <= 30 && parseInt(day) > 0) {
						isTrue = true;
					} else {
						isTrue = false;
					}
					break;
				case 2:
					if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
						if (parseInt(day) <= 29 && parseInt(day) > 0) {
							isTrue = true;
						} else {
							isTrue = false;
						}
					} else {
						if (parseInt(day) <= 28 && parseInt(day) > 0) {
							isTrue = true;
						} else {
							isTrue = false;
						}
					}
					break;
				}
				return isTrue;
			},
			/**
			 * 表达式验证
			 * @param val
			 * @param style
			 * @returns {Boolean}
			 */
			expression : function(obj, val, style) {
				var reg = new RegExp(/==/, g);
				return true;
			},
			/**
			 * 获得form表单字段值
			 * @param obj
			 * @param field
			 */
			getFormFieldValue : function(obj, field) {
				// 根据field获得表单元素
				var element = obj.find(":input[name='" + field + "']")[0];
				var value = "";
				// 判断元素类型(只判断第一个,如果有相同重复的name属性元素只取第一个)
				if ($(element).is("input[type=text],input[type=hidden],input[type=password],input[type=file]")) {
					value = $(element).val();
				} else if ($(element).is("input[type=checkbox]")) {
					var checks = obj.find("input[type=checkbox][name=" + field + "][checked]");
					$.each(checks, function(i) {
						if (i == 0) {
							value = $(this).val();
						} else {
							value += "," + $(this).val();
						}
					});
				} else if ($(element).is("input[type=radio]")) {
					var checks = obj.find("input[type=radio][name=" + field + "][checked]");
					$.each(checks, function(i) {
						if (i == 0) {
							value = $(this).val();
						} else {
							value += "," + $(this).val();
						}
					});
				} else if ($(element).is("select")) {
					value = $(element).val();
				} else if ($(element).is("textarea")) {
					value = $(element).val();
				} else if ($(element).is("file")) {
					value = $(element).val();
				}
				return value;
			}
		});
})(jQuery);