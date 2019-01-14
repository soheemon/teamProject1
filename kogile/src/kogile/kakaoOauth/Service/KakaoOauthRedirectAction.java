package kogile.kakaoOauth.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KakaoOauthRedirectAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		forward.setPath("https://kauth.kakao.com/oauth/authorize?"
				+ "client_id=e16764ac8ecc77d571c58088d37b119b&"
				+ "redirect_uri=http://localhost:8082/kogile/login.kakaoOauth&"
				+ "response_type=code");
		
		forward.setRedirect(true);
		return forward;
	}

}
