package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyUpdateActionForm implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//서비스 객체생성
		PostService service = PostService.getInstance();
		//댓글 수정하는 폼으로 이동하는 서비스
		service.replyUpdateFormService(request);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("updateReply.jsp");
		return forward;
	}

}
