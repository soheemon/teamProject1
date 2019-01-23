package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.ListDao;
import com.service.Board;
import com.service.ListBoard;

public class DeleteAction20 implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ListDao dao = ListDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
		ListBoard listboard = new ListBoard();
		listboard.setList_no(Integer.parseInt(request.getParameter("list_no")));
		dao.deleteBoard20(listboard);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("detail20.do");
		
		return forward;
	}

}
