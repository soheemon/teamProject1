package kogile.post.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;

import kogile.post.Action.Action;
import kogile.post.Action.ActionForward;
import kogile.post.Action.DetailPostAction;
import kogile.post.Action.InsertPostAction;
import kogile.post.Action.InsertPostFormAction;
import kogile.post.Action.ListPostAction;
import kogile.post.Action.deletePostAction;
import kogile.post.Action.updatePostAction;
import kogile.post.Action.updatePostFormAction;


@WebServlet("*.do")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PostController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI().substring(request.getContextPath().length() + 6);
		
		Action action = null;
		ActionForward forward = null;
		
		
		// insertPostFormActon (Post를 생성하는 Form으로 이동)
		if (command.equals("insertPostFormAction.do")) {
			action = new InsertPostFormAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			
		// insertPostAction (Post 생성)
		} else if (command.equals("insertPostAction.do")) {
			action = new InsertPostAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		// listPostAction (Post 리스트 보기)
		} else if (command.equals("listPostAction.do")) {
			action = new ListPostAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		// detailPostAction (Post 내용 이동)
		} else if (command.equals("detailPostAction.do")) {
			action = new DetailPostAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		// updatePostFormAction (Post 수정 Form으로 이동)
		} else if (command.equals("updatePostFormAction.do")) {
			action = new updatePostFormAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
		// updatePostAction (Post 수정)
		} else if (command.equals("updatePostAction.do")) {
			action = new updatePostAction();
			System.out.println("1");
			try {
				System.out.println("2");
				forward = action.excute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		// deletePostAction (Post 삭제)
		} else if (command.equals("deletePostAction.do")) {
			action = new deletePostAction();

			
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
