package kogile.post.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostService;

public class InsertPostFormAction implements Action {

	// insertPostForm으로 가는 Action
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		// 서비스 객체 생성
		PostService service = PostService.getInstance();
		
		// MemberList에 프로젝트에 포함된 인원 담기
		request.setAttribute("MemberList", service.listMemberService(request, response));
		
		// CardInfo에 카드 정보 담기
		request.setAttribute("CardInfo", service.cardInfoService(request, response));
		
		// 경로 및 다이렉트 방식 선언
		ActionForward forward = new ActionForward();
		
		// Dispatcher
		forward.setPath("insertPostForm.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
