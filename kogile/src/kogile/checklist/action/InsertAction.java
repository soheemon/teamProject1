package kogile.checklist.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.checklist.Service.CheckListService;

public class InsertAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CheckListService service = CheckListService.getInstance();
		
		service.insertCheckBoardService(request);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("list.do");
		
		return forward;
	}

/*	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CheckListService service = CheckListService.getInstance();
		
		service.insertCheckBoardService(request);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("list.do");
		
		return forward;
	}*/

}
