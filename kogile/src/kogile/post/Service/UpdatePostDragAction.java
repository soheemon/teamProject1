package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePostDragAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setCharacterEncoding("UTF-8");
		
		PostService service = PostService.getInstance();
		
		service.PostDragService(request, response);
		
//		ActionForward forward = new ActionForward();
//		forward.setPath("updatePostDragAction.do");
//		forward.setRedirect(true);
		return null;
	}
}
