package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Service.PostService;

public class UpdateDdateFormAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		PostService service = PostService.getInstance();
		
		request.setAttribute("DdateDTO", service.updateDdateFormActionService(request));
		
		ActionForward forward = new ActionForward();
		forward.setPath("updateDdateForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
