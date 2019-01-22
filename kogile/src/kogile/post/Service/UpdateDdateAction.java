package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Service.PostService;

public class UpdateDdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		PostService service = PostService.getInstance();
		
		service.updateDdateActionService(request, response);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("detailPostAction.do");
		forward.setRedirect(true);
		return forward;
	}

}
