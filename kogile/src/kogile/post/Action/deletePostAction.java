package kogile.post.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostService;

public class deletePostAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		PostService service = PostService.getInstance();
		
		service.deletePostActionService(request);		
		
		ActionForward forward = new ActionForward();
		forward.setPath("listPostAction.do");
		forward.setRedirect(true);
		
		
		return forward;
	}

}
