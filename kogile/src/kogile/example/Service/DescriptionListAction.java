package kogile.example.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.Module.DescriptionDTO;
import kogile.Module.ReplyDTO;

public class DescriptionListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//서비스 객체생성
		PostService service = PostService.getInstance();
		//포스트 내부페이지 보여주는 서비스 호출
		service.descriptionDetailService(request);	
		//댓글목록 보여주는 서비스 호출
		service.replyMemberListService(request);
		//태그할 맴버 보여주는 서비스 호출
		service.tagMemberListService(request);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("descriptionlist.jsp");
		return forward;
	}

}
