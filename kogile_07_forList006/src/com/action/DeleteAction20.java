package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.ListDao;
import com.service.Board;

public class DeleteAction20 implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ListDao dao = ListDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
		Board board = new Board();
		board.setList_no(Integer.parseInt(request.getParameter("list_no")));
		dao.deleteBoard20(board);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("detail.do");
		
		return forward;
	}

}
