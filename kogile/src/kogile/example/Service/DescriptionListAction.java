package kogile.example.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.Module.Description;
import kogile.Module.Reply;

public class DescriptionListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostService service = PostService.getInstance();
		service.descriptionDetailService(request);
		service.replyListService(request);	
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("descriptionlist.jsp");
		return forward;
	}

}
