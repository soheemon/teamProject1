package kogile.post.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertLabelFormAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int p_no = Integer.parseInt(request.getParameter("p_no"));
		
		request.setAttribute("p_no", p_no);
		
		ActionForward forward = new ActionForward();
		forward.setPath("insertLabel.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
