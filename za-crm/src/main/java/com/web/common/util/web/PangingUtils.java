package com.web.common.util.web ;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class PangingUtils {
  
	public static PagingObject getPagingObjectFormRequest(HttpServletRequest request)
	{
		PagingObject pagingObject = new PagingObject();
		String  page = request.getParameter("page");
		String  rows = request.getParameter("rows");
		String  sort = request.getParameter("sort");
		String  order  = request.getParameter("order");
		
		pagingObject.setCurrent_page(StringUtils.isEmpty(page)?1:Integer.parseInt(page));
		pagingObject.setPage_size(StringUtils.isEmpty(rows)?10:Integer.parseInt(rows));
		pagingObject.setSort_name(sort);
		pagingObject.setSort_order(StringUtils.isEmpty(order)?"asc":order);
		return pagingObject;
	}
}
