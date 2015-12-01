function loadPaging(page_no) {
		page_no ="";
}

/**
 * Next pagination
 */
function pageNext(page_no,totalPage) {
	page_no++;
	totalPage = value.PAGING.totalPage;
	if (page_no > totalPage) {
		page_no = totalPage

	}
}

/**
 * Previouse pagination
 */
function pagePrevious(page_no,totalPage) {
	page_no--;
	totalPage = value.PAGING.totalPage;
	if (page_no < 1) {
		page_no = 1

	}
}
/**
 * Show pagination
 * 
 * @param totalPage
 * @param curPage
 */

function showPaging(totalPage, curPage) {

	if (totalPage > 1) {
		$("#paging")
				.append(
						'<li id="p_pre" class="next"><a href="#none"><span class="glyphicon glyphicon-chevron-left"></span></a></li>');
		for (var i = 1; i <= totalPage; i++) {
			if (i == curPage)
				$("#paging").append(
						'<li class="active"  name="p_index"><a href="#none">'
								+ i + '</a></li>');

			else
				$("#paging").append(
						'<li  name="p_index"><a href="#none">' + i
								+ '</a></li>');

		}
		$("#paging")
				.append(
						'<li id="p_next" class="next"><a href="#none"><span class="glyphicon glyphicon-chevron-right"></span></a></li>');
	}
}