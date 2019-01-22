package kogile.project.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Model.PostDTO;
import kogile.post.Model.PostService;
import kogile.project.DAO.ProjectService;
import kogile.project.Model.ProjectDTO;
import kogile.project.Service.Action;
import kogile.project.Service.ActionForward;

public class DetailProjectAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProjectService ps= ProjectService.getInstance();
		ProjectDTO pb =ps.detailProjectService(request);
		
		PostService postService = PostService.getInstance();
		postService.listPostActionService(request, response);
		
		request.setAttribute("project", pb);

		ActionForward forward = new ActionForward();
		forward.setPath("detailProject.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
