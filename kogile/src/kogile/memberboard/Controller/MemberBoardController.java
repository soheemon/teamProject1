package kogile.memberboard.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;

import kogile.memberboard.Service.Action;
import kogile.memberboard.Service.ActionForward;
import kogile.memberboard.Service.InsertMemberBoardAction;
import kogile.memberboard.Service.MemberBoardAction;


@WebServlet("*.me")
public class MemberBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberBoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI(); // URI를 요청한 값
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length()+6);
		
		Action action = null;
		ActionForward forward = null;
		
		
		if (command.equals("memberBoardAction.me")) {
			action = new MemberBoardAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("insertMemberBoardAction.me")){
			action = new InsertMemberBoardAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) {
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
