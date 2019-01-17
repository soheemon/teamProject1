package kogile.startPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;

import kogile.startPage.Service.Action;
import kogile.startPage.Service.ActionForward;
import kogile.startPage.Service.Main;
import kogile.startPage.Service.ProAction;
import kogile.startPage.Service.ProFormAction;
import kogile.startPage.Service.StartPage;



@WebServlet("*.do")
public class startPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public startPageController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI().substring(request.getContextPath().length()+1);
		System.out.println(command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command != null) {
			if(command.equals("*.do")) {
//				Action action = *Action();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("proForm.do")) {
				action = new ProAction();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}else if(command.equals("proFormAction.do")) {
				action = new ProFormAction(); 
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("startPage.do")) {
				action = new StartPage();
				try {
					forward = action.excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("main.do")) {
				action = new Main();
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
