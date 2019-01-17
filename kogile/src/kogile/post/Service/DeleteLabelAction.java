package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.example.Service.Action;
import kogile.example.Service.ActionForward;

public class DeleteLabelAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostService service = PostService.getInstance();
		service.deleteLabelService(request, response);
		
		ActionForward forward = new ActionForward();
		forward.setPath("labellist.post");
		forward.setRedirect(false);
		return forward;
	}

}
