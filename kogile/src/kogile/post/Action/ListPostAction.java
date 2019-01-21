package kogile.post.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostService;

public class ListPostAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 서비스 객체 생성
		PostService service = PostService.getInstance();
		
		// list 출력하는 메소드를 list에 담는다.
		request.setAttribute("list", service.listPostActionService(request, response));
			
		// Dispatcher
		ActionForward forward = new ActionForward();
		forward.setPath("listPostForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
