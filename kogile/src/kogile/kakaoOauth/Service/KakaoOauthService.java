package kogile.kakaoOauth.Service;

import javax.servlet.http.HttpServletRequest;

import kogile.kakaoOauth.DAO.KaKaoDao;

public class KakaoOauthService {
	private static KakaoOauthService service = new KakaoOauthService();
	private static KaKaoDao dao;
	
	public static KakaoOauthService getInstance() {
		dao = KaKaoDao.getInstance();
		return service;
	}
	
	// 카카오로 회원가입 버튼 클릭 => 컨트롤러에 회원가입 만들기.
	// 로그인 페이지로 이동한다. => 로그인으로 리다이렉트
	// Access토큰을 얻으면 => 세션에서 토큰 저장하기.
	// 이메일이랑 이름 입력하게 하기. => 그리고 폼으로 이동해서 이메일이랑 이름 입력하게 하기
	// 회원id와 이메일과 이름을 DB에 저장하귀. => 그리고 최종적으로 레지스터서비스 실행하기. 이름 아뒤 이멜 kakao에서 주는 아뒤 넣기.

	public static void kakaoRegister(HttpServletRequest request) {
		//redirect
		Action action = new KakaoOauthRedirectAction();
		action.excute(request, response);
		
		KakaoApi kakaoapi = new KakaoApi();
		kakaoapi.setRequest(request);
		
	}
}
