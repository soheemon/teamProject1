package kogile.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.smartcardio.CommandAPDU;

import org.apache.ibatis.io.Resources;

import kogile.project.Action.Action;
import kogile.project.Action.ActionForward;
import kogile.project.Action.DetailProjectAction;
import kogile.project.Action.InsertProjectAction;
import kogile.project.Action.InsertProjectFormAction;
import kogile.project.Action.ListProjectAction;



@WebServlet("*.do")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProjectController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		if(request.getParameter("pjt_no") != null) {
			int pjt_no = Integer.parseInt(request.getParameter("pjt_no"));
			session.removeAttribute("pjt_no");
			session.setAttribute("pjt_no", pjt_no);
		}
		
		
		String command = request.getRequestURI().substring(request.getContextPath().length()+1);
		
		Action action = null;
		ActionForward forward = null;
		System.out.println(command);
		
		if(command != null) {
			if(command.equals("*.do")) {
//				Action action = *Action();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("insertProject.do")) {
				action = new InsertProjectAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}else if(command.equals("insertProjectFormAction.do")) {
				action = new InsertProjectFormAction(); 
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("listProject.do")) {
				action = new ListProjectAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("detailProject.do")) {
				action = new DetailProjectAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
