package kogile.post.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.post.Service.Action;
import kogile.post.Service.ActionForward;
import kogile.post.Service.DescriptionDeleteAction;
import kogile.post.Service.DescriptionInsertAction;
import kogile.post.Service.DescriptionInsertActionForm;
import kogile.post.Service.DescriptionListAction;
import kogile.post.Service.DescriptionUpdateAction;
import kogile.post.Service.DescriptionUpdateActionForm;
import kogile.post.Service.DescriptionlistAjax;
import kogile.post.Service.ReplyDeleteAction;
import kogile.post.Service.ReplyInsertAction;
import kogile.post.Service.ReplyInsertAjax;
import kogile.post.Service.ReplyUpdateAction;
import kogile.post.Service.ReplyUpdateActionForm;
import kogile.post.Service.ReplyUpdateAjax;
import kogile.post.Service.ReplyUpdateFormAjax;
import kogile.post.Service.insertDescriptionAjax;



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
		System.out.println(command);
		Action action=null;
		ActionForward forward = null;
		
		//설명 글쓰는 폼으로 보내기
		if(command.equals("insertDescriptionForm.do")) {
			action = new DescriptionInsertActionForm();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//설명 글쓰기
		}else if(command.equals("insertDescription.do")) {
			action = new DescriptionInsertAction();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//내부페이지 설명,댓글,태그창 보여주기
		}else if(command.equals("descriptionlist.do")) {
			action = new DescriptionListAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//설명 삭제
		}else if(command.equals("descriptionDelete.do")) {
			action = new DescriptionDeleteAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//설명 수정 작성 폼으로 가기
		}else if(command.equals("descriptionUpdate.do")) {
			action = new DescriptionUpdateActionForm();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//설명 수정
		}else if(command.equals("descriptionUpdateForm.do")) {
			action = new DescriptionUpdateAction();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//댓글 작성
		}else if(command.equals("insertReply.do")) {
			action = new ReplyInsertAction();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//댓글 삭제
		}else if(command.equals("replyDelete.do")) {
			action = new ReplyDeleteAction();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//댓글 수정 폼으로 보내기
		}else if(command.equals("replyUpdate.do")) {
			action = new ReplyUpdateActionForm();
			try {
				forward=action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//댓글 수정
		}else if(command.equals("replyUpdateForm.do")) {
			action= new ReplyUpdateAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("descriptionlistAjax.do")) {
			action= new DescriptionlistAjax();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("insertReplyAjax.do")) {
			action= new ReplyInsertAjax();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("UpdateReplyFormAjax.do")) {
			action= new ReplyUpdateFormAjax();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("UpdateReplyAjax.do")) {
			action= new ReplyUpdateAjax();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("insertDescriptionAjax.do")) {
			action= new insertDescriptionAjax();
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
