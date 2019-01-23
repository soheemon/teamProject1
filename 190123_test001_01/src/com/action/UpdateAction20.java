package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.ListDao;
import com.service.ListBoard;

public class UpdateAction20 implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ListDao dao = ListDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
		ListBoard listboard = new ListBoard();
		listboard.setList_no(Integer.parseInt(request.getParameter("list_no")));
		System.out.println("listUpdateActionListno:  " + listboard.getList_no());
		listboard.setList_info(request.getParameter("list_info"));
		
		dao.updateBoard20(listboard);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("list20.do");
		
		return forward;
	}

}
