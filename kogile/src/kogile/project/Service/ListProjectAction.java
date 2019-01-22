package kogile.project.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.project.DAO.ProjectService;
import kogile.project.Model.ProjectDTO;

public class ListProjectAction implements Action {


	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProjectService service = ProjectService.getInstance();
		List<ProjectDTO> list=service.listProjectService(request, response);
		request.setAttribute("List", list);
		
		
		ActionForward forward =new ActionForward();
		forward.setPath("listProject.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
