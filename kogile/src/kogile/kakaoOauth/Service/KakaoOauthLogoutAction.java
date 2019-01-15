package kogile.kakaoOauth.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KakaoOauthLogoutAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		KakaoApi kakaoApi = new KakaoApi();
		kakaoApi.setRequest(request);
		kakaoApi.logOut();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("access_token") == null) {
			System.out.println("로그아웃 성공");
		}else {
			System.out.println("로그아웃 실패!");
		}
		ActionForward forward = new ActionForward();
		forward.setPath("/view/KakaoOauthTest.jsp");
		forward.setRedirect(true);
		return forward;
	}

}
