package kogile.post.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostService;

public class DeleteDdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		// 서비스 객체 생성
		PostService service = PostService.getInstance();
		
		// 마감일 삭제 메소드
		service.deleteDdateActionService(request);
		
		// Redirect
		ActionForward forward = new ActionForward();
		forward.setPath("detailPostAction.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
