package kogile.kakaoOauth.Controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kogile.kakaoOauth.Service.Action;
import kogile.kakaoOauth.Service.ActionForward;
import kogile.kakaoOauth.Service.KakaoOauthRedirectAction;


@WebServlet("*.kakaoOauth")
public class kakaoOauthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public kakaoOauthController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
    	String fullUri = request.getRequestURI();
    	
    	Pattern regex = Pattern.compile("(([a-z A-Z]+).kakaoOauth)");
    	Matcher regexMatcher = regex.matcher(fullUri);
    	
    	String command = "";
    	if(regexMatcher.find()) {
    		command = regexMatcher.group();
    	}
		System.out.println(command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command != null) {
			if(command.equals("redirect.kakaoOauth")) {
				 action = (Action) new KakaoOauthRedirectAction();
				 try {
					forward = ((KakaoOauthRedirectAction) action).excute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("login.kakaoOauth")) {
				System.out.println("login");
			}else if(command.equals("logout.kakaoOauth")) {
				System.out.println("logout");
			}else if(command.equals("register.kakaoOauth")) {
				System.out.println("register");
			}
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				try {
					response.sendRedirect(forward.getPath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				try {
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			System.out.println("test");
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		doGet(request, response);
	}

}
