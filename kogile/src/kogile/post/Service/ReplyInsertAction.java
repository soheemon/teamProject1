package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyInsertAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//서비스 객체생성
		PostService service = PostService.getInstance();
		//댓글작성 서비스 호출
		service.insertReplyService(request);
		//태그 작성 서비스 호출
		service.insertTagService(request);
		//알림 보내는 서비스 호출
		service.insertTagNoticeService(request);
		
//		ActionForward forward =new ActionForward();
//		forward.setRedirect(true);
//		forward.setPath("descriptionlist.do");
		return null;
	}

}
