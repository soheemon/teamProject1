package kogile.kakaoOauth.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class kakaoOauthLoginAction implements Action {

	private String redirectPath = "";
	private boolean isRedirect;
	
	//KaKaoOauth Redirect
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//회원가입 눌러도, 로그인 눌러도 DedirectAction 시키도록 합니다.
		
		KakaoApi kakaoApi = new KakaoApi();
		kakaoApi.setRequest(request);
		
		//Access토근을 받아온후, getAccessToken으로 세션에 AccessToken 저장.
		kakaoApi.getAccessToken(request.getParameter("code"));
		
		HttpSession session = request.getSession();
		
		//AccessToken을 받아서 그것으로 회원의 id를 조회한후에 이놈이 로그인하려는지, 회원가입하려는지 확인해야 한다.
		int userId = kakaoApi.tokenValidationCk();
		
		if(userId > 0) {
			//회원 ID를 가져왔으니 이거를 세션에 담아서 리다이렉트를 한다.
			session.setAttribute("kakaoId", userId);
			
			//회원가입을 시도하는건지, 로그인을 시도하는건지 확인한다.
			redirectPath = "ckKogileMem.kakaoOauth";
			isRedirect = true;
		}else {
			System.out.println("kakao tokenValidationCh error");
		}
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(redirectPath);
		forward.setRedirect(isRedirect);
		return forward;
	}
}
