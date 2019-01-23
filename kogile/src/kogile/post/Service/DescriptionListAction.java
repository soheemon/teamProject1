package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DescriptionListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//서비스 객체생성
		PostService service = PostService.getInstance();
		System.out.println("test");
		//포스트 내부페이지 보여주는 서비스 호출
		service.descriptionDetailService(request, response);	
		//댓글목록 보여주는 서비스 호출
		service.replyMemberListService(request);
		//태그할 맴버 보여주는 서비스 호출
		service.tagMemberListService(request);
		
//		ActionForward forward = new ActionForward();
//		forward.setRedirect(false);
//		forward.setPath("descriptionlist.jsp");
		return null;
	}

}
