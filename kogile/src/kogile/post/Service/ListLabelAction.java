package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListLabelAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostService service = PostService.getInstance();
		service.listlabel(request, response);
		
//		ActionForward forward = new ActionForward();
//		forward.setPath("listLabel.jsp");
//		forward.setRedirect(false);
		return null;
	}

}
