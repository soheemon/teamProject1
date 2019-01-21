package kogile.post.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostService;

public class UpdateDdateFormAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 서비스 객체 생성
		PostService service = PostService.getInstance();
		
		// 수정 메소드를 DdateDTO에 담는다.
		request.setAttribute("DdateDTO", service.updateDdateFormActionService(request));
		
		// Dispatcher
		ActionForward forward = new ActionForward();
		forward.setPath("updateDdateForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
