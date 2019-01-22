package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteLabelAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostService service = PostService.getInstance();
		service.deleteLabelService(request, response);
		
		ActionForward forward = new ActionForward();
		forward.setPath("labellist.do");
		forward.setRedirect(false);
		return forward;
	}

}