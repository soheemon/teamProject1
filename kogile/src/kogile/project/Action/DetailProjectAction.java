package kogile.project.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.project.Action.Action;
import kogile.project.Action.ActionForward;
import kogile.project.DAO.ProjectService;
import kogile.project.DTO.ProjectDTO;

public class DetailProjectAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProjectService ps= ProjectService.getInstance();
		ProjectDTO pb =ps.detailProjectService(request);
	
		request.setAttribute("project", pb);

		ActionForward forward = new ActionForward();
		forward.setPath("detailProject.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
