package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Service.PostService;

public class UpdatePostAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		request.setCharacterEncoding("UTF-8");
		
		PostService service = PostService.getInstance();
		
		service.updatePostActionService(request);
		
		ActionForward forward = new ActionForward();
		forward.setPath("listPostAction.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
