package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CheckListService;
import com.service.ListModel;
import com.service.ListService;

public class ListAction20 implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ListService service = ListService.getInstance();
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum ="1";
		}
		int requestPage = Integer.parseInt(pageNum);
		ListModel listModel = service.listBoardService20(requestPage, request);
		request.setAttribute("listModel", listModel);
		

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("list20.jsp");

		return forward;
	}

}
