package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PostDetailViewAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostService service = PostService.getInstance();
		
		request.setAttribute("label", service.postDetailViewService(request, response));
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("postDetailVIewExample.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
