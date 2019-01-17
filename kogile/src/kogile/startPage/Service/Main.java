package kogile.startPage.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.startPage.DTO.ProjectBoard;
import kogile.startPage.Service.Action;
import kogile.startPage.Service.ActionForward;

public class Main implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProjectService ps= ProjectService.getInstance();
		ProjectBoard pb =ps.mainDetailService(request);
		
		request.setAttribute("pb", pb);
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
