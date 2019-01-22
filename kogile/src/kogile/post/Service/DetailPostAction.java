package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Service.PostService;

public class DetailPostAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("utf-8");
		
		PostService service = PostService.getInstance();
		
//		// 가져온 PostDTO를 담는다.
//		request.setAttribute("PostDTO", service.detailPostActionService(request));
//		
//		request.setAttribute("PostMemberList", service.PostMemberListService(request, response));
//		
		service.detailPostActionService(request, response);
//		service.PostMemberListService(request, response);
		
		
//		ActionForward forward = new ActionForward();
//		forward.setPath("detailPostPop.jsp");
//		forward.setRedirect(false);
		
		return null;
	}

}
