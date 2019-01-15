package kogile.kakaoOauth.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kogile.kakaoOauth.DAO.KaKaoDao;
import kogile.module.ExterMember;

public class KakaoChKogileMemAction implements Action {

	private String redirectPath = "";
	private boolean isRedirect;
	
	private static final String REGISTER_FORM_PATH = "view/registerForm.jsp";
	private static final String MAIN_PAGE = "view/KakaoOauthTest.jsp";
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//우선 세션에서 ID 가져오기.
		HttpSession session = request.getSession();
		int kakaoId = (int) session.getAttribute("kakaoId");
		
		ExterMember extermember = null;
		KaKaoDao dao = KaKaoDao.getInstance();
		extermember = dao.selectExterMember(kakaoId);
		//로그인 시도. 성공하면 session에 total_m_no라는 이름으로 사용자 ID를 넣습니다.
		if(extermember != null) {
			System.out.println("방문환영합니다." +extermember.getExter_m_email());
			System.out.println(extermember.getExter_mem_name());
			//로그인시 최종적으로 할일은.. 세션에 최종적으로 멤버 넘버를 넣어줍시다. total_m_no
			redirectPath = MAIN_PAGE;
			isRedirect = true;
		}else{
			System.out.println("회원가입이 안되어있네욤 회원가입 하러 갑시다.");
			redirectPath = REGISTER_FORM_PATH;
			isRedirect = true; //세션에 KaKaoId를 담은채로 로그인 폼으로 이동.
		}
		ActionForward forward = new ActionForward();
		forward.setPath(redirectPath);
		forward.setRedirect(isRedirect);
		return forward;
	}

}
