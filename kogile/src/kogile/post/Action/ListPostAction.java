package kogile.post.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostService;

public class ListPostAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		PostService service = PostService.getInstance();
		
		// service에서 생성한 메소드를 list에 담는다.
		request.setAttribute("list", service.listPostActionService(request, response));
			
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("listPostForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
