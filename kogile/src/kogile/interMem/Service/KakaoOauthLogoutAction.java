package kogile.interMem.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KakaoOauthLogoutAction implements Action {
	private String redirectPath = "";
	private boolean isRedirect;
	
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		InterMemApi kakaoApi = new InterMemApi();
		kakaoApi.setRequest(request);
		
		kakaoApi.logOut();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("access_token") == null) {
			System.out.println("로그아웃 성공");
			redirectPath = KakaoChKogileMemAction.MAIN_PAGE;
		}else {
			System.out.println("로그아웃 실패!");
		}
		ActionForward forward = new ActionForward();
		forward.setPath(redirectPath);
		forward.setRedirect(true);
		return forward;
	}
}
