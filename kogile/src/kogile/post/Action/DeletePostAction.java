package kogile.post.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostService;

public class DeletePostAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 서비스 객체 생성
		PostService service = PostService.getInstance();
		
		// Post 삭제 메소드
		service.deletePostActionService(request);		
		
		// Redirect
		ActionForward forward = new ActionForward();
		forward.setPath("listPostAction.do");
		forward.setRedirect(true);
		
		
		return forward;
	}

}
