package kogile.kakaoOauth.Controller;

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


//@WebServlet("*.do")
public class exampleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public exampleController() {
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
