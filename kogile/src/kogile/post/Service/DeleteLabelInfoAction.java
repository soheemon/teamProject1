package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteLabelInfoAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostService service = PostService.getInstance();
		service.deleteLabelInfoService(request, response);
		int p_no = Integer.parseInt(request.getParameter("p_no"));
		
		ActionForward forward = new ActionForward();
		forward.setPath("postDetailView.post?p_no="+p_no);
		forward.setRedirect(true);
		return forward;
	}

}
