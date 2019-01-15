package kogile.checklist.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.checklist.action.Action;
import kogile.checklist.action.ActionForward;
import kogile.checklist.action.InsertAction;
import kogile.checklist.action.InsertActionForm;


@WebServlet("*.do")
public class CheckListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insertForm.do, insertAction.do, list.do, detail.do
		String requestURI = request.getRequestURI();
		System.out.println("requestURI :" + requestURI);
//		http://localhost:8082/git_SourceTree01/list.do
		// mvc/insert.do
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath: " + contextPath);
		String command = request.getRequestURI().substring(request.getContextPath().length()+1);
		System.out.println("command :" + command);
		
		Action action = null;
		ActionForward forward =null;
		
			if(command.equals("insertcheck.do")) {
				action = new InsertActionForm();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
				e.printStackTrace();
				}
			}else if(command.equals("insertAction.do")) {
				action = new InsertAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
