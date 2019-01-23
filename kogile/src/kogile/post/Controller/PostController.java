package kogile.post.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kogile.post.Service.Action;
import kogile.post.Service.ActionForward;
import kogile.post.Service.DeleteDdateAction;
import kogile.post.Service.DeleteLabelAction;
import kogile.post.Service.DeleteLabelInfoAction;
import kogile.post.Service.DeletePostAction;
import kogile.post.Service.DescriptionDeleteAction;
import kogile.post.Service.DescriptionInsertAction;
import kogile.post.Service.DescriptionInsertActionForm;
import kogile.post.Service.DescriptionListAction;
import kogile.post.Service.DescriptionUpdateAction;
import kogile.post.Service.DescriptionUpdateActionForm;
import kogile.post.Service.DescriptionlistAjax;
import kogile.post.Service.DetailPostAction;
import kogile.post.Service.InsertLabelAction;
import kogile.post.Service.InsertLabelFormAction;
import kogile.post.Service.InsertPostAction;
import kogile.post.Service.InsertPostFormAction;
import kogile.post.Service.ListLabelAction;
import kogile.post.Service.ListPostAction;
import kogile.post.Service.PostDetailViewAction;
import kogile.post.Service.ReplyDeleteAction;
import kogile.post.Service.ReplyInsertAction;
import kogile.post.Service.ReplyInsertAjax;
import kogile.post.Service.ReplyUpdateAction;
import kogile.post.Service.ReplyUpdateActionForm;
import kogile.post.Service.ReplyUpdateAjax;
import kogile.post.Service.ReplyUpdateFormAjax;
import kogile.post.Service.UpdateDdateAction;
import kogile.post.Service.UpdateDdateFormAction;
import kogile.post.Service.UpdateLabelAction;
import kogile.post.Service.UpdatePostAction;
import kogile.post.Service.UpdatePostDragAction;
import kogile.post.Service.UpdatePostFormAction;
import kogile.post.Service.insertDescriptionAjax;
import kogile.post.Service.updateLabelFormAction;

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
		
		System.out.println(command);
		
		HttpSession session = request.getSession();
		
		if(request.getParameter("pjt_no") != null) {
			session.removeAttribute("pjt_no");
			session.setAttribute("pjt_no", Integer.parseInt(request.getParameter("pjt_no")));
			System.out.println("session pjt_no=" + session.getAttribute("pjt_no"));
		}
		
		if(request.getParameter("p_no") != null) {
			session.removeAttribute("p_no");
			session.setAttribute("p_no", Integer.parseInt(request.getParameter("p_no")));
			System.out.println("session p_no =" + session.getAttribute("p_no"));
		}
		
		
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
			action = new UpdatePostFormAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
		// updatePostAction (Post 수정)
		} else if (command.equals("updatePostAction.do")) {
			action = new UpdatePostAction();
			try {
				forward = action.excute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		// deletePostAction (Post 삭제)
		} else if (command.equals("deletePostAction.do")) {
			action = new DeletePostAction();

			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		// updateDdateAction (디데이 수정)
		} else if (command.equals("updateDdateAction.do")) {
			action = new UpdateDdateAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		// updatePostFormAction (Post 수정 Form으로 이동)
		} else if (command.equals("updateDdateFormAction.do")) {
			action = new UpdateDdateFormAction();
		
		try {
			forward = action.excute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// deleteDdateAction (마감일 삭제)
		} else if (command.equals("deleteDdateAction.do")) {
			action = new DeleteDdateAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		// 라벨 생성 (project 단위)
		}else if(command.equals("insertlabel.do")) {
			action = new InsertLabelAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		// 라벨 제거 (project 단위)
		}else if(command.equals("deleteLabel.do")) {
			action = new DeleteLabelAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("insertLabelForm.do")) {
			action = new InsertLabelFormAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//라벨 수정 (project 단위)
		}else if(command.equals("updateLabelForm.do")) {
			action = new updateLabelFormAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("updateLabel.do")) {
			action = new UpdateLabelAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("doDetailView.do")) {
			action = new PostDetailViewAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("deleteLabelInfo.do")) {
			action = new DeleteLabelInfoAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("labellist.do")) {
			action = new ListLabelAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("insertDescriptionForm.do")) {
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
		}else if (command.equals("updatePostDragAction.do")) {
			action = new UpdatePostDragAction();
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
