package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Service.PostService;

public class InsertPostFormAction implements Action {

	// insertPostForm으로 가는 Action
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		PostService service = PostService.getInstance();
		
		// MemberList에 프로젝트에 포함된 인원 담기
//		request.setAttribute("MemberList", service.listMemberService(request, response));
		service.listMemberService(request, response);
		// CardInfo에 카드 정보 담기
//		request.setAttribute("CardInfo", service.cardInfoService(request, response));
//		service.cardInfoService(request, response);
		// 경로 및 다이렉트 방식 선언
//		ActionForward forward = new ActionForward();
		
		// insertPostForm(Post를 입력하는 jsp)으로 이동
//		forward.setPath("insertPostForm.jsp");
		
		// 데이터 없이 이동한다 -> sendRedirect
//		forward.setRedirect(false);
		
		// 해당 forward 리턴하여 이동
		return null;
	}

}
