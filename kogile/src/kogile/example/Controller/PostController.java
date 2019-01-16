package kogile.example.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.example.Service.Action;
import kogile.example.Service.ActionForward;
import kogile.example.Service.DescriptionDeleteAction;
import kogile.example.Service.DescriptionInsertAction;
import kogile.example.Service.DescriptionInsertActionForm;
import kogile.example.Service.DescriptionListAction;
import kogile.example.Service.DescriptionUpdateAction;
import kogile.example.Service.DescriptionUpdateActionForm;
import kogile.example.Service.ReplyDeleteAction;
import kogile.example.Service.ReplyInsertAction;
import kogile.example.Service.ReplyUpdateAction;
import kogile.example.Service.ReplyUpdateActionForm;



@WebServlet("*.do")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// /kogile/*.do 
		String requestUri= request.getRequestURI();
		// /kogile
		String contextPath= request.getContextPath();
		// *.do만 나오게 짤라
		String command=requestUri.substring(contextPath.length()+6);
		Action action=null;
		ActionForward forward = null;

		if(command.equals("insertDescriptionForm.do")) {
			action = new DescriptionInsertActionForm();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("insertDescription.do")) {
			action = new DescriptionInsertAction();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("descriptionlist.do")) {
			action = new DescriptionListAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("descriptionDelete.do")) {
			action = new DescriptionDeleteAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("descriptionUpdate.do")) {
			action = new DescriptionUpdateActionForm();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("descriptionUpdateForm.do")) {
			action = new DescriptionUpdateAction();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("insertReply.do")) {
			action = new ReplyInsertAction();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("replyDelete.do")) {
			action = new ReplyDeleteAction();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("replyUpdate.do")) {
			action = new ReplyUpdateActionForm();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("replyUpdateForm.do")) {
			action= new ReplyUpdateAction();
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
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
