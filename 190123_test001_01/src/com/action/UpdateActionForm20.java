package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CheckListDao;
import com.dao.ListDao;
import com.service.Board;
import com.service.ListBoard;
import com.service.ListService;

public class UpdateActionForm20 implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ListService serviceUpdate = ListService.getInstance();
		serviceUpdate.updateBoard(request);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); 
		forward.setPath("update_form20.jsp");
		return forward;
	}

}
