package kogile.project.Service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.project.DAO.ProjectService;

public class InsertProjectFormAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProjectService service = ProjectService.getInstance();
		service.insertProjectService(request, response);
		
//		ActionForward forward = new ActionForward();
//		forward.setPath("listProject.pjt");
//		forward.setRedirect(true);
		return null;
	}

}
