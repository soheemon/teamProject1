package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Service.PostService;

public class InsertPostAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		// 서비스 객체 호출
		PostService service = PostService.getInstance();
		
		// 서비스가 선언한 Action 메소드 호출
		service.insertPostActionService(request, response);
		
		// insert후 담당자들 넣기
//		ActionForward forward = new ActionForward();
//		forward.setPath("listPostAction.do");
//		forward.setRedirect(false);
		
		return null;
	}

}
