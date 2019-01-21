package kogile.post.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostService;

public class UpdatePostFormAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		// 서비스 객체 생성
		PostService service = PostService.getInstance();
		
		// PostDTO에 수정된 Post 메소드를 set
		request.setAttribute("PostDTO", service.updatePostFormActionService(request));
		
		// Dispatcher
		ActionForward forward = new ActionForward();
		forward.setPath("updatePostForm.jsp");
		forward.setRedirect(false);
		return forward;
	}

}