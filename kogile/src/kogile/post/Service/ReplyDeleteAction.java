package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyDeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//서비스 객체생성
		PostService service = PostService.getInstance();
		//댓글 삭제 서비스 호출
		service.deleteReplyService(request);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("descriptionlist.do");
		return forward;
	}

}
