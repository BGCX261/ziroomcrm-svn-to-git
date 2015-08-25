/**
 * 首页
 * 
 * @param currentPage
 * @param id
 */
function first(currentPage, id, page, action) {
	if(action) {
		$("#" + id).attr("action", action);
	}
	$("#"+page).val(1);
	$("#"+id).submit();
}

/**
 * 上一页
 * 
 * @param currentPage
 * @param id
 */
function previousPage(currentPage, id, page, action) {
	if(currentPage == 1) {
		$("#"+page).val(1);
	} else {
		$("#"+page).val(currentPage - 1);
	}
	if(action) {
		$("#" + id).attr("action", action);
	}
	$("#"+id).submit();
}

/**
 * 下一页
 * 
 * @param currentPage
 * @param id
 */
function nextPage(currentPage, id, page, totalPage, action) {
	if(currentPage == totalPage) {
		$("#"+page).val(totalPage);
	} else {
		$("#"+page).val(currentPage + 1);
	}
	if(action) {
		$("#" + id).attr("action", action);
	}
	$("#"+id).submit();
}

/**
 * 尾页
 * 
 * @param currentPage
 * @param id
 */
function last(currentPage, id, page, action) {
	if(action) {
		$("#" + id).attr("action", action);
	}
	$("#"+page).val(currentPage);
	$("#"+id).submit();
}

/**
 * 
 * @param action
 * @param valId
 * @param val
 * @param formId
 */
function executeMethod(action, valId, val, formId) {
	
	$("#" + formId).attr("action", action);
	$("#" + valId).val(val);
	$("#" + formId).submit();
	$("#" + formId).attr("action", '');
	$("#" + valId).val('');
}