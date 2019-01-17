package kogile.post.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostService;

public class updatePostFormAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		PostService service = PostService.getInstance();
		
		// PostDTO에 detail을 담은 것을 저장한다.
		request.setAttribute("PostDTO", service.updatePostFormActionService(request));
		
		// updateForm으로 수정할 값을 가지고 이동
		ActionForward forward = new ActionForward();
		forward.setPath("updatePostForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}