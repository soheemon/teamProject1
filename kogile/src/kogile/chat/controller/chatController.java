package kogile.chat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;


import kogile.chat.Service.Action;
import kogile.chat.Service.ActionForward;
import kogile.chat.Service.ChatAction;
import kogile.chat.Service.ChatInsertAction;
import kogile.chat.Service.ChatListAction;


@WebServlet("*.chat")
public class chatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public chatController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI().substring(request.getContextPath().length()+6);
		
		
		Action action = null;
		ActionForward forward = null;
		
		if(command != null) {
			if(command.equals("chatInsert.chat")) {
				action = new ChatInsertAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("chatList.chat")) {
				action = new ChatListAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (command.equals("chatAction.chat")) {
				action = new ChatAction();
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
