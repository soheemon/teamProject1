package kogile.post.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;

import kogile.example.Service.Action;
import kogile.example.Service.ActionForward;
import kogile.post.Service.DeleteLabelAction;
import kogile.post.Service.DeleteLabelInfoAction;
import kogile.post.Service.InsertLabelAction;
import kogile.post.Service.InsertLabelFormAction;
import kogile.post.Service.ListLabelAction;
import kogile.post.Service.PostDetailViewAction;
import kogile.post.Service.UpdateLabelAction;
import kogile.post.Service.updateLabelFormAction;


@WebServlet("*.post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PostController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String command = request.getRequestURI().substring(request.getContextPath().length()+6);
		System.out.println(command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command != null) {
			if(command.equals("labellist.post")) {
				action = new ListLabelAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("insertlabel.post")) {
				action = new InsertLabelAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("deleteLabel.post")) {
				action = new DeleteLabelAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("insertLabelForm.post")) {
				action = new InsertLabelFormAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else if(command.equals("updateLabelForm.post")) {
				action = new updateLabelFormAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("updateLabel.post")) {
				action = new UpdateLabelAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("postDetailView.post")) {
				action = new PostDetailViewAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("deleteLabelInfo.post")) {
				action = new DeleteLabelInfoAction();
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
