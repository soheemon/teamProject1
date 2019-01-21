package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DescriptionInsertAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//서비스 객체생성
		PostService service = PostService.getInstance();
		//설명 작성서비스 호출
		service.insertDescriptionService(request);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("descriptionlist.do");
		return forward;
	}

}
