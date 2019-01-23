package kogile.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kogile.project.Service.Action;
import kogile.project.Service.ActionForward;
import kogile.project.Service.DetailProjectAction;
import kogile.project.Service.InsertProjectAction;
import kogile.project.Service.InsertProjectFormAction;
import kogile.project.Service.ListProjectAction;



@WebServlet("*.pjt")
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
			System.out.println("session p_no =" + session.getAttribute("pjt_no"));
		}
		if(request.getParameter("p_no") != null) {
			session.removeAttribute("p_no");
			session.setAttribute("p_no", Integer.parseInt(request.getParameter("p_no")));
			System.out.println("session p_no =" + session.getAttribute("p_no"));
		}
		
		
		String command = request.getRequestURI().substring(request.getContextPath().length()+6);
		System.out.println("pjt" + command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command != null) {
			if(command.equals("insertProject.pjt")) {
				action = new InsertProjectAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}else if(command.equals("insertProjectFormAction.pjt")) {
				action = new InsertProjectFormAction(); 
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("listProject.pjt")) {
				action = new ListProjectAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("detailProject.pjt")) {
				action = new DetailProjectAction();
				System.out.println(123);
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
