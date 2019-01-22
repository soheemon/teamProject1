package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Service.PostService;

public class DeleteDdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		PostService service = PostService.getInstance();
		
		service.deleteDdateActionService(request);
		
		ActionForward forward = new ActionForward();
		forward.setPath("detailPostAction.do");
		forward.setRedirect(false);
		
		return forward;
	}

}
