package kogile.kakaoOauth.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class kakaoOauthLoginAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		KakaoApi kakaoApi = new KakaoApi();
		kakaoApi.setRequest(request);
		return null;
	}

}
