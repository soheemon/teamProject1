package kogile.kakaoOauth.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class kakaoOauthLoginAction implements Action {

	/*redirect시 요청하는 메서드*/
	private String redirectPath = "";
	private boolean isRedirect;

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		KakaoApi kakaoApi = new KakaoApi();
		kakaoApi.setRequest(request);
		
		//세션에 AccessToken 저장.
		kakaoApi.getAccessToken(request.getParameter("code"));
		
		HttpSession session = request.getSession();
		String ac = (String) session.getAttribute("access_token");
		//kakaoApi.
		//System.out.println(ac);
		//AccessToken을 받아서 그것으로 회원의 id를 조회한후에 이놈이 로그인하려는지, 회원가입하려는지 확인해야 한다.
		int userId = kakaoApi.tokenValidationCk();
		
		if(userId > 0) {
			//회원 ID를 가져왔으니 이거를 세션에 담아서 리다이렉트를 한다.
			session.setAttribute("kakaoId", userId);
			redirectPath = "ckKogileMem.kakaoOauth";
			isRedirect = true;
		}else {
			System.out.println("회원아이디를못가져왔쪄");
		}
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(redirectPath);
		forward.setRedirect(isRedirect);
		return forward;
	}
}
