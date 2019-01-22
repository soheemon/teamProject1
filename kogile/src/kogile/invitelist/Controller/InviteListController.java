package kogile.invitelist.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.invitelist.Service.InviteListAction;
import kogile.invitelist.Service.Action;
import kogile.invitelist.Service.ActionForward;
import kogile.invitelist.Service.DeleteInviteListAction;

@WebServlet("*.in")
public class InviteListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InviteListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+6);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("inviteListAction.in")){
			action = new InviteListAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("deleteInviteListAction.in")){
			action = new DeleteInviteListAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
