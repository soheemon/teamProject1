package kogile.interMem.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kogile.interMem.Controller.InterMemController;
import kogile.interMem.Service.LoginPath;


@WebServlet("/logout")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에 Total..이 없다.
		//이제 이사람이 내부회원인지, 외부회원인지 판단해야 한다.
		System.out.println("logout!");
		boolean isInterMem = isInterMem(request, response);

		String Path ="";
		if(isInterMem){
			//바로 세션 만료하고 HOME으로 갑니다.
			System.out.println("내부회원 로그아웃 처리");
			Path = "view/" + "logout.interMem";
		}else{
			System.out.println("외부회원 로그아웃 처리");
			Path = "view/" + "logout.kakaoOauth";
		}
		
		response.sendRedirect(Path);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected boolean isInterMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		boolean res = false;
		HttpSession session = request.getSession();
		
		//세션에 kakaoId가 있다면 외부회원이다라고 판단.
		Object kakaoId = null;
		if((kakaoId = session.getAttribute("kakaoId")) == null) {
			res = true;
		}	
		return res;
	}
}
