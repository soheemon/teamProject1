package kogile.kakaoOauth.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KakaoOauthLogoutAction implements Action {
	private String redirectPath = "";
	private boolean isRedirect;
	
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		KakaoApi kakaoApi = new KakaoApi();
		kakaoApi.setRequest(request);
		
		kakaoApi.logOut();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("access_token") == null) {
			System.out.println("Ä«Ä«¿ÀÅå ·Î±×¾Æ¿ô ¼º°ø");
			redirectPath = KakaoChKogileMemAction.MAIN_PAGE;
		}else {
			System.out.println("Ä«Ä«¿ÀÅå ·Î±×¾Æ¿ô ½ÇÆÐ!");
		}
		
		//kogile logout!
		session.invalidate();
		
		ActionForward forward = new ActionForward();
		forward.setPath(redirectPath);
		forward.setRedirect(true);
		return forward;
	}
}
