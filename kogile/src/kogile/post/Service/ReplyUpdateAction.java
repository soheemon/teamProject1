package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyUpdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//서비스 객체생성
		PostService service = PostService.getInstance();
		//댓글 수정 서비스
		service.updateReplyService(request);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("descriptionlist.do");
		return forward;
	}

}
