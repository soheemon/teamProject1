package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CheckListDao;
import com.service.Board;

public class DetailAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		CheckListDao dao = CheckListDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
		String str = request.getParameter("checklist_no");
		int checklist_no = 0;
		if(str != null){
			checklist_no = Integer.parseInt(str);
		}
		
		Board board = dao.detailBoard(checklist_no);
		request.setAttribute("board", board);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("detail.jsp");

		return forward;
	}

	
}
