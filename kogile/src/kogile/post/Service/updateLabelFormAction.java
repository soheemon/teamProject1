package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateLabelFormAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostService service = PostService.getInstance();
		request.setAttribute("before", service.updateLabelFormService(request, response));
		request.setAttribute("p_no", request.getParameter("p_no"));
		
		ActionForward forward = new ActionForward();
		forward.setPath("updateLabelForm.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
