package kogile.post.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostService;

public class DetailPostAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		PostService service = PostService.getInstance();
		
		// 가져온 PostDTO를 담는다.
		request.setAttribute("PostDTO", service.detailPostActionService(request));
		
		ActionForward forward = new ActionForward();
		forward.setPath("detailPostForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
