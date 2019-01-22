package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertLabelAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostService service = PostService.getInstance();
		service.insertLabelService(request, response);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("labellist.post");
		forward.setRedirect(false);
		return forward;
	}

}
