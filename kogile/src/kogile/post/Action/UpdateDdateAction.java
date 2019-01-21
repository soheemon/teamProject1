package kogile.post.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostService;

public class UpdateDdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 서비스 객체 생성
		PostService service = PostService.getInstance();
		
		// 마감일 수정하는 메소드 출력
		service.updateDdateActionService(request, response);
		
		// Redirect
		ActionForward forward = new ActionForward();
		forward.setPath("detailPostAction.do");
		forward.setRedirect(true);
		return forward;
	}

}
