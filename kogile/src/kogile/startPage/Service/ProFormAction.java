package kogile.startPage.Service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProFormAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProjectService service = ProjectService.getInstance();
		service.insertProjectService(request);
		
		ActionForward forward = new ActionForward();
		forward.setPath("startPage.do");
		forward.setRedirect(true);
		return forward;
	}

}
