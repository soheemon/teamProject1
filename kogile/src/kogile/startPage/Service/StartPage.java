package kogile.startPage.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.startPage.DTO.ProjectBoard;

public class StartPage implements Action {


	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProjectService service = ProjectService.getInstance();
		List<ProjectBoard> list=service.listProjectService(request);

		request.setAttribute("List", list);
		
		ActionForward forward =new ActionForward();
		forward.setPath("startPage.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
