package kogile.post.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostService;

public class DetailPostAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 서비스 객체 생성
		PostService service = PostService.getInstance();
		
		// 세부내용 메소드를 PostDTO에 담는다.
		request.setAttribute("PostDTO", service.detailPostActionService(request));
		
		// 담당자 명단을 PostMemberList에 담는다.
		request.setAttribute("PostMemberList", service.PostMemberListService(request, response));
		
		// Dispatcher
		ActionForward forward = new ActionForward();
		forward.setPath("detailPostForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
