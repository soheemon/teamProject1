package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateLabelAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostService service = PostService.getInstance();
		service.updateLabelService(request, response);
		request.setAttribute("p_no", Integer.parseInt(request.getParameter("p_no")));
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("labellist.post");
		forward.setRedirect(false);
		return forward;
	}

}
