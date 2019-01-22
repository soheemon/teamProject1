package kogile.memberboard.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertMemberBoardAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setCharacterEncoding("utf-8");
		
		MemberBoardService service = MemberBoardService.getInstance();
		service.insertMemberBoardService(request);
		//service.inviteListService(request);
		service.insertNoticeService(request);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("inviteSearch.jsp");
		
		return forward;
	}

}
